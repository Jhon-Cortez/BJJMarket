#!/usr/bin/env bash
# Despliega BJJMarket en un servidor Ubuntu (por ejemplo, una máquina de KillerCoda).
# Uso:
#   curl -fsSL https://raw.githubusercontent.com/Jhon-Cortez/BJJMarket/develop/scripts/deploy-ubuntu.sh | bash
# O, después de clonar el proyecto:
#   ./scripts/deploy-ubuntu.sh

set -Eeuo pipefail

REPOSITORY="${BJJ_REPOSITORY:-https://github.com/Jhon-Cortez/BJJMarket.git}"
BRANCH="${BJJ_BRANCH:-develop}"
INSTALL_DIR="${BJJ_INSTALL_DIR:-/opt/bjjmarket}"

info() { printf '\n==> %s\n' "$*"; }
fail() { printf '\nError: %s\n' "$*" >&2; exit 1; }

if ! command -v sudo >/dev/null 2>&1 && [ "$(id -u)" -ne 0 ]; then
  fail "Se requieren permisos de administrador para instalar Docker."
fi

SUDO=()
[ "$(id -u)" -ne 0 ] && SUDO=(sudo)

if ! command -v apt-get >/dev/null 2>&1; then
  fail "Este script solo está preparado para Ubuntu/Debian (apt-get)."
fi

if ! command -v git >/dev/null 2>&1 || ! command -v docker >/dev/null 2>&1; then
  info "Instalando Git y Docker"
  "${SUDO[@]}" apt-get update
  "${SUDO[@]}" env DEBIAN_FRONTEND=noninteractive apt-get install -y git docker.io curl
fi

if ! command -v docker >/dev/null 2>&1; then
  fail "Docker no pudo instalarse. Revisa la salida de apt-get."
fi

"${SUDO[@]}" systemctl enable --now docker 2>/dev/null || true

DOCKER=(docker)
if ! docker info >/dev/null 2>&1; then
  DOCKER=("${SUDO[@]}" docker)
fi

if ! "${DOCKER[@]}" compose version >/dev/null 2>&1; then
  info "Instalando el complemento Docker Compose"
  "${SUDO[@]}" apt-get update
  "${SUDO[@]}" apt-get install -y docker-compose-v2 || fail "No fue posible instalar Docker Compose v2."
fi

if [ -d "$INSTALL_DIR/.git" ]; then
  info "Actualizando el código en $INSTALL_DIR"
  git -C "$INSTALL_DIR" fetch origin "$BRANCH"
  git -C "$INSTALL_DIR" checkout "$BRANCH"
  git -C "$INSTALL_DIR" pull --ff-only origin "$BRANCH"
else
  info "Clonando BJJMarket en $INSTALL_DIR"
  "${SUDO[@]}" mkdir -p "$(dirname "$INSTALL_DIR")"
  "${SUDO[@]}" git clone --branch "$BRANCH" --single-branch "$REPOSITORY" "$INSTALL_DIR"
  "${SUDO[@]}" chown -R "$(id -u):$(id -g)" "$INSTALL_DIR" 2>/dev/null || true
fi

ENV_FILE="$INSTALL_DIR/backend/src/main/resources/.env"
if [ ! -f "$ENV_FILE" ] || ! grep -q '^DB_URL=jdbc:postgresql://postgres:5432/bjjmarket$' "$ENV_FILE"; then
  info "Creando la configuración local del backend"
  # El password coincide con PostgreSQL definido actualmente en docker-compose.yml.
  # Se puede cambiar en ambos sitios antes de ejecutar el script si se requiere.
  JWT_SECRET="$(openssl rand -hex 32 2>/dev/null || date +%s%N)"
  umask 077
  {
    printf '%s\n' 'DB_URL=jdbc:postgresql://postgres:5432/bjjmarket'
    printf '%s\n' 'DB_USER=bjjmarket'
    printf '%s\n' 'DB_PASSWORD=BjjMarket2026!'
    printf 'JWT_SECRET=%s\n' "$JWT_SECRET"
  } > "$ENV_FILE"
fi

info "Construyendo e iniciando los servicios"
cd "$INSTALL_DIR"
"${DOCKER[@]}" compose up -d --build --remove-orphans

info "Estado de los contenedores"
"${DOCKER[@]}" compose ps

SERVER_IP="$(hostname -I 2>/dev/null | awk '{print $1}')"
SERVER_IP="${SERVER_IP:-<IP_DEL_SERVIDOR>}"

printf '\nDespliegue terminado.\n'
printf 'Frontend: http://%s:5173\n' "$SERVER_IP"
printf 'Backend:  http://%s:9090\n' "$SERVER_IP"
printf 'Swagger:  http://%s:9090/swagger-ui/index.html\n' "$SERVER_IP"
printf '\nPara ver registros: cd %s && %s compose logs -f\n' "$INSTALL_DIR" "${DOCKER[*]}"

import { useState } from "react";
import type { FormEvent } from "react";
import { Link, useNavigate } from "react-router-dom";
import { isAxiosError } from "axios";
import { useAuth } from "../../context/AuthContext";
import "./Auth.css";

const initialForm = {
  name: "",
  lastName: "",
  birthDate: "",
  phone: "",
  email: "",
  username: "",
  password: "",
};

const Register = () => {
  const [form, setForm] = useState(initialForm);
  const [error, setError] = useState<string | null>(null);
  const [success, setSuccess] = useState(false);
  const [submitting, setSubmitting] = useState(false);
  const { register } = useAuth();
  const navigate = useNavigate();

  const handleChange = (field: keyof typeof initialForm) => (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm((prev) => ({ ...prev, [field]: e.target.value }));
  };

  const handleSubmit = async (event: FormEvent) => {
    event.preventDefault();
    setError(null);
    setSubmitting(true);
    try {
      await register(form);
      setSuccess(true);
      setTimeout(() => navigate("/login"), 1200);
    } catch (err) {
      let message = "No se pudo completar el registro";
      if (isAxiosError(err)) {
        const errors = err.response?.data?.errors;
        message = errors ? Object.values(errors).join(", ") : err.response?.data?.message ?? message;
      }
      setError(message);
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <div className="auth-page">
      <form className="auth-card" onSubmit={handleSubmit}>
        <h1>Crear cuenta</h1>
        {error && <div className="auth-error">{error}</div>}
        {success && <div className="auth-success">¡Registro exitoso! Redirigiendo al login...</div>}
        <label>
          Nombre
          <input value={form.name} onChange={handleChange("name")} required />
        </label>
        <label>
          Apellido
          <input value={form.lastName} onChange={handleChange("lastName")} required />
        </label>
        <label>
          Fecha de nacimiento
          <input type="date" value={form.birthDate} onChange={handleChange("birthDate")} required />
        </label>
        <label>
          Teléfono
          <input value={form.phone} onChange={handleChange("phone")} required />
        </label>
        <label>
          Email
          <input type="email" value={form.email} onChange={handleChange("email")} required />
        </label>
        <label>
          Usuario
          <input value={form.username} onChange={handleChange("username")} required />
        </label>
        <label>
          Contraseña
          <input type="password" value={form.password} onChange={handleChange("password")} required />
        </label>
        <button type="submit" disabled={submitting}>
          {submitting ? "Creando cuenta..." : "Registrarme"}
        </button>
        <p>
          ¿Ya tienes cuenta? <Link to="/login">Inicia sesión</Link>
        </p>
      </form>
    </div>
  );
};

export default Register;

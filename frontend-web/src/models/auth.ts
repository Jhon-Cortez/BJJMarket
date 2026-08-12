export type LoginRequest = {
  username: string;
  password: string;
};

export type RegisterRequest = {
  name: string;
  lastName: string;
  birthDate: string;
  phone: string;
  email: string;
  username: string;
  password: string;
};

export type LoginResponse = {
  token: string;
  username: string;
  roles: string[];
};

export type AuthUser = {
  username: string;
  roles: string[];
};

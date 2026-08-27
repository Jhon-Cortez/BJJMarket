import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    // Dominios temporales generados por los laboratorios de KillerCoda.
    allowedHosts: ['.saci.r.killercoda.com'],
  },
})

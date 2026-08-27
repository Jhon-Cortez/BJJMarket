import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    // Dominios temporales generados por los laboratorios de KillerCoda.
    allowedHosts: ['.saci.r.killercoda.com'],
    // Evita que el navegador tenga que acceder al backend HTTP directamente.
    proxy: {
      '/api': {
        target: 'http://backend:9090',
        changeOrigin: true,
      },
    },
  },
})

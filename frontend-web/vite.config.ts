import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],

  server: {
    host: '0.0.0.0',

    allowedHosts: ['.saci.r.killercoda.com'],

    proxy: {
      '/api': {
        target: 'http://backend:9090',
        changeOrigin: true,
      },
    },
  },
})
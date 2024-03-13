/** @type {import('next').NextConfig} */
const nextConfig = {
  output: 'standalone',
  reactStrictMode: true, 
    eslint: { 
      ignoreDuringBuilds: true, 
    },
  experimental: {
    ppr: false
  }
};

module.exports = nextConfig;

const PROXY_CONFIG = [
  {
    context: ["/api/station", "/api/weather"],
    target: "http://localhost:8200",
    secure: false,
    changeOrigin: true,
    logLevel: "debug",
  },
  {
    context: ["/api/map"],
    target: "http://localhost:8100",
    secure: false,
    changeOrigin: true,
    logLevel: "debug",
  },
];

module.exports = PROXY_CONFIG;

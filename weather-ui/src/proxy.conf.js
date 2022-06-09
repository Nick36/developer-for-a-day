const PROXY_CONFIG = [
  {
    context: ["/api/station", "/api/weather"],
    target: "http://172.20.233.223:8200",
    secure: false,
    changeOrigin: true,
    logLevel: "debug",
  },
  {
    context: ["/api/map"],
    target: "http://172.20.233.223:8100",
    secure: false,
    changeOrigin: true,
    logLevel: "debug",
  },
];

module.exports = PROXY_CONFIG;

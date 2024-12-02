const express = require("express");
const soap = require("soap");
const http = require("http");
const path = require("path");
const sequelize = require("./db"); // Import database connection
const clientService = require("./services/clientService"); // Import SOAP service
const fs = require("fs");

const wsdlPath = path.join(__dirname, "wsdl", "client.wsdl");
const wsdl = fs.readFileSync(wsdlPath, "utf8");

const app = express();
const server = http.createServer(app);

// Create SOAP server
soap.listen(server, "/client", clientService, wsdl);

const port = 8000;
server.listen(port, async () => {
  try {
    await sequelize.authenticate();
    console.log(`SOAP service running on http://localhost:${port}/client?wsdl`);
  } catch (err) {
    console.error("Database connection error:", err);
  }
});

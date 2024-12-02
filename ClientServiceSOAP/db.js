const { Sequelize } = require("sequelize");

const sequelize = new Sequelize(
  "postgres://postgres:anis56423679@localhost:5432/systemebancaire"
);

module.exports = sequelize;

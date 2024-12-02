const { DataTypes } = require('sequelize');
const sequelize = require('../config/database');

const Client = sequelize.define('Client', {
    numCompte: {
        type: DataTypes.STRING,
        primaryKey: true,
        allowNull: false,
    },

    nom: {
        type: DataTypes.STRING,
        allowNull: false,
    },

    prenom: {
        type: DataTypes.STRING,
        allowNull: false,
    },

    cin: {
        type: DataTypes.STRING,
        allowNull: false,
    },

    adresse: {
        type: DataTypes.STRING,
        allowNull: false,
    },

    telephone: {
        type: DataTypes.STRING,
        allowNull: false,
    },

    email: {
        type: DataTypes.STRING,
        allowNull: false,
        validate: {
            isEmail: true,
        },
    },
});

module.exports = Client;
const Client = require('../models/client');

exports.getAllClients = async (req, res) => {
    try {
        const clients = await Client.findAll();
        res.status(200).json(clients);
    } catch (error) {
        res.status(500).json({error: error.message});
    }
};

exports.getClientByNumCompte = async (req, res) => {
    try {
        const client = await Client.findByPk(req.params.numCompte);
        if (client) {
            res.status(200).json(client);
        } else {
            res.status(400).json({message: 'Client not found'});
        }
    } catch (error) {
        res.status(500).json({error: error.message});
    }
};

exports.addClient = async (req, res) => {
    try {
        const client = await Client.create(req.body);
        res.status(200).json(client);
    } catch (error) {
        res.status(500).json({error: error.message});
    }
};

exports.deleteClient = async (req, res) => {
    try {
        const client = await Client.findByPk(req.params.numCompte);
        if (client) {
            await client.destroy();
            res.status(200).send();
        } else {
            res.status(400).json({message: 'Client not found'});
        }
    } catch (error) {
        res.status(500).json({error: error.message});
    }
};
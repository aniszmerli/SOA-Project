const Client = require("../models/client");

const clientService = {
  ClientWebService: {
    ClientWebServicePort: {
      GetAllClients: async () => {
        try {
          const clients = await Client.findAll();
          const clientsList = clients.map((client) => ({
            num_compte: client.num_compte,
            nom: client.nom,
            prenom: client.prenom,
            cin: client.cin,
            adresse: client.adresse,
            telephone: client.telephone,
            email: client.email,
          }));
          return { clients: clientsList };
        } catch (error) {
          throw new Error(`Error fetching clients: ${error.message}`);
        }
      },

      GetClientByNumCompte: async (args) => {
        try {
          const client = await Client.findByPk(args.num_compte);
          if (client) {
            return { client: { ...client.dataValues } };
          } else {
            throw new Error("Client not found");
          }
        } catch (error) {
          throw new Error(`Error fetching client: ${error.message}`);
        }
      },

      AddClient: async (args) => {
        try {
          const newClient = await Client.create(args.client);
          return { client: { ...newClient.dataValues } };
        } catch (error) {
          throw new Error(`Error adding client: ${error.message}`);
        }
      },

      DeleteClient: async (args) => {
        try {
          const client = await Client.findByPk(args.num_compte);
          if (client) {
            await client.destroy();
            return { success: true };
          } else {
            throw new Error("Client not found");
          }
        } catch (error) {
          throw new Error(`Error deleting client: ${error.message}`);
        }
      },
    },
  },
};

module.exports = clientService;

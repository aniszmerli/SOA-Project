const express = require('express');
const clientController = require('../controllers/clientController');

const router = express.Router();

router.get('/all', clientController.getAllClients);
router.get('/:numCompte', clientController.getClientByNumCompte);
router.post('/add', clientController.addClient);
router.delete('/delete/:numCompte', clientController.deleteClient);

module.exports = router;
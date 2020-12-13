var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Componente = require('../models').Componente;


router.post('/recuperar', function (req, res, next) {
    console.log(`Recuperando dados do computador ${req.body.fkComputador}`);
    let instrucaoSql = `select * from Componente where fkComputador='${req.body.fkComputador}'`;

    sequelize.query(instrucaoSql, {
        model: Componente
    }).then(resultado => {
        Componente.findAll({ where: { fkComputador: req.body.fkComputador } }).then(resultado => {
            res.json(resultado);
        }).catch(erro => {
            console.error(erro);
            res.status(500).send(erro.message);
        });

    }).catch(erro => {
        console.error(erro);
        res.status(500).send(erro.message);
    });
});


module.exports = router;
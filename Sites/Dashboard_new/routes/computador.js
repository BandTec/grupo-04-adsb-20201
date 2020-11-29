var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Computador = require('../models').Computador;


router.get('/recuperar/:fkEscola', function (req, res, next) {
    console.log('Recuperando computadores pelo fkEscola');
    let instrucaoSql = `select * from Computador where fkEscola='${req.params.fkEscola}'`;

    sequelize.query(instrucaoSql, {
        model: Computador
    }).then(resultado => {
        Computador.findAll({ where: { fkEscola: req.params.fkEscola } }).then(resultado => {
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
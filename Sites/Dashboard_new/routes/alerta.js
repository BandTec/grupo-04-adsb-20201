var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Alerta = require('../models').Alerta;
var Computador = require('../models').Computador;

router.get('/recuperar/alertas', function (req, res, next) {
    console.log(`Recuperando Alertas de uma máquina especifica`);
    const hoje = new Date();
    const hojeSqll = `${hoje.getFullYear()}-${hoje.getMonth() + 1}-${hoje.getDate()}`;
    let instrucaoSql = `select * from Alerta, Computador where idComputador = fkComputador and
    dataHora between '${hojeSqll} 00:00:00' and '${hojeSqll} 23:59:59';`;
    console.log("Instrucao" + instrucaoSql);
    sequelize.query(instrucaoSql, {
        model: Alerta
    }).then(resultado => {
        Alerta.findAll({
            include: [{
                model: Computador,
                required: true
            }]
        }).then(resultado => {
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

router.get('/recuperar_maquina_especifica/:idComputador', function (req, res, next) {
    console.log(`Recuperando Alertas`);
    let instrucaoSql = `select * from Alerta, Computador where idComputador = ${req.params.idComputador} and idComputador = fkComputador;`;

    sequelize.query(instrucaoSql, {
        model: Alerta
    }).then(resultado => {
        res.send(resultado);
    }).catch(erro => {
        console.error(erro);
        res.status(500).send(erro.message);
    });
});

module.exports = router;


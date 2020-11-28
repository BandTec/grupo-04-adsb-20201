var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var usoTotal = require('../models').usoTotal;


router.post('/recuperarCPU', function (req, res, next) {
    console.log(`Recuperando uso da CPU`);
    let instrucaoSql = `select * from UsoTotal where tipoComponente='Processador' and fkComputador=${req.body.fkComputador} order by idUsoAtual desc LIMIT 3;`;

    sequelize.query(instrucaoSql, {
        model: usoTotal
    }).then(resultado => {
        res.send(resultado);
    }).catch(erro => {
        console.error(erro);
        res.status(500).send(erro.message);
    });
});


module.exports = router;
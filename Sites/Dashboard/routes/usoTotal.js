var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var usoTotal = require('../models').usoTotal;


router.get('/recuperarCPU', function (req, res, next) {
    console.log(`Recuperando uso da CPU`);
    let instrucaoSql = `select * from UsoTotal where tipoComponente='Processador' order by idUsoAtual desc LIMIT 1;`;

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
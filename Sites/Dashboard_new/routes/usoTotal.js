var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var usoTotal = require('../models').usoTotal;


router.get('/recuperarCPU/:idComputador', function (req, res, next) {
    console.log(`Recuperando uso da CPU`);
    let instrucaoSql = `select top 1' * from UsoTotal, Componente where Componente.tipoComponente='Processador' and Componente.fkComputador=${req.params.idComputador} order by idUsoAtual desc;`;

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
var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var usoTotal = require('../models').usoTotal;


router.get('/recuperar/:idComputador/:tipoComponente', function (req, res, next) {
    console.log(`Recuperando uso da CPU`);
    let instrucaoSql = `select top 5 * from UsoTotal, Componente where Componente.tipoComponente='${req.params.tipoComponente}' and 
    Componente.fkComputador=${req.params.idComputador} and Componente.idComponente = UsoTotal.fkComponente order by idUsoAtual desc;`;

    sequelize.query(instrucaoSql, {
        model: usoTotal
    }).then(resultado => {
        res.send(resultado);
    }).catch(erro => {
        console.error(erro);
        res.status(500).send(erro.message);
    });
});

router.get('/recuperar_media/:idComputador', function (req, res, next) {
    console.log(`Recuperando média`);
    const hoje = new Date();
    const hojeSqll = `${hoje.getFullYear()}-${hoje.getMonth() + 1}-${hoje.getDate()}`;
    let instrucaoSql = `select AVG(ut.usoComponente) as usoComponente from UsoTotal ut, Componente c where c.tipoComponente = 'CPU' and 
    ut.fkComponente = c.idComponente and c.fkComputador = ${req.params.idComputador} and
    ut.dataHora between '${hojeSqll} 00:00:00' and '${hojeSqll} 23:59:59';`;

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
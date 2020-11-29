var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Tecnico = require('../models').Tecnico;

let sessoes = [];

function setOnlineTec(login, senha) {
	let instrucaoSql = `update tecnico set disponibilidade = 1 where emailTec='${login}' and senhaTec='${senha}'`;
	sequelize.query(instrucaoSql, {
		model: Tecnico
	}).then(resultado => {
		console.log(`Tecnico com login: ${login} está online`)

	}).catch(erro => {
		console.log(`Erro ao colocar Tecnico com login: ${login} como online`)

		console.error(erro);
		res.status(500).send(erro.message);
	});
}

function setOfflineTec(login) {
	let instrucaoSql = `update tecnico set disponibilidade = 0 where emailTec='${login}'`;
	sequelize.query(instrucaoSql, {
		model: Tecnico
	}).then(resultado => {
		console.log(`Tecnico com login: ${login} está offline`)

	}).catch(erro => {
		console.log(`Erro ao colocar Tecnico com login: ${login} como offline`)

		console.error(erro);
		res.status(500).send(erro.message);
	});
}

/* Recuperar usuário por login e senha */
router.post('/autenticar', function (req, res, next) {
	console.log('Recuperando tecnico por login e senha');

	var login = req.body.login; // depois de .body, use o nome (name) do campo em seu formulário de login
	var senha = req.body.senha; // depois de .body, use o nome (name) do campo em seu formulário de login	
	console.log(login);

	let instrucaoSql = `select * from tecnico, escola where emailTec='${login}' and senhaTec='${senha}' and fkEscola = idEscola`;
	sequelize.query(instrucaoSql, {
		model: Tecnico
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		if (resultado.length == 1) {
			console.log(resultado[0].dataValues.emailTec);
			sessoes.push(resultado[0].dataValues.emailTec);
			console.log('sessoes: ', sessoes);
			setOnlineTec(login, senha)
			res.json(resultado[0]);
		} else if (resultado.length == 0) {
			res.status(403).send('Login e/ou senha inválido(s)');
		} else {
			res.status(403).send('Mais de um usuário com o mesmo login e senha!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});
router.get('/sessao/:login', function (req, res, next) {
	let login = req.params.login;
	console.log(`Verificando se o usuário ${login} tem sessão`);

	let tem_sessao = false;
	for (let u = 0; u < sessoes.length; u++) {
		if (sessoes[u] == login) {
			tem_sessao = true;
			break;
		}
	}

	if (tem_sessao) {
		let mensagem = `Usuário ${login} possui sessão ativa!`;
		console.log(mensagem);

		res.send(mensagem);
	} else {
		res.sendStatus(403);
	}

});

router.get('/sair/:login', function (req, res, next) {
	let login = req.params.login;
	console.log(`Finalizando a sessão do usuário ${login}`);
	let nova_sessoes = []
	for (let u = 0; u < sessoes.length; u++) {
		if (sessoes[u] != login) {
			nova_sessoes.push(sessoes[u]);
		}
	}
	setOfflineTec(login);
	sessoes = nova_sessoes;
	res.send(`Sessão do usuário ${login} finalizada com sucesso!`);
});


module.exports = router;


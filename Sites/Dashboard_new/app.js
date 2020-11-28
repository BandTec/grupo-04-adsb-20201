process.env.NODE_ENV = 'production';

var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

var indexRouter = require('./routes/index');
var usuariosRouter = require('./routes/tecnico');
var computadorRouter = require('./routes/computador');
var componenteRouter = require('./routes/componente');
var usoTotalRouter = require('./routes/usoTotal');


var app = express();

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/tecnico', usuariosRouter);
app.use('/computador', computadorRouter);
app.use('/componente', componenteRouter);
app.use('/usoTotal', usoTotalRouter);

module.exports = app;

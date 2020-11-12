
create table Escola (
	idEscola int primary key auto_increment,
	nomeEscola varchar(45),
	telefone char(11),
	nomeDiretor varchar(45),
	rua varchar(45),
	bairro varchar(20),
	estado char(2),
	cidade varchar(30),
	cep char(8),
	chaveAcesso varchar(16)
);

create table Tecnico (
	idTecnico int primary key auto_increment,
	nomeTecnico varchar(45),
	telefoneTec char(11),
	emailTec varchar(45),
	senhaTec varchar(25),
	fkEscola int,
	foreign key (fkEscola) references Escola(idEscola)
);

create table Computador (
	idComputador int primary key auto_increment,
	nomeComputador varchar(15),
	fkEscola int,
	foreign key (fkEscola) references Escola(idEscola)
);

create table Blacklist (
	idBlacklist int primary key auto_increment,
	nomeProcesso varchar(45)
	);
	
create table Computador_has_Blacklist (
	idCompBlack int primary key auto_increment,
	fkComputador int,
    foreign key (idCompBlack) references Computador(idComputador),
	fkBlacklist int,
    foreign key (fkBlacklist) references Blacklist(idBlacklist)
);

create table Componente (
	idComponente int primary key auto_increment,
    nomeComponente varchar(45),
    tipoComponente varchar(20),
    fkComputador int,
    foreign key (fkComputador) references Computador(idComputador)
);

create table UsoAtual (
	idUsoAtual int primary key auto_increment,
	usoComponente int,
	dataHora datetime,
	fkComputador int,
	foreign key (fkComputador) references Computador(idComputador),
    fkComponente int,
    foreign key (fkComponente) references Componente(idComponente)
);

create table Processo (
	idProcesso int primary key auto_increment,
	nomeProcesso varchar(20),
	dataHora datetime,
	memoriaProcesso decimal(10,2),
	fkComputador int,
	foreign key (fkComputador) references Computador(idComputador)
);
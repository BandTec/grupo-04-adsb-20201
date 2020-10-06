

create table Pacote (
	idPacote int primary key identity,
	nomePacote varchar(15),
	qtdDevices Int
);

create table Escola (
	idEscola int primary key identity,
	nomeEscola varchar(45),
	telefone char(11),
	nomeDiretor varchar(45),
	rua varchar(45),
	bairro varchar(20),
	estador char(2),
	cidade varchar(30),
	cep char(8),
	chaveAcesso varchar(16),
	fkPacote int,
	foreign key (fkPacote) references Pacote(idPacote)
);

create table Tecnico (
	idTecnico int primary key identity,
	nomeTecnico varchar(45),
	telefoneTec char(11),
	emailTec varchar(45),
	senhaTec varchar(25),
	fkEscola int,
	foreign key (fkEscola) references Escola(idEscola)
);

create table Computador (
	idComputador int primary key identity,
	nomeComputador varchar(15),
	processador varchar(45),
	memoria int,
	fkEscola int,
	foreign key (fkEscola) references Escola(idEscola)
);

create table Log (
	idLog int primary key identity,
	tipoFalha varchar(20),
	tempCpu decimal(10,2),
	tempHD decimal(10,2),
	usoCPU decimal(10,2),
	usoRam decimal(10,2),
	dataHora datetime,
	fkComputador int,
	foreign key (fkComputador) references Computador(idComputador)
);

create table Blacklist (
	idBlacklist int primary key identity,
	nomeProcesso varchar(45)
	);
	
create table Computador_has_Blacklist (
	idCompBlack int primary key identity,
	fkComputador int,
	fkBlacklist int,
);

create table UsoTotal (
	idUsoTotal int primary key identity,
	nomeComponente varchar(45),
	usoComponente int,
	dataHora datetime,
	fkComputador int,
	foreign key (fkComputador) references Computador(idComputador)
);

create table Lote (
	idLote int primary key identity,
	dataHora datetime,
	fkComputador int,
	foreign key (fkComputador) references Computador(idComputador)
);

create table Processo (
	idProcesso int primary key identity,
	nomeProcesso varchar(20),
	dataHora datetime,
	memoriaProcesso decimal(10,2),
	fkLote int,
	foreign key (fkLote) references Lote(idLote)
);































create database mind6;
use mind6;
create table Escola (
	idEscola int primary key auto_increment,
	nomeEscola varchar(45),
	telefone char(11),
	nomeDiretor varchar(45),
	rua varchar(45),
	bairro varchar(20),
	estado char(2),
	cidade varchar(30),
	cep char(8)
);

insert into Escola values 
	(null, 'Barão de Ramalho', '1123456543', 'Vera','Antonio Carlos 546', 'Penha', 'SP', 'São Paulo','03612450'),
    (null, 'Guilherme de Almeida', '1103849117', 'Arlene', 'Av Governador Carvalho Pinto', 'Penha', 'SP', 'São Paulo', '03612789');

create table Tecnico (
	idTecnico int primary key auto_increment,
	nomeTecnico varchar(45),
	telefoneTec char(11),
	emailTec varchar(45),
	senhaTec varchar(25),
	fkEscola int,
	foreign key (fkEscola) references Escola(idEscola)
);
select * from Tecnico where emailTec='cesar.augustus@gmail.com' and senhaTec='qualquerSenha';
insert into Tecnico values 
	(null, 'Claudio Santos', '1172049195', 'claudio.santos@gmail.com', 'urubu100', 3),
    (null, 'Cesar Augustus', '1145456276', 'cesar.augustus@gmail.com', 'qualquerSenha', 4);

create table Computador (
	idComputador int primary key auto_increment,
	nomeComputador varchar(15),
	fkEscola int,
	foreign key (fkEscola) references Escola(idEscola)
);
select * from Computador;
insert into Computador values 
	(null, 'PC01SLA1', 3),
    (null, 'PC02SLA1', 3),
    (null, 'PC03SLA1', 3),
    (null, 'PC04SLA1', 3),
    (null, 'PC05SLA1', 3),
    (null, 'PC06SLA1', 3),
    (null, 'PC07SLA1', 3),
    (null, 'PC08SLA1', 3),
    (null, 'PC09SLA1', 3),
    (null, 'PC01SLA1', 4),
    (null, 'PC02SLA1', 4),
    (null, 'PC03SLA1', 4),
    (null, 'PC04SLA1', 4),
    (null, 'PC05SLA1', 4),
    (null, 'PC06SLA1', 4),
    (null, 'PC07SLA1', 4),
    (null, 'PC08SLA1', 4),
    (null, 'PC09SLA1', 4);
select * from Computador where fkEscola = 4;

create table Blacklist (
	idBlacklist int primary key auto_increment,
	nomeProcesso varchar(45)
	);
    
insert into Blacklist values 
	(null, 'Discord'),
    (null, 'Valorant'),
    (null, 'Minecraft'),
    (null, 'Counter Strike'),
    (null, 'Paladins'),
    (null, 'PUBG Lite');
    
	
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

insert into Componente values 
	(null, "AMD Ryzen 9900K", "Processador", 28),
    (null, "Microsoft Windows 10 Home", "SO", 28),
    (null, "Intel Corr I5", "Processador", 29),
    (null, "Microsoft Windows 10 Pro", "SO", 29);
    
insert into Componente value (null, "SSD 500G", "Memoria", 28);    

select * from Componente;

create table UsoTotal (
	idUsoAtual int primary key auto_increment,
	nomeComponente varchar(45),
	usoComponente int,
    tipoComponente varchar(20),
	dataHora datetime,
	fkComputador int,
	foreign key (fkComputador) references Computador(idComputador)
);

select * from UsoTotal;


insert into UsoTotal values
    (null, "AMD Ryzen 9900K", 70,'Processador', '2020-11-25 20:05:00', 29);	
    
    insert into UsoTotal values
    (null, "AMD Ryzen 9900K", 30,'Processador', '2020-11-25 20:08:00', 29);
    insert into UsoTotal values
    (null, "AMD Ryzen 9900K", 50,'Processador', '2020-11-25 20:10:00', 29);
    insert into UsoTotal values
    (null, "AMD Ryzen 9900K", 60,'Processador', '2020-11-28 15:00:00', 29);
    insert into UsoTotal values
    (null, "AMD Ryzen 9900K", 70,'Processador', '2020-11-28 15:30:00', 29);
    
select * from UsoTotal;

create table Processo (
	idProcesso int primary key auto_increment,
	nomeProcesso varchar(20),
	dataHora datetime,
	memoriaProcesso decimal(10,2),
	fkComputador int,
	foreign key (fkComputador) references Computador(idComputador)
);

select * from UsoTotal where tipoComponente='Processador' order by idUsoAtual desc LIMIT 1;
select * from UsoTotal where tipoComponente='Processador' and fkComputador=29 order by idUsoAtual desc limit 5;
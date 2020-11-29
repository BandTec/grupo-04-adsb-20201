create database mind6;
use mind6;
-- drop database mind6;
create table Escola (
	idEscola int primary key auto_increment not null,
	nomeEscola varchar(45) not null,
	telefone char(11) not null,
	nomeDiretor varchar(45) not null,
	rua varchar(45) not null,
	bairro varchar(20) not null,
	estado char(2) not null,
	cidade varchar(30) not null,
	cep char(8) not null
);

insert into Escola values 
	(null, 'Barão de Ramalho', '1123456543', 'Vera','Antonio Carlos 546', 'Penha', 'SP', 'São Paulo','03612450'),
    (null, 'Guilherme de Almeida', '1103849117', 'Arlene', 'Av Governador Carvalho Pinto', 'Penha', 'SP', 'São Paulo', '03612789');

create table Tecnico (
	idTecnico int primary key auto_increment not null,
	nomeTecnico varchar(45) not null,
	telefoneTec char(11) not null,
	emailTec varchar(45) not null,
	senhaTec varchar(25) not null,
    disponibilidade boolean not null,
    fkGestor int,
	fkEscola int not null,
	foreign key (fkEscola) references Escola(idEscola),
    foreign key (fkGestor) references Tecnico(idTecnico)
);
select * from Tecnico where emailTec='cesar.augustus@gmail.com' and senhaTec='qualquerSenha';
insert into Tecnico values 
	(null, 'Lucas Felipe', '1172049195', 'claudio.santos@gmail.com', 'urubu100', 0, null, 1),
    (null, 'Cesar Augustos', '1145456276', 'mind6@gmail.com', 'qualquerSenha', 0, 1, 1),
    (null, 'Lucas Felipe', '1172049195', 'claudio.santos@gmail.com', 'urubu100', 0, null, 2),
    (null, 'Cesar Augustos', '1145456276', 'mind6@gmail.com', 'qualquerSenha', 0, 3, 2);

create table Computador (
	idComputador int primary key auto_increment not null,
	nomeComputador varchar(15) not null,
	fkEscola int not null,
    sistemaOperacional varchar(15) not null,
    ipv4 varchar(15) not null,
    disonibilidade boolean not null,
    serialNum varchar(35) not null,
	foreign key (fkEscola) references Escola(idEscola)
);


select * from Computador;
insert into Computador values 
	(null, 'PC01SLA1', 1, "Windows 10", "192.168.052.01", 1, "NXGQCAL004741692029501"),
    (null, 'PC02SLA1', 1, "Windows 7", "192.168.053.02", 1, "ZXGQCAL004743401029501"),
    (null, 'PC03SLA1', 1, "Windows 10", "192.168.062.08", 1, "NXGQCAL004741692029501"),
    (null, 'PC04SLA1', 1, "Ubuntu Linux", "192.168.103.02", 1, "NXGQCAL004741691029501"),
    (null, 'PC05SLA1', 1, "Windows 7", "192.168.040.02", 0, "NXGQCAL004741692023501"),
    (null, 'PC06SLA1', 1, "Windows 10", "192.168.353.02", 1, "NXGQCAL004741692459501"),
    (null, 'PC07SLA1', 1, "Windows 10", "192.168.222.02", 1, "NXGQCAL004741692679501"),
    (null, 'PC08SLA1', 1, "Windows 7", "192.168.353.02", 1, "NXGQCAL004741692089501"),
    (null, 'PC09SLA1', 1, "Ubuntu Linux", "192.168.325.02", 1, "NXGQCAL004741609029501"),
    (null, 'PC01SLA1', 2, "Ubuntu Linux", "192.178.053.02", 1, "NXGQCAL004741612029501"),
    (null, 'PC02SLA1', 2, "Ubuntu Linux", "192.179.053.02", 1, "NXGQCAL004741645029501"),
    (null, 'PC03SLA1', 2, "Windows 10", "192.153.063.02", 0, "NXGQCAL004741692259501"),
    (null, 'PC04SLA1', 2, "Ubuntu Linux", "192.175.080.02", 1, "NXGQCAL004741636029501"),
    (null, 'PC05SLA1', 2, "Windows 7", "192.173.181.02", 0, "NXGQCAL004741692034501"),
    (null, 'PC06SLA1', 2, "Windows 7", "192.172.053.02", 1, "NXGQCAL004741692078501"),
    (null, 'PC07SLA1', 2, "Ubuntu Linux", "192.172.350.02", 1, "NXGQCAL004741647029501"),
    (null, 'PC08SLA1', 2, "Windows 7", "192.172.001.02", 0, "NXGQCAL004741692097501"),
    (null, 'PC09SLA1', 2, "Windows 7", "192.172.002.02", 1, "NXGQCAL004741692013501");
select * from Computador where fkEscola = 1;


create table Alerta (
	idAlerta int primary key auto_increment not null,
    tituloAlerta varchar(45) not null,
    tipoAlerta varchar(20) not null,
    descricaoAlerta varchar(45) not null,
    fkComputador int,
    foreign key (fkComputador) references Computador(idComputador)
);
create table Blacklist (
	idBlacklist int primary key auto_increment not null,
	nomeProcesso varchar(45) not null
	);
    
insert into Blacklist values 
	(null, 'Discord'),
    (null, 'Valorant'),
    (null, 'Minecraft'),
    (null, 'Counter Strike'),
    (null, 'Paladins'),
    (null, 'PUBG Lite');
    
	
create table Computador_has_Blacklist (
	idCompBlack int primary key auto_increment not null,
	fkComputador int not null,
    foreign key (idCompBlack) references Computador(idComputador),
	fkBlacklist int not null,
    foreign key (fkBlacklist) references Blacklist(idBlacklist)
);


create table Componente (
	idComponente int primary key auto_increment not null,
    nomeComponente varchar(65) not null,
    tipoComponente varchar(20) not null,
    fkComputador int not null,
    foreign key (fkComputador) references Computador(idComputador)
);




insert into Componente values 
	(null, "AMD Ryzen 9900K", "Processador", 1),
    (null, "Dell memória atualização - 4Go - 1Rx16 DDR4 SODIMM 2400MHz", "Memoria", 1),
    (null, "HD NAS Seagate IronWolf 16TB ST16000VN001", "Disco", 1),
    (null, "Intel Corr I5", "Processador", 2),
    (null, "SSD Kingston 500G", "Memoria", 2),
    (null, "SSD Kingston 500G", "Disco", 2);
    
  

select * from Componente;

create table UsoTotal (
	idUsoAtual int primary key auto_increment not null,
	usoComponente int not null,
	dataHora datetime not null,
	fkComponente int not null,
	foreign key (fkComponente) references Componente(idComponente)
);

select * from UsoTotal;


insert into UsoTotal values
    (null, 70, '2020-11-25 20:05:00', 4);
    
    insert into UsoTotal values
    (null, 30, '2020-11-25 20:08:00', 4);
    insert into UsoTotal values
    (null, 50, '2020-11-25 20:10:00', 4);
    
     insert into UsoTotal values
    (null, 35, '2020-11-25 20:12:00', 4);
     insert into UsoTotal values
    (null, 40, '2020-11-25 20:14:00', 4);
    
     insert into UsoTotal values
    (null, 56, '2020-11-25 20:16:00', 4);
     insert into UsoTotal values
    (null, 50, '2020-11-25 20:18:00', 4);
    
     insert into UsoTotal values
    (null, 53, '2020-11-25 20:20:00', 4);
     insert into UsoTotal values
    (null, 50, '2020-11-25 20:22:00', 4);
select * from UsoTotal;

create table Processo (
	idProcesso int primary key auto_increment not null,
	nomeProcesso varchar(20) not null,
	dataHora datetime not null,
	memoriaProcesso decimal(10,2) not null,
	fkComputador int not null,
	foreign key (fkComputador) references Computador(idComputador)
);

select * from UsoTotal where tipoComponente='Processador' order by idUsoAtual desc LIMIT 1;
select * from UsoTotal where tipoComponente='Processador' and fkComputador=29 order by idUsoAtual desc LIMIT 5;
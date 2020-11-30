create table Escola (
	idEscola INT PRIMARY KEY IDENTITY(1,1),
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
	( 'Barão de Ramalho', '1123456543', 'Vera','Antonio Carlos 546', 'Penha', 'SP', 'São Paulo','03612450'),
    ( 'Guilherme de Almeida', '1103849117', 'Arlene', 'Av Governador Carvalho Pinto', 'Penha', 'SP', 'São Paulo', '03612789');

create table Tecnico (
	idTecnico int primary key identity(1,1),
	nomeTecnico varchar(45) not null,
	telefoneTec char(11) not null,
	emailTec varchar(45) not null,
	senhaTec varchar(25) not null,
    disponibilidade bit not null,
    fkGestor int,
	fkEscola int not null,
	foreign key (fkEscola) references Escola(idEscola),
    foreign key (fkGestor) references Tecnico(idTecnico)
);


select * from Tecnico where emailTec='cesar.augustus@gmail.com' and senhaTec='qualquerSenha';


create table Computador (
	idComputador int identity(1,1) primary key not null,
	nomeComputador varchar(15) not null,
	fkEscola int not null,
    sistemaOperacional varchar(15) not null,
    ipv4 varchar(15) not null,
    disonibilidade bit not null,
    serialNum varchar(35) not null,
	foreign key (fkEscola) references Escola(idEscola)
);

select * from Computador;

insert into Computador values 
	('PC01SLA1', 1, 'Windows 10', '192.168.052.01', 1, 'NXGQCAL004741692029501'),
    ('PC02SLA1', 1, 'Windows 7', '192.168.053.02', 1, 'ZXGQCAL004743401029501'),
    ('PC03SLA1', 1, 'Windows 10', '192.168.062.08', 1, 'NXGQCAL004741692029501'),
    ('PC04SLA1', 1, 'Ubuntu Linux', '192.168.103.02', 1, 'NXGQCAL004741691029501'),
    ('PC05SLA1', 1, 'Windows 7', '192.168.040.02', 0, 'NXGQCAL004741692023501'),
    ('PC06SLA1', 1, 'Windows 10', '192.168.353.02', 1, 'NXGQCAL004741692459501'),
    ('PC07SLA1', 1, 'Windows 10', '192.168.222.02', 1, 'NXGQCAL004741692679501'),
    ('PC08SLA1', 1, 'Windows 7', '192.168.353.02', 1, 'NXGQCAL004741692089501'),
    ('PC09SLA1', 1, 'Ubuntu Linux', '192.168.325.02', 1, 'NXGQCAL004741609029501'),
    ('PC01SLA1', 2, 'Ubuntu Linux', '192.178.053.02', 1, 'NXGQCAL004741612029501'),
    ('PC02SLA1', 2, 'Ubuntu Linux', '192.179.053.02', 1, 'NXGQCAL004741645029501'),
    ('PC03SLA1', 2, 'Windows 10', '192.153.063.02', 0, 'NXGQCAL004741692259501'),
    ('PC04SLA1', 2, 'Ubuntu Linux', '192.175.080.02', 1, 'NXGQCAL004741636029501'),
    ('PC05SLA1', 2, 'Windows 7', '192.173.181.02', 0, 'NXGQCAL004741692034501'),
    ('PC06SLA1', 2, 'Windows 7', '192.172.053.02', 1, 'NXGQCAL004741692078501'),
    ('PC07SLA1', 2, 'Ubuntu Linux', '192.172.350.02', 1, 'NXGQCAL004741647029501'),
    ('PC08SLA1', 2, 'Windows 7', '192.172.001.02', 0, 'NXGQCAL004741692097501'),
    ('PC09SLA1', 2, 'Windows 7', '192.172.002.02', 1, 'NXGQCAL004741692013501');
    
   select * from Computador where fkEscola = 1;
   
  create table Alerta (
	idAlerta int primary key identity(1,1) not null,
    tituloAlerta varchar(45) not null,
    tipoAlerta varchar(20) not null,
    descricaoAlerta varchar(45) not null,
    fkComputador int,
    foreign key (fkComputador) references Computador(idComputador)
);

create table Blacklist (
	idBlacklist int primary key identity not null,
	nomeProcesso varchar(45) not null
	);
	
insert into Blacklist values 
	( 'Discord'),
    ( 'Valorant'),
    ( 'Minecraft'),
    ( 'Counter Strike'),
    ( 'Paladins'),
    ( 'PUBG Lite');
    
 create table Computador_has_Blacklist (
	idCompBlack int primary key identity(1,1) not null,
	fkComputador int not null,
    foreign key (idCompBlack) references Computador(idComputador),
	fkBlacklist int not null,
    foreign key (fkBlacklist) references Blacklist(idBlacklist)
);

create table Componente (
	idComponente int primary key identity(1,1) not null,
    nomeComponente varchar(65) not null,
    tipoComponente varchar(20) not null,
    fkComputador int not null,
    foreign key (fkComputador) references Computador(idComputador)
);

insert into Componente values 
	( 'AMD Ryzen 9900K', 'Processador', 1),
    ( 'Dell memória atualização - 4Go - 1Rx16 DDR4 SODIMM 2400MHz', 'Memoria', 1),
    ( 'HD NAS Seagate IronWolf 16TB ST16000VN001', 'Disco', 1),
    ( 'Intel Corr I5', 'Processador', 2),
    ( 'SSD Kingston 500G', 'Memoria', 2),
    ( 'SSD Kingston 500G', 'Disco', 2);
   
   select * from Componente;
  
  create table UsoTotal (
	idUsoAtual int primary key identity(1,1) not null,
	nomeComponente varchar(45) not null,
	usoComponente int not null,
	tipoComponente varchar(20) not null,
	dataHora datetime not null,
	fkComputador int not null,
	foreign key (fkComputador) references Computador(idComputador)
);

insert into UsoTotal values
    ( 'AMD Ryzen 9900K', 100, 'CPU', '2020-11-25 20:05:00', 1);
    
    insert into UsoTotal values
    (  'AMD Ryzen 9900K', 30, '2020-11-25 20:08:00', 4);
    insert into UsoTotal values
    ( 50, '2020-11-25 20:10:00', 4);
    
     insert into UsoTotal values
    ( 35, '2020-11-25 20:12:00', 4);
     insert into UsoTotal values
    ( 40, '2020-11-25 20:14:00', 4);
    
     insert into UsoTotal values
    ( 56, '2020-11-25 20:16:00', 4);
     insert into UsoTotal values
    ( 50, '2020-11-25 20:18:00', 4);
    
     insert into UsoTotal values
    ( 53, '2020-11-25 20:20:00', 4);
     insert into UsoTotal values
    ( 50, '2020-11-25 20:22:00', 4);
    
   select * from UsoTotal;
   
  create table Processo (
	idProcesso int primary key identity(1,1) not null,
	nomeProcesso varchar(20) not null,
	dataHora datetime not null,
	memoriaProcesso decimal(10,2) not null,
	fkComputador int not null,
	foreign key (fkComputador) references Computador(idComputador)
);

drop table Componente ;

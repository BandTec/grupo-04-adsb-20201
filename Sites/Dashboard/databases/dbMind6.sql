create database mind6;
use mind6;

create table tecnico (
	id int primary key auto_increment,
    nomeTec varchar(45),
    foneTec char(11),
    emailTec varchar(45),
    senhaTec varchar(45)
);

insert into tecnico values 
	(null, 'Cesar Augusto', '1126427301', 'cesar.guga2013@gmail.com', 'urubu100');
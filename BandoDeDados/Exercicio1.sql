/* criação do banco de dados*/
create database bd_rh;

/*Criando a tabela de funcioarios e determinando 5 atributos*/
use bd_rh;
create table tb_funcionaries(
id bigint (5) auto_increment,
nome varchar (20),
salario decimal (18,2),
ativo boolean,
genero char(1),
primary key (id)
);
/*Populando a tabela */
insert into tb_funcionaries (nome, salario, genero, ativo)
values
("Stefani", 5000, "F", true),
("Giovanni", 5000.50, "M", true),
("Mel", 1500, "F", false),
("João", 1000, "M", false),
("Maria", 2000, "F", true);

/*Faça um select que retorne os funcionaries com o salário maior do que 2000.*/
select * from tb_funcionaries where salario > 2000;

/*Faça um select que retorne os funcionaries com o salário menor do que 2000.*/
select * from tb_funcionaries where salario < 2000;

/*Ao término atualize um dado desta tabela através de uma query de atualização.*/
update tb_funcionaries set salario = 1800 where id=3;



















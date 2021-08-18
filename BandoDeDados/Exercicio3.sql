/*Craindo o banco de dados*/
create database bd_escola;

/*Criando a tabela estudantes e determinando 5 atributos*/
use bd_escola

create table tb_estudantes(
id bigint (5) auto_increment,
nomeAluno varchar (100) not null,
cpf varchar (30),
ativo boolean,
nota decimal (10,2),
primary key (id)
);



/* Popule esta tabela com até 8 dados*/
insert into tb_estudantes (nomeAluno, cpf, nota, ativo)
values
("Jurema", "111.111.111-1", 7.5, true),
("Jacira", "222.222.222-2", 8.6, true),
("Jupira", "333.333.333-3", 9.5, true),
("Mel", "444.444.444-4", 10, true),
("José", "555.555.555-5", 6, true),
("Maria", "666.666.666-6", 5, false),
("João", "777.777.777-7", 7, false),
("Ana", "888.888.888-8", 4, true);

/*Faça um select que retorne o/as estudantes  com a nota maior do que 7.*/
select * from tb_estudantes where nota > 7;

/*Faça um select que retorne o/as estudantes  com a nota menor do que 7.*/
select * from tb_estudantes where nota < 7;

/*Ao término atualize um dado desta tabela através de uma query de atualização.*/
update tb_estudantes set nota = 10 where id = 6;



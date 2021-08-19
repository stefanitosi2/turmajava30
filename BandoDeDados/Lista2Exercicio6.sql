create database db_cursoDaMinhaVida;
use db_cursoDaMinhaVida;

create table tb_categoria(
id_categoria int auto_increment,
nome_categoria varchar (50) not null,
primary key (id_categoria)
);

create table tb_curso(
id_curso int auto_increment,
nome_curso varchar (50) not null,
duracao_curso decimal (10,2),
horario_curso char,
id_categoria int,
primary key (id_curso),
foreign key (id_categoria) references tb_categoria (id_categoria)
);

insert into tb_categoria (nome_categoria)
values
("Matematica"),
("Portugues"),
("Ingles");

insert into tb_curso (nome_curso, duracao_curso, horario_curso, id_categoria)
values
("Matematica do zero", 12, "M", 1),
("Portugues iniciante", 15, "N", 2),
("Ingles iniciante", 36, "T", 3),
("Matematica Intermediario", 12, "N", 1),
("Matematica avançado", 15, "T", 1),
("Portugues intermediario", 18, "N", 2),
("Portugues avançado", 15, "N", 2),
("Ingles avançado", 60, "N", 3);

/*Faça um select que retorne os cursos com durançao maior que 15 meses.*/
select * from tb_curso where duracao_curso > 15;

/*Faça um select trazendo  os os curso da tarde e noite */
select * from tb_curso where horario_curso in("t" , "n");

/*Faça um select  utilizando LIKE buscando os Produtos com a letra B.*/
select * from tb_curso where nome_curso like "%j%";

/*Faça um um select com Inner join entre  tabela categoria e produto.*/
select *
from tb_categoria
inner join tb_curso on tb_curso.id_categoria = tb_categoria.id_categoria;

select *
from tb_curso
where id_categoria = 1;



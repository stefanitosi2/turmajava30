create database db_cidade_das_frutas;
use db_cidade_das_frutas;

create table tb_categoria(
id_categoria int auto_increment,
nome_categoria varchar (50) not null,
primary key (id_categoria)
);

create table tb_produto(
id_produto int auto_increment,
nome_produto varchar (50) not null,
valor_produto decimal (10,2),
peso_produto decimal (10,2),
id_categoria int,
primary key (id_produto),
foreign key (id_categoria) references tb_categoria (id_categoria)
);

insert into tb_categoria (nome_categoria)
values
("Fruta"),
("Legumes"),
("Verdura");

select * from tb_produto;

insert into tb_produto (nome_produto, valor_produto, peso_produto, id_categoria)
values
("Banana", 100, 10, 1),
("Mamão", 200, 20, 1),
("Batata", 200, 20, 2),
("Mandioca", 200, 15, 2),
("Alface", 25.99, 1.5, 3),
("Escarola", 35.99, 2.5, 3),
("maça", 300, 30, 1),
("Batata doce", 80, 3.5, 2);

/*Faça um select que retorne os Produtos com o valor maior do que 50 reais.*/
select * from tb_produto where valor_produto > 50;

/*Faça um select trazendo  os Produtos com valor entre 3 e 60 reais.*/
select * from tb_produto where valor_produto between 3 and 60;

/*Faça um select  utilizando LIKE buscando os Produtos com a letra c.*/
select * from tb_produto where nome_produto like "%c%";

/*Faça um um select com Inner join entre  tabela categoria e produto.*/
select *
from tb_categoria
inner join tb_produto on tb_produto.id_categoria = tb_categoria.id_categoria;

select *
from tb_produto
where id_categoria = 2;
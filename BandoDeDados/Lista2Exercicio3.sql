create database db_farmacia_do_bem;
use db_farmacia_do_bem;

create table tb_categoria(
id_categoria int auto_increment,
nome_categoria varchar (50) not null,
primary key (id_categoria)
);

create table tb_produto(
id_produto int auto_increment,
nome_produto varchar (50) not null,
valor_produto decimal (10,2),
remedio_controlado boolean,
ativo boolean,
id_categoria int,
primary key (id_produto),
foreign key (id_categoria) references tb_categoria (id_categoria)
);

insert into tb_categoria (nome_categoria)
values
("remedio"),
("Higiene pessoal"),
("cosmeticos");

insert into tb_produto (nome_produto, valor_produto, remedio_controlado, ativo)
values
("Dipirona", 25.99, 0, 1),
("Shampoo", 30.99, 0, 1),
("Anti alergico", 65.99, 0, 1),
("Tarja Preta", 200.99, 1, 1),
("Condicionador", 25.99, 0, 1),
("Semi Gripe", 35.99, 0, 0),
("Batom", 25.99, 0, 1),
("Xarope", 45.99, 0, 0);

/*Faça um select que retorne os Produtos com o valor maior do que 50 reais.*/
select * from tb_produto where valor_produto > 50;

/*Faça um select trazendo  os Produtos com valor entre 3 e 60 reais.*/
select * from tb_produto where valor_produto between 3 and 60;

/*Faça um select  utilizando LIKE buscando os Produtos com a letra B.*/
select * from tb_produto where nome_produto like "%b%";

/*Faça um um select com Inner join entre  tabela categoria e produto.*/
select *
from tb_categoria
inner join tb_produto on tb_produto.id_categoria = tb_categoria.id_categoria;

select *
from tb_produto
where id = 1;



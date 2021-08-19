create database db_construindo_a_nossa_vida;
use db_construindo_a_nossa_vida;

create table tb_categoria(
id_categoria int auto_increment,
nome_categoria varchar (50) not null,
primary key (id_categoria)
);

create table tb_produto(
id_produto int auto_increment,
nome_produto varchar (50) not null,
valor_produto decimal (10,2),
ativo boolean,
id_categoria int,
primary key (id_produto),
foreign key (id_categoria) references tb_categoria (id_categoria)
);

insert into tb_categoria (nome_categoria)
values
("Hidraulico"),
("Telhado"),
("Banheiro");

insert into tb_produto (nome_produto, valor_produto, ativo)
values
("Torneira", 50, 1),
("Telha Marrom", 350, 0),
("Chuveiro", 65.99, 1),
("Vaso", 200.99, 1),
("Pia banheiro", 600, 1),
("Assento vaso", 35.99, 0),
("Organizador", 25.99, 0),
("Tanque ", 380, 0);

/*Faça um select que retorne os Produtos com o valor maior do que 50 reais.*/
select * from tb_produto where valor_produto > 50;

/*Faça um select trazendo  os Produtos com valor entre 3 e 60 reais.*/
select * from tb_produto where valor_produto between 3 and 60;

/*Faça um select  utilizando LIKE buscando os Produtos com a letra B.*/
select * from tb_produto where nome_produto like "%c%";

/*Faça um um select com Inner join entre  tabela categoria e produto.*/
select *
from tb_categoria
inner join tb_produto on tb_produto.id_categoria = tb_categoria.id_categoria;

select *
from tb_produto
where id_categoria = 1;



create database db_pizzaria_legal;

use db_pizzaria_legal;

create table tb_categoria(
id_categoria int auto_increment,
nome_categoria varchar (30) not null,
primary key (id_categoria)
);

create table tb_pizza(
id_pizza 		int auto_increment,
nm_pizza		varchar(50),
tamanho			char(1),
valor			decimal(18,2),
ativa			boolean,
id_categoria	int,
primary key (id_pizza),
foreign key (id_categoria) references tb_categoria (id_categoria)
);

insert into tb_categoria (nome_categoria)
values
("Salgada"),
("Doce");


insert into tb_pizza (nm_pizza, tamanho, valor, ativa, id_categoria)
values
("Presunto", "M", 29.9,1, 1),
("Queijo", "M", 29.9, 1, 1),
("frango c/ catupiry", "M", 29.9, 1, 1),
("frango c/ catupiry", "G", 35.9, 1, 1),
("Baiana", "M", 29.9, 1, 1),
("Baiana", "G", 35.9, 1, 1),
("Romeu e Julieta", "M", 29.9, 1, 2),
("Romeu e Julieta", "G", 35.9, 1, 2),
("Paçoca", "M", 29.9, 1, 2),
("Paçoca", "G", 35.9, 1, 2);


/*Faça um select que retorne os Produtos com o valor maior do que 45 reais.*/
select * from tb_pizza where valor > 45;

/*Faça um select trazendo  os Produtos com valor entre 29 e 60 reais.*/
select * from tb_pizza where valor between 29 and 60;

/*Faça um select  utilizando LIKE buscando os Produtos com a letra C.*/
select * from tb_pizza where nm_pizza like "%c%";

/*Faça um um select com Inner join entre  tabela categoria e pizza.*/
select * 
from tb_categoria
inner join tb_pizza on tb_pizza.id_categoria = tb_categoria.id_categoria; 

/*Faça um select onde traga todos os Produtos de uma categoria específica (exemplo todos os produtos que são pizza doce).*/

select *
from tb_pizza
where id_categoria = 2;







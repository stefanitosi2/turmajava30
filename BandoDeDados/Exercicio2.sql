/*Craindo o banco de dados*/
create database bd_ecommerce;

/*Criando a tabela produtos e determinando 5 atributos*/
use bd_ecommerce

create table tb_produtos(
id bigint (5) auto_increment,
nomeProduto varchar (100) not null,
marca varchar (100) not null,
ativo boolean,
valor decimal (18,2),
primary key (id)
);

/* Popule esta tabela com até 8 dados*/
insert into tb_produtos (nomeProduto, marca, valor, ativo)
values
("Sandalia alta", "Vizzano", 300, true),
("Vestido longo", "LizaLiz", 150, true),
("Sapatilha", "Moleca", 100, false),
("Bolsa", "Jorge Bischoff", 600, true),
("Calça jeans", "Hering", 300, true),
("Vestido curto", "Zara", 700, false),
("Bermuda masculina", "Hering", 90, false),
("Blusa ragata", "Acostamento", 150, true);

/*Faça um select que retorne os produtos com o valor maior do que 500.*/
select * from tb_produtos where valor > 500;

/*Faça um select que retorne os produtos com o valor menor do que 500.*/
select * from tb_produtos where valor < 500;

/*atualize um dado desta tabela através de uma query de atualização.*/
update tb_produtos set valor = 50 where id = 3;






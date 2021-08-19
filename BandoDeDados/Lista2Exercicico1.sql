/*criando o banco de dados*/
create database db_generation_game_online;

use db_generation_game_online;

/* criando a tabela classe*/
create table tb_classe (
id_classe int auto_increment,
nome_classe varchar (30) not null,
tipo_classe varchar (30) not null,
primary key (id_classe)
);

/* criando  tabela personagem*/
create table tb_personagem(
id_personagem int auto_increment,
nome_personagem varchar (30) not null,
forca int,
velocidade int,
defesa int,
id_classe int,
primary key (id_personagem),
foreign key (id_classe) references tb_classe (id_classe)
);
/*Populando a tabela classe com ate 5 dados*/
insert into tb_classe (nome_classe, tipo_classe)
values
("Professor", "Organização"),
("Diretor", "Organização"),
("Aluno", "Terceiro"),
("Inspetor", "Organização"),
("Secretaria", "organização");

select * from tb_classe;

/*Popular a tabela de personagem com oito dados*/
insert into tb_personagem (nome_personagem, forca, velocidade, defesa, id_classe)
values 
("Jacira", 1000, 2000, 3000, 1),
("Jurema", 1000, 2000, 3000, 2),
("Jupira", 1000, 2000, 3000, 3),
("Mel", 1000, 2000, 3000, 4),
("João", 800, 1000, 600, 5),
("Maria", 900, 800, 1000, 3),
("Jorge", 1000, 3000, 300, 4),
("José", 900, 700, 1000, 5);

/*Faça um select que retorne os personagens com o poder de ataque maior do que 2000.*/
select * from tb_personagem where forca > 2000;

/*Faça um select trazendo  os personagens com poder de defesa entre 1000 e 2000.*/
select * from tb_personagem where defesa = 1000 and 2000;

/*Faça um select  utilizando LIKE buscando os personagens com a letra C.*/
select * from tb_personagem where nome_personagem like "%C%";

/*Errei e dei o comando duas vezes entao cancelei o comando errado*/
delete tb_personagem
from tb_personagem 
where id_personagem <10;

/*Faça um um select com Inner join entre  tabela classe e personagem.*/
select * 
from tb_classe
inner join tb_personagem on tb_personagem.id_classe = tb_classe.id_classe;

/*Faça um select onde traga todos os personagem de uma classe específica (exemplo todos os personagens que são professores).*/

select *
from tb_personagem
where id_classe = 1;
















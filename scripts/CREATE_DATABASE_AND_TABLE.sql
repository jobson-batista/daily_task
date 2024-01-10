create database if not exists prova_remsoft;

use prova_remsoft;

create table tarefa (
    id int(11) auto_increment primary key,
    descricao varchar(255) not null,
    finalizado tinyint(1) default 0,
    dt_finalizado datetime,
    dt_criacao datetime default current_timestamp(),
    dt_ult_alt datetime default current_timestamp(),
    excluido tinyint(1) default 0
);
commit;

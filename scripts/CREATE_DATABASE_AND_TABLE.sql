CREATE DATABASE IF NOT EXISTS prova_remsoft;

USE prova_remsoft;

CREATE TABLE tarefa (
	id int(11) auto_increment primary key,
    descricao varchar(255) not null,
    finalizado tinyint(1) not null,
    dt_finalizado datetime,
    dt_criacao datetime not null,
    dt_ult_alt datetime,
    excluido tinyint(1) not null
);
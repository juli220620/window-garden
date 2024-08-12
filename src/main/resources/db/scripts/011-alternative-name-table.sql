--liquibase formatted sql
--changeset Julia:alternative-name-table failOnError:true

use flowers;

create table alternative_name (
    id               bigint       not null primary key auto_increment,
    flower_id        varchar(256) not null,
    alternative_name varchar(256) not null,
    foreign key (flower_id) references flower_dict (id)
);
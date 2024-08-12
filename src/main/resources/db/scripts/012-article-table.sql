--liquibase formatted sql
--changeset Julia:article-table failOnError:true

use flowers;

create table article (
    id                bigint       not null primary key auto_increment,
    short_description varchar(256) not null,
    text              text         not null
);
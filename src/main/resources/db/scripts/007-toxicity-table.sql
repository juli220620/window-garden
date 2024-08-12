--liquibase formatted sql
--changeset Julia:toxicity-table failOnError:true

use flowers;

create table toxicity_dict (
    id varchar(256) not null primary key
);

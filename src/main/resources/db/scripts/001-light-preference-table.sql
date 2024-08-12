--liquibase formatted sql
--changeset Julia:light-preference-table failOnError:true

use flowers;

create table light_preference_dict (
    id varchar(256) not null primary key
);
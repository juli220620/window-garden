--liquibase formatted sql
--changeset Julia:humidity-preference-table failOnError:true

use flowers;

create table humidity_preference_dict (
    id varchar(256) not null primary key
);

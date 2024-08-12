--liquibase formatted sql
--changeset Julia:temperature-preference-table failOnError:true

use flowers;

create table temperature_preference_dict (
    id varchar(256) not null primary key
);
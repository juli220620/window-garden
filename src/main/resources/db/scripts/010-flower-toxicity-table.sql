--liquibase formatted sql
--changeset Julia:flower-toxicity-table failOnError:true

use flowers;

create table flower_toxicity (
    flower_id       varchar(256) not null primary key,
    toxicity_status varchar(256) not null,
    explanation     varchar(256),
    foreign key (flower_id) references flower_dict (id),
    foreign key (toxicity_status) references toxicity_dict (id)
);
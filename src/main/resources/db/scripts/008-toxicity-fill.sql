--liquibase formatted sql
--changeset Julia:toxicity-fill failOnError:true

use flowers;

insert into toxicity_dict
values ('DOGS'),
       ('CATS'),
       ('PETS'),
       ('CHILDREN'),
       ('PEOPLE'),
       ('NOT_POISONOUS');
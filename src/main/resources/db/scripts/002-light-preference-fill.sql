--liquibase formatted sql
--changeset Julia:light-preference-fill failOnError:true

use flowers;

insert into light_preference_dict
values ('BRIGHT'),
       ('DIFFUSED'),
       ('MEDIUM'),
       ('SHADOW');
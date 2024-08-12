--liquibase formatted sql
--changeset Julia:temperature-preference-fill failOnError:true

use flowers;

insert into temperature_preference_dict
values ('HIGH_PREFERABLE'),
       ('HIGH_ACCEPTABLE'),
       ('MEDIUM'),
       ('LOW_ACCEPTABLE'),
       ('LOW_PREFERABLE');
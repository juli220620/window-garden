--liquibase formatted sql
--changeset Julia:humidity-preference-fill failOnError:true

use flowers;

insert into humidity_preference_dict
values ('HIGH_PREFERABLE'),
       ('HIGH_ACCEPTABLE'),
       ('MEDIUM'),
       ('LOW_ACCEPTABLE'),
       ('LOW_PREFERABLE');
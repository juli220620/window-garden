--liquibase formatted sql
--changeset Julia:flower-dict-table failOnError:true

use flowers;

create table flower_dict (
    id          varchar(256) not null primary key,
    name        varchar(256) not null,
    can_bloom   tinyint,
    light       varchar(256),
    humidity    varchar(256),
    temperature varchar(256),
    main_photo  blob,
    foreign key (light) references light_preference_dict (id),
    foreign key (humidity) references humidity_preference_dict (id),
    foreign key (temperature) references temperature_preference_dict (id)
);
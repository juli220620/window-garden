--liquibase formatted sql
--changeset Julia:flower-article-table failOnError:true

use flowers;

create table flower_article (
    flower_id  varchar(256) not null,
    article_id bigint       not null,
    primary key (flower_id, article_id),
    foreign key (flower_id) references flower_dict (id),
    foreign key (article_id) references article (id)
);
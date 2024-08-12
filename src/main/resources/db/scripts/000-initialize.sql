--liquibase formatted sql
--changeset Julia:initialize failOnError:true

CREATE DATABASE IF NOT EXISTS flowers CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
create user if not exists 'app'@'%' identified by '123456';
grant all on flowers.* to 'app'@'%';
flush privileges;
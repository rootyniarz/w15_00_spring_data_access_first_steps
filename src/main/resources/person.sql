drop table if exists person cascade;

create table person
(
id SERIAL not null,
age int,
name varchar(255),
primary key(id),
unique (name)
);
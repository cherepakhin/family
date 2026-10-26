CREATE TABLE person
(
    n     serial  NOT NULL UNIQUE,
    "name" varchar NOT NULL default ''
);

insert into person(n, "name")
values (0, '-');

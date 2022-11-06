CREATE TABLE person
(
    id     serial  NOT NULL UNIQUE,
    "name" varchar NOT NULL default ''
);

insert into person(id, "name") values (0, '-');

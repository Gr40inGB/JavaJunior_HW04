create table if not exists courses
(
    id       SERIAL primary key,
    title    varchar(100),
    duration integer
);

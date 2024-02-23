create table if not exists courses
(
    id    integer primary key not null,
    title varchar(100),
    duration integer
);

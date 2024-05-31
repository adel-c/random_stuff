create table if not exists USERS
(
    id       serial primary key ,
    name     varchar,
    salt varchar,
    password varchar,
    role     varchar,
    email    varchar
);

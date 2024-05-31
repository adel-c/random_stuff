create table if not exists USERS
(
    id       numeric primary key,
    name     varchar,
    password varchar,
    role     varchar,
    email    varchar
)

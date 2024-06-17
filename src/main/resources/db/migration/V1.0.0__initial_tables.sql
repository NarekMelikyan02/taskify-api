create table if not exists users
(
    id         uuid unique              not null
        constraint pk_users primary key,
    created    timestamp with time zone not null default current_timestamp,
    updated    timestamp with time zone          default current_timestamp,
    deleted    timestamp with time zone          default current_timestamp,
    first_name varchar(50),
    last_name  varchar(50),
    gender     varchar(10)             not null,
    email      varchar(100)             not null,
    password   varchar(100)             not null,
    user_role  varchar(10)             not null
);

create table if not exists tasks
(
    id            uuid unique              not null
        constraint pk_tasks primary key,
    created       timestamp with time zone not null default current_timestamp,
    updated       timestamp with time zone          default current_timestamp,
    deleted       timestamp with time zone          default current_timestamp,
    title         varchar(50)             not null,
    content       varchar(255)             not null,
    task_priority smallint             not null,
    status        varchar(10)        not null,
    user_id       uuid,
    constraint fk_users foreign key (user_id) references users (id),
    constraint uq_constraint unique(title,content,deleted)
);
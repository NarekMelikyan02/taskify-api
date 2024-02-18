create table if not exists users
(
    id         uuid                     not null unique
        constraint pk_users primary key,
    created   timestamp with time zone not null default current_timestamp,
    first_name varchar(255),
    last_name  varchar(255),
    gender     varchar(255) not null check (gender in('MALE','FEMALE')),
    email      varchar(255)              not null unique,
    password   varchar(255)              not null,
    user_role varchar(255) not null check (user_role in ('TEACHER','STUDENT','ADMIN'))
);

create table if not exists tasks
(
    id       uuid                     not null unique
        constraint pk_tasks primary key,
    created timestamp with time zone not null default current_timestamp,
    title varchar(255) not null,
    content varchar(255) not null ,
    task_priority varchar(255) not null  check (task_priority in ('HIGH','MEDIUM','LOW')),
    user_id uuid,
    constraint fk_users foreign key(user_id) references users(id)
);
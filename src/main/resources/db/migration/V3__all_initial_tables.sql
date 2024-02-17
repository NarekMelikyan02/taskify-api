create table if not exists tasks(
    id uuid not null primary key ,
    title varchar(50),
    content varchar(150),
    user_id uuid,
    foreign key(user_id) references users(id)
)
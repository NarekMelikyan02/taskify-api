create table if not exists answers
(
    id uuid unique not null
        constraint pk_answers primary key,
    created       timestamp with time zone not null default current_timestamp,
    updated       timestamp with time zone          default current_timestamp,
    deleted       timestamp with time zone          default current_timestamp,
    answer varchar (50) not null
);
alter table if exists tasks add column answer_id uuid,
    add constraint fk_answer foreign key(answer_id) references answers(id) ;
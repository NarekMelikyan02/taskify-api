create type u_role as ENUM ('TEACHER', 'STUDENT', 'ADMIN');
create type u_gender as ENUM ('MALE', 'FEMALE');
alter table if exists users
add user_role u_role,
add gender u_gender;
create type t_priority as ENUM ('HIGH', 'MEDIUM', 'LOW');
alter table if exists tasks
add task_priority t_priority;

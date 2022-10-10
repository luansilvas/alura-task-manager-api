create table subtask(
    id bigint not null auto_increment,
    title varchar(70) not null,
    task_id bigint not null,
    status varchar(50) not null,
    primary key(id),
    foreign key(task_id) references task(id)
);
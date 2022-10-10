create table user(
    id bigint not null auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into user values(1, 'Luan', 'luanssantos12@gmail.com');
insert into user values(2, 'Savio', 'savioRibeiroGuimaraes@gmail.com');
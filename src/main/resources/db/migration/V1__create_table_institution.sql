create table institution(
    id bigint not null auto_increment,
    name varchar(50) not null,
    type varchar(50) not null,
    primary key(id)
);

insert into institution values (1,'CENTRO UNIVERSITÁRIO SENAC','EDUCATIONAL')
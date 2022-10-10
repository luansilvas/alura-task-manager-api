create table task(
    id bigint not null auto_increment,
    title varchar(70) not null,
    description varchar(300) not null,
    creation_date datetime not null,
    institution_id bigint not null,
    type varchar(70) not null,
    author_id bigint not null,
    status varchar(50) not null,
    is_visible boolean not null,
    primary key(id),
    foreign key(institution_id) references institution(id),
    foreign key(author_id) references user(id)
);
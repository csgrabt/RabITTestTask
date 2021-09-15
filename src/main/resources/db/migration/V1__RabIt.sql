create table advertisements
(
    id      bigint not null auto_increment,
    title   varchar(255),
    user_id bigint,
    primary key (id)
) engine = InnoDB;
create table users
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine = InnoDB;
alter table advertisements
    add constraint foreign key (user_id) references users (id);
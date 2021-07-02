create table tag (
    id double NOT NULL AUTO_INCREMENT,
    description varchar(255),
    icon varchar(255),
    primary key (id)
);
insert into tag(id, description, icon) values (1, 'Tag1 teste', 'check-circle');
insert into tag(id, description, icon) values (2, 'Tag2 teste', 'beer');
insert into tag(id, description, icon) values (3, 'Tag3 teste', 'bicycle');
insert into tag(id, description, icon) values (4, 'Tag4 teste', 'bitcoin');
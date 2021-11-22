
create table tag (
    tag_id int(10) not null auto_increment,
    description varchar(255),
    icon varchar(255),
    primary key (tag_id)
);
insert into tag(tag_id, description, icon) values (1, 'Farmacia', 'icon1');
insert into tag(tag_id, description, icon) values (2, 'Gastos não previstos', 'icon2');
insert into tag(tag_id, description, icon) values (3, 'Comida', 'icon3');
insert into tag(tag_id, description, icon) values (4, 'Lazer', 'icon4');

create table settlement (
  settlement_id int(10) not null auto_increment,
  date_time datetime(6) default null,
  description varchar(255) default null,
  value double default null,
  primary key (settlement_id)
);
insert into settlement (settlement_id, date_time, description, value) values (1, '2021-07-18', 'Rede Drogao Popular Co', 10.13);
insert into settlement (settlement_id, date_time, description, value) values (2, '2021-07-18', 'Drogasil', 142.99);
insert into settlement (settlement_id, date_time, description, value) values (3, '2021-07-18', 'Giovani Di Piettro', 242.60);
insert into settlement (settlement_id, date_time, description, value) values (4, '2021-07-18', 'Diego Nery', 40.00);
insert into settlement (settlement_id, date_time, description, value) values (5, '2021-07-18', 'LOJAS RENNER SA', 99.90);

create table settlement_tag (
  settlement_id int(10) not null,
  tag_id int(10) not null,
  primary key PK_settlement_tag_id(settlement_id, tag_id),
  constraint FK_TAG_ID foreign key (tag_id) references tag (tag_id),
  constraint FK_SETTLEMENT_ID foreign key (settlement_id) references settlement (settlement_id)
);
insert into settlement_tag (settlement_id, tag_id) values (1, 1);
insert into settlement_tag (settlement_id, tag_id) values (1, 2);
insert into settlement_tag (settlement_id, tag_id) values (2, 1);
insert into settlement_tag (settlement_id, tag_id) values (2, 2);
insert into settlement_tag (settlement_id, tag_id) values (3, 2);
insert into settlement_tag (settlement_id, tag_id) values (3, 3);
insert into settlement_tag (settlement_id, tag_id) values (3, 4);
insert into settlement_tag (settlement_id, tag_id) values (4, 4);

create table filter (
 filter_id integer not null auto_increment,
 type varchar(50),
 value varchar(255),
 primary key (filter_id),
 constraint uc_filter UNIQUE (type, value)
);

insert into filter(filter_id, type, value) values (1, 'CONTAINS', 'Drog');
insert into filter(filter_id, type, value) values (2, 'CONTAINS', 'RENNER');

create table rule (
 rule_id integer not null auto_increment,
 primary key PK_rule (rule_id)
);

insert into rule(rule_id) values (1);
insert into rule(rule_id) values (2);

create table rule_filter (
rule_id int(10) not null,
filter_id int(10) not null,
primary key PK_rule_filter (rule_id, filter_id),
constraint foreign key (rule_id) references rule (rule_id),
constraint foreign key (filter_id) references filter (filter_id)
);

insert into rule_filter(rule_id, filter_id) values (1, 1);
insert into rule_filter(rule_id, filter_id) values (2, 2);

create table rule_tag (
rule_id int(10) not null,
tag_id int(10) not null,
primary key (rule_id, tag_id),
constraint foreign key (rule_id) references rule (rule_id),
constraint foreign key (tag_id) references tag (tag_id)
);

insert into rule_tag(rule_id, tag_id) values (1, 1);
insert into rule_tag(rule_id, tag_id) values (1, 2);
insert into rule_tag(rule_id, tag_id) values (2, 3);
insert into rule_tag(rule_id, tag_id) values (2, 4);

create table user (
id bigint not null auto_increment,
name varchar(255),
primary key (id)
);

insert into user(id, name) values (1,  "Raphinha");
insert into user(id, name) values (2,  "Romário");
create table tag (
    tag_id int(10) not null auto_increment,
    description varchar(255),
    icon varchar(255),
    primary key (tag_id)
);
insert into tag(tag_id, description, icon) values (1, 'Tag1 teste', 'check-circle');
insert into tag(tag_id, description, icon) values (2, 'Tag2 teste', 'beer');
insert into tag(tag_id, description, icon) values (3, 'Tag3 teste', 'bicycle');
insert into tag(tag_id, description, icon) values (4, 'Tag4 teste', 'bitcoin');

create table settlement (
  settlement_id int(11) not null auto_increment,
  date_time datetime(6) default null,
  description varchar(255) default null,
  value double default null,
  primary key (settlement_id)
);

create table settlement_tag (
  settlement_id int(11) not null,
  tag_id int(11) not null,
  primary key PK_settlement_tag_id(settlement_id, tag_id),
  constraint FK_TAG_ID foreign key (tag_id) references tag (tag_id),
  constraint FK_SETTLEMENT_ID foreign key (settlement_id) references settlement (settlement_id)
);

create table filter (
 filter_id integer not null auto_increment,
 type integer,
 value varchar(255),
 primary key (filter_id),
 constraint uc_filter UNIQUE (type, value)
);

create table rule (
 rule_id integer not null auto_increment,
 filter_id integer,
 tag_id integer,
 primary key (rule_id)
);
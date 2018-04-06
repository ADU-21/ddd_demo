create table user
(
  uuid varchar(255) not null,
  email varchar(255) not null,
  pass_word varchar(255),
  primary key(uuid)
);

create table policy
(
  uuid varchar(255) not null,
  policy_number varchar(255) not null,
  email varchar(255) not null,
  primary key(policy_number)
);
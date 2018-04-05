create table user
(
   id integer not null,
   email varchar(255) not null,
   user_name varchar(255) not null,
   pass_word varchar(255),
   token varchar(255) not null,
   primary key(id)
);
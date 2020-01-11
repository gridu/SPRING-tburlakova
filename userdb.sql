create schema if not exists test collate utf8mb4_general_ci;

create table if not exists phoneBook.USERS

(
  id int auto_increment
    primary key,
  name varchar(32) not null
);

create table if not exists phoneBook.PHONES

(
  phone_id int auto_increment
    primary key,
  phone varchar(32) not null,
  constraint
    unique (phone),
  id int,
  foreign key(id) REFERENCES phoneBook.USERS (id)
);

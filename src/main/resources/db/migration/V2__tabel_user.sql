create table user (
                      userId int unsigned auto_increment
                          primary key,
                      name varchar(150)  not null,
                      email varchar(150)  not null,
                      password varchar(150)  not null
);
create table teachers (
    id int primary key auto_increment,
    name varchar(20) not null,
    surname varchar(50) not null,
    degree varchar(50) not null,
    email varchar(50) not null
);
ALTER TABLE teachers CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE teachers DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci



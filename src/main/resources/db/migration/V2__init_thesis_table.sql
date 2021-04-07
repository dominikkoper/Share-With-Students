create table thesis(
    id int primary key auto_increment,
    type varchar(20),
    topic varchar(200),
    description varchar (500),
    reserved bit,
    teacher_id int,
    FOREIGN KEY (teacher_id) references teachers(id)

);
ALTER TABLE thesis CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE thesis DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

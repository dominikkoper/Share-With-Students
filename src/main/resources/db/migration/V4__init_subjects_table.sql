create table subjects
(
    id          int primary key auto_increment,
    lesson varchar(70),
    teacher_id  int,
    FOREIGN KEY (teacher_id) references teachers (id)
);
ALTER TABLE subjects CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE subjects DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
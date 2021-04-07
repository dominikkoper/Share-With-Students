create table consultations
(
    id          int primary key auto_increment,
    time varchar(20),
    teacher_id  int,
    FOREIGN KEY (teacher_id) references teachers (id)

);

ALTER TABLE consultations CONVERT TO CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE consultations DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
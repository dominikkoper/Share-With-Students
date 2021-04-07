create table Groupe
(
    id          int primary key auto_increment,
    name varchar(250)

);

create table Lessons
(
    id          int primary key auto_increment,
    name varchar(250),
    groupe_id int,
    FOREIGN KEY (groupe_id) references Groupe(id)

);

create table Files
(
    id          int primary key auto_increment,
    name varchar(250),
    path varchar(250),
    groupname varchar(250),
    lessonname varchar (250),
    groupe_id int,
    lesson_id int,
    FOREIGN KEY (groupe_id) references Groupe(id),
    FOREIGN KEY (lesson_id) references Lessons(id)

);
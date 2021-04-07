package pl.koper.swsapp.model;

import javax.persistence.*;

@Entity
@Table( name = "Files")
public class FileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String path;
    private String groupname;
    private String lessonname;
    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Group groupe;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getLessonname() {
        return lessonname;
    }

    public void setLessonname(String lessonname) {
        this.lessonname = lessonname;
    }

    public Group getGroupe() {
        return groupe;
    }

    public void setGroupe(Group groupe) {
        this.groupe = groupe;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
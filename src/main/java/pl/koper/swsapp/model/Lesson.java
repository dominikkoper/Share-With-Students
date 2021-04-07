package pl.koper.swsapp.model;

import javax.persistence.*;

@Entity
@Table( name = "Lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Group groupe;

    public Lesson(String name) {
        this.name = name;
    }

    public Lesson() {

    }

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

    public Group getGroupe() {
        return groupe;
    }

    public void setGroupe(Group groupe) {
        this.groupe = groupe;
    }
}
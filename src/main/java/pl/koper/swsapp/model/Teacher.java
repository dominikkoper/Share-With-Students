package pl.koper.swsapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table( name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name must be not empty")
    private String name;
    @NotBlank(message = "Surname must be not empty")
    private String surname;
    @NotBlank(message = "Academic title must be not empty")
    private String degree;
    @NotBlank(message = "Name of subject must be not empty")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Thesis> thesis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Consultation> consultations;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Subject> subjects;

    public Teacher(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }


    public Set<Thesis> getThesis() {
        return thesis;
    }

    public void setThesis(final Set<Thesis> thesis) {
        this.thesis = thesis;
    }

    public Set<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(Set<Consultation> consultations) {
        this.consultations = consultations;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}

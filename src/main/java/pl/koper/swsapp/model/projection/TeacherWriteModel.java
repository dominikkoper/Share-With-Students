package pl.koper.swsapp.model.projection;

import pl.koper.swsapp.model.Consultation;
import pl.koper.swsapp.model.Thesis;
import pl.koper.swsapp.model.Subject;
import pl.koper.swsapp.model.Teacher;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TeacherWriteModel {
    @NotBlank(message = "Name must be not empty")
    private String name;
    @NotBlank(message = "Surname must be not empty")
    private String surname;
    @NotBlank(message = "Academic title must be not empty")
    private String degree;
    @NotBlank(message = "Name of subject must be not empty")
    private String emails;
    @Valid
    private List<Thesis> thesis = new ArrayList<>();
    @Valid
    private List<Consultation> consultations = new ArrayList<>();
    @Valid
    private List<Subject> subjects = new ArrayList<>();

    public TeacherWriteModel(){

        subjects.add(new Subject());
        consultations.add(new Consultation());
        thesis.add(new Thesis());
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

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public List<Thesis> getThesis() {
        return thesis;
    }

    public void setThesis(final List<Thesis> thesis) {
        this.thesis = thesis;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Teacher toTeacher() {
        var result = new Teacher();
        result.setName(name);
        result.setSurname(surname);
        result.setDegree(degree);
        result.setEmail(emails);
        thesis.forEach(thesis -> thesis.setTeacher(result));
        result.setThesis((new HashSet<>(thesis)));
        consultations.forEach(consultation -> consultation.setTeacher(result));
        result.setConsultations((new HashSet<>(consultations)));
        subjects.forEach(subject -> subject.setTeacher(result));
        result.setSubjects((new HashSet<>(subjects)));
        return result;
    }
}


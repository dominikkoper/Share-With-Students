package pl.koper.swsapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.koper.swsapp.model.Consultation;
import pl.koper.swsapp.model.Thesis;
import pl.koper.swsapp.model.Subject;
import pl.koper.swsapp.model.Teacher;
import pl.koper.swsapp.model.projection.TeacherWriteModel;
import pl.koper.swsapp.repository.TeacherRepository;
import pl.koper.swsapp.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/teachers")
class TeacherController {

    @Autowired
    private final TeacherService service;

    @Autowired
    private final TeacherRepository repository;


    TeacherController(TeacherService service, TeacherRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    String showProfiles(Model model) {
        model.addAttribute("listTeachers", service.getAllTeachers());
        return "teachers";
    }

    @GetMapping("/add_teacher")
    String showTeachers(Model model) {
        model.addAttribute("teacher", new TeacherWriteModel());
        return "addteacher";
    }

    @GetMapping("/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable(value = "id") Integer id, RedirectAttributes model) {
        Teacher teacher = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id:" + id));
        repository.delete(teacher);
        model.addFlashAttribute("message", "Teacher deleted!");
        return "redirect:/";
    }

    @PostMapping(value = "/add_teacher", params = "addNext2")
    String addNextConsultation(@ModelAttribute("teacher") TeacherWriteModel current) {
        current.getConsultations().add(new Consultation());
        return "addteacher";
    }

    @PostMapping(value = "/add_teacher", params = "addNext")
    String addNextThesis(@ModelAttribute("teacher") TeacherWriteModel current) {
        current.getThesis().add(new Thesis());
        return "addteacher";
    }

    @PostMapping(value = "/add_teacher", params = "addNext3")
    String addNextSubject(@ModelAttribute("teacher") TeacherWriteModel current) {
        current.getSubjects().add(new Subject());
        return "addteacher";
    }

    @GetMapping("/{id}")
    public String viewProfile(@PathVariable(value = "id") Integer id, Model model) {
        Teacher teacher = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id:" + id));
        List<Thesis> listTheses = service.getThesisByTeacherId(id);
        model.addAttribute("listTheses", listTheses);
        List<Subject> listSubjects = service.getSubjectById(id);
        model.addAttribute("listSubjects", listSubjects);
        List<Consultation> listConsultations = service.getConsultationById(id);
        model.addAttribute("listConsultations", listConsultations);
        model.addAttribute("singleTeacher", teacher);
        return "profile";
    }

    @PostMapping("/add_teacher")
    String addTeacher(@ModelAttribute("teacher") TeacherWriteModel current, RedirectAttributes model) {
        service.save(current);
        model.addFlashAttribute("teacher", new TeacherWriteModel());
        model.addFlashAttribute("message", "Added successfully!");
        return "redirect:/teachers";
    }



}
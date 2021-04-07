package pl.koper.swsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.koper.swsapp.repository.ThesisRepository;
import pl.koper.swsapp.service.ThesisService;



@Controller
@RequestMapping("/thesis")
class ThesisController {

    @Autowired
    private final ThesisService service;

    @Autowired
    private final ThesisRepository repository;

    ThesisController(ThesisService service, ThesisRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    String showThesis(Model model) {
        model.addAttribute("listThesis", service.getAllThesis());
        return "thesis";
    }
    @GetMapping("/reserve/{id}")
    String reserveThesis(@PathVariable(value = "id") Integer id, RedirectAttributes model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String user = authentication.getName();
        service.statusUpdate(user);
        service.addThesisId(id, user);
        service.changeStatus(id);
        model.addFlashAttribute("message", "Thesis reserved! Please contact with teacher to agree on details");
        return "redirect:/";
    }




}
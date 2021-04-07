package pl.koper.swsapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class indexController {
    @GetMapping
    String showIndex(){
        return "index";
    }
}

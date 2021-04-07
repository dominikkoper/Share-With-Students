package pl.koper.swsapp.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class SsoController {

    @GetMapping("/logout")
    String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/";
    }

    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN", "ROLE_TEACHER"})
    @GetMapping("/login")
    String login() {
        return "redirect:/";
    }
}

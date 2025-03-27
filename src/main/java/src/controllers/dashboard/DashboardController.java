package src.controllers.dashboard;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import src.services.user.UserService;

import java.security.Principal;

@Controller
public class DashboardController {

    private final UserService userService;

    public DashboardController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String showHome(Model model, HttpSession session) {
        var user = session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        model.addAttribute("page", "dashboard");
        return "home";
    }
}

package src.controllers.user;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import src.dto.user.UserDto;
import src.services.user.UserService;
import org.springframework.ui.Model;


import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDto());
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("user", new UserDto());
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginPost(@Valid @ModelAttribute("user") UserDto user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("loginError", true);
            return "login";
        }
        var validUser = this.userService.authenticate(user.getUName(), user.getUPassword());
        if (!validUser) {
            model.addAttribute("BadCredentials", true);
            return "login";
        }
        var foundUser = this.userService.getUserByUName(user.getUName());
        model.addAttribute("user", foundUser);
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        var user = userService.getUserByUName(principal.getName());
        model.addAttribute("user", user);
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute UserDto userDto, Model model, BindingResult bindingResult) {
        var user = this.userService.getUserByUName(userDto.getUName());
        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (user != null) {
            model.addAttribute("UserExist", user);
            return "register";
        } else {
            this.userService.saveUser(userDto);
            return "redirect:/register?success";
        }
    }


}

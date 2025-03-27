package src.controllers.transaction;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class TransactionController {

    public TransactionController() {}

    @GetMapping("/transactions")
    public String showTransactions(Model model, HttpSession session) {
        var user = session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", user);
        model.addAttribute("page", "transactions");
        return "transaction";
    }
}

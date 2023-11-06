package pl.papug.papug.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/my-account")
    public String myAccount(Model model, HttpServletRequest request) {
        model.addAttribute("user", request.getUserPrincipal());
        model.addAttribute("currentPage", "myAccount");;
        return "account/details";
    }
}

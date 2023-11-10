package pl.papug.papug.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.papug.papug.model.UserAccount;
import pl.papug.papug.service.AuthService;

@Controller
public class RegisterController {
    @Autowired
    AuthService authService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        String currentPage = "register";
        model.addAttribute("currentPage", currentPage);

        return "account/registerForm";
    }

    @PostMapping("/register")
    public String registerHandler(Model model,
                                  @RequestParam("username") String username,
                                  @RequestParam("password1") String password1,
                                  @RequestParam("password2") String password2) {
        String currentPage = "register";
        model.addAttribute("currentPage", currentPage);

        if (!this.authService.isLogged()) {
            if (password1.equals(password2)) {
                if (!this.authService.userExists(username)) {
                    this.authService.register(username, password1);
                    model.addAttribute("msg", "Success!");
                    return "account/registerForm";
                } else {
                    model.addAttribute("error", "User with that username already exists");
                    return "account/registerForm";
                }
            } else {
              model.addAttribute("error", "Passwords do not match");
                return "account/registerForm";
            }
        } else {
            model.addAttribute("error", "You cannot register as long as you're logged in");
            return "account/registerForm";
        }


//        return "account/registerForm";
    }
}

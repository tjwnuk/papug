package pl.papug.papug.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import pl.papug.papug.model.UserAccount;
import pl.papug.papug.service.AuthService;

import java.util.Collection;
import java.util.List;

@Controller
//@RequestMapping("/about")
public class AboutController {


    UserDetailsService userDetailsService;

    @Autowired
    AuthService authService;

    public AboutController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/about")
    public String aboutController(Model model) {

        String currentPage = "about";
        model.addAttribute("currentPage", currentPage);

        model.addAttribute("userIsLogged", this.authService.isLogged());
        model.addAttribute("user", this.authService.getUser());

        return "about/aboutPage";
    }

    @GetMapping("/about/all")
    public String allUsersController(Model model) {
    /*
    * Lists all users
     */
        String currentPage = "about";
        model.addAttribute("currentPage", currentPage);
        List<UserAccount> allUsers = this.authService.findAll();
        model.addAttribute("allUsers", allUsers);

        return "about/allUsers";
    }
}

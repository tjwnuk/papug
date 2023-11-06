package pl.papug.papug.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import pl.papug.papug.model.UserAccount;
import pl.papug.papug.security.DbUserService;

import java.util.List;

@Controller
//@RequestMapping("/about")
public class AboutController {

    DbUserService dbUserService;

    public AboutController(DbUserService dbUserService) {
        this.dbUserService = dbUserService;
    }

    @GetMapping("/about")
    public String aboutController(Model model) {

        String currentPage = "about";
        model.addAttribute("currentPage", currentPage);
        return "about/aboutPage";
    }

    @GetMapping("/about/all")
    public String allUsersController(Model model) {
    /*
    * Lists all users
     */
        String currentPage = "about";
        model.addAttribute("currentPage", currentPage);
        List<UserAccount> allUsers = dbUserService.findAll();
        model.addAttribute("allUsers", allUsers);

        return "about/allUsers";
    }
}

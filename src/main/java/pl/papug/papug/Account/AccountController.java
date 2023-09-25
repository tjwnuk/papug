package pl.papug.papug.Account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/my-account")
    public String myAccount(Model model) {

        model.addAttribute("currentPage", "myAccount");
        return "account/details";
    }
}

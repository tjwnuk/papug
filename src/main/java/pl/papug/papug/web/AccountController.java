package pl.papug.papug.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.papug.papug.service.AuthService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthService authService;

    @GetMapping("/my-account")
    public String myAccount(Model model, HttpServletRequest request) {
        model.addAttribute("user", request.getUserPrincipal());
        model.addAttribute("currentPage", "myAccount");;

        model.addAttribute("userIsLogged", this.authService.isLogged());
        model.addAttribute("user", this.authService.getUser());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "account/details";
    }
}

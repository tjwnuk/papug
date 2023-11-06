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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/my-account")
    public String myAccount(Model model, HttpServletRequest request) {
        model.addAttribute("user", request.getUserPrincipal());
        model.addAttribute("currentPage", "myAccount");;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        List<String> roles = new ArrayList<String>();

        for (GrantedAuthority ga : authorities) {
            roles.add(ga.toString());
        }

        model.addAttribute("roles", roles);

        return "account/details";
    }
}

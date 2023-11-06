package pl.papug.papug.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.papug.papug.model.UserAccount;
import pl.papug.papug.repository.UserRepository;

@Service
public class AuthService {
    UserDetailsService userDetailsService;
    UserRepository userRepository;

    public AuthService(UserDetailsService userDetailsService, UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }

    public boolean isLogged() {
        UserAccount userAccount = this.getUser();
        return userAccount != null;
    }

    public UserAccount getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = authentication.getName();

        return userRepository.findByUsername(username);
    }
}

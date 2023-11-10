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

import java.util.List;

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
        String username = authentication.getName();

        return userRepository.findByUsername(username);
    }

    public UserAccount register(String username, String password) {
        UserAccount newUser = new UserAccount(username, password, "ROLE_USER");
        UserAccount result = userRepository.save(newUser);

        return result;
    }

    public boolean userExists(String username) {
        UserAccount user = this.userRepository.findByUsername(username);
        return user != null;
    }

    public List<UserAccount> findAll() {
        return this.userRepository.findAll();
    }
}

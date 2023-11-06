package pl.papug.papug.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import pl.papug.papug.repository.UserRepository;
import pl.papug.papug.model.UserAccount;

@Configuration
public class SecurityConfig {

//    @Bean
//    CommandLineRunner initUsers(UserManagementRepository repository) {
//        return args -> {
//            repository.save(new UserAccount("admin", "pass", "ROLE_ADMIN"));
//            repository.save(new UserAccount("user", "pass", "ROLE_USER"));
//            repository.save(new UserAccount("alice", "pass", "ROLE_USER"));
//            repository.save(new UserAccount("bob", "pass", "ROLE_USER"));
//        };
//    }

//    @Bean
//    UserDetailsService userService(UserRepository repo) {
//        return username -> repo.findByUsername(username).asUser();
//    }

    private UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            UserAccount user = userRepository.findByUsername(username);
            if (user != null) {
                return new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        user.getRoles()
                );
            }
            throw new Error("User not found.");
        };
    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/", "/about", "/images/**", "/page", "/post/**", "/page/", "/page/**").permitAll()
                                .requestMatchers("/my-account", "/my-account/**").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/admin", "/about/all").hasRole("ADMIN")
                                .anyRequest().denyAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
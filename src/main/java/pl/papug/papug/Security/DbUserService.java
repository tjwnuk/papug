package pl.papug.papug.Security;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbUserService implements UserRepository {
    UserRepository userRepository;

    public DbUserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<UserAccount> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public UserAccount findByUsername(String username) {
        return this.findByUsername(username);
    }
}

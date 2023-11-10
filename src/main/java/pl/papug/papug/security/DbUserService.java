//package pl.papug.papug.security;
//
//import org.springframework.stereotype.Service;
//import pl.papug.papug.model.UserAccount;
//import pl.papug.papug.repository.UserRepository;
//
//import java.util.List;
//
//@Service
//public class DbUserService implements UserRepository {
//    UserRepository userRepository;
//
//    public DbUserService (UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//    @Override
//    public List<UserAccount> findAll() {
//        return this.userRepository.findAll();
//    }
//
//    @Override
//    public UserAccount findByUsername(String username) {
//        return this.userRepository.findByUsername(username);
//    }
//}

package pl.papug.papug.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.papug.papug.model.UserAccount;
import pl.papug.papug.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService implements UserRepository {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserAccount findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public <S extends UserAccount> Iterable<S> saveAll(Iterable<S> entities) {
        return this.userRepository.saveAll(entities);
    }

    @Override
    public Optional<UserAccount> findById(Long aLong) {
        return this.userRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return this.userRepository.existsById(aLong);
    }

    @Override
    public List<UserAccount> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Iterable<UserAccount> findAllById(Iterable<Long> longs) {
        return this.userRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        this.userRepository.deleteById(aLong);
    }

    @Override
    public UserAccount save(UserAccount user) {
        return this.userRepository.save(user);
    }

    @Override
    public void delete(UserAccount user) {
        this.userRepository.delete(user);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        this.userRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends UserAccount> entities) {
        this.userRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        this.userRepository.deleteAll();
    }

//    public boolean isMod(String username) {
//        String role = this.userRepository.findByUsername(username).getRole();
//
//        if (role.equals("ROLE_MOD") || role.equals("ROLE_ADMIN")) {
//            return true;
//        }
//        return false;
//    }

    public boolean setMod(String username) {
        UserAccount user = this.userRepository.findByUsername(username);
        user.setRole("ROLE_MOD");
        this.userRepository.save(user);
        return true;
    }

    public boolean unsetMod(String username) {
        UserAccount user = this.userRepository.findByUsername(username);
        user.setRole("ROLE_USER");
        this.userRepository.save(user);
        return false;
    }

}

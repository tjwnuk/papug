package pl.papug.papug.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import pl.papug.papug.model.UserAccount;

import java.util.List;

@Primary
public interface UserRepository extends CrudRepository<UserAccount, Long> {
    UserAccount findByUsername(String username);
    List<UserAccount> findAll();
    UserAccount save(UserAccount user);
}

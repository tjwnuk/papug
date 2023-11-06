package pl.papug.papug.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.Repository;
import pl.papug.papug.model.UserAccount;

import java.util.List;

@Primary
public interface UserRepository extends Repository<UserAccount, Long> {
    UserAccount findByUsername(String username);
    List<UserAccount> findAll();
}

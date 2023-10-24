package pl.papug.papug.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.Repository;
import pl.papug.papug.Security.UserAccount;

import java.util.List;

@Primary
public interface UserRepository extends Repository<UserAccount, Long> {
    UserAccount findByUsername(String username);
    List<UserAccount> findAll();
}

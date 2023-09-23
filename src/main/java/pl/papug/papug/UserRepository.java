package pl.papug.papug;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserAccount, Long> {
    UserAccount findByUsername(String username);
}

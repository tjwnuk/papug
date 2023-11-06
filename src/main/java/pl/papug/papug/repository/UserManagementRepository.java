package pl.papug.papug.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.papug.papug.model.UserAccount;

public interface UserManagementRepository extends JpaRepository<UserAccount, Long> {}
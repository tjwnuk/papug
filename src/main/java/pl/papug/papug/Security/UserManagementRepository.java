package pl.papug.papug.Security;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.papug.papug.Security.UserAccount;

public interface UserManagementRepository extends JpaRepository<UserAccount, Long> {}
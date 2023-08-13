package pl.papug.papug.PapugUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PapugUserRepository extends JpaRepository<PapugUser, Long> {
}

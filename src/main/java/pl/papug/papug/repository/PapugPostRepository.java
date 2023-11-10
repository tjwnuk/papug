package pl.papug.papug.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.papug.papug.model.PapugPostEntity;

import java.util.List;

@Repository
public interface PapugPostRepository extends JpaRepository<PapugPostEntity, Long> {
    List<PapugPostEntity> findById(long id);

//    Page<PapugPostEntity> findAll(Pageable pageable);
    List<PapugPostEntity> findByTitle(String title);
    List<PapugPostEntity> findByUserAccount(String username);

    void deleteById(Long id);

}

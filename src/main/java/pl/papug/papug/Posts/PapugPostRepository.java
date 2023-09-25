package pl.papug.papug.Posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PapugPostRepository extends JpaRepository<PapugPostEntity, Long> {
    List<PapugPostEntity> findById(long id);

//    Page<PapugPostEntity> findAll(Pageable pageable);
    List<PapugPostEntity> findByTitle(String title);

}

package pl.papug.papug.Posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PapugPostRepository extends JpaRepository<PapugPostEntity, Long> {
    List<PapugPostEntity> findById(long id);

//    Page<PapugPostEntity> findAll(Pageable pageable);
    List<PapugPostEntity> findByTitle(String title);

}

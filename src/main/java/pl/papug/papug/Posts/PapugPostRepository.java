package pl.papug.papug.Posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PapugPostRepository extends JpaRepository<PapugPostEntity, Long> {
}
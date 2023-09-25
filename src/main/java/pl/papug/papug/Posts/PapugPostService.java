package pl.papug.papug.Posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PapugPostService {
        private final PapugPostRepository papugPostRepository;

        public PapugPostService(PapugPostRepository papugPostRepository) {
            this.papugPostRepository = papugPostRepository;
        }

        public Page<PapugPostEntity> getEntities(int pageNumber, int pageSize) {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            return papugPostRepository.findAll(pageable);
        }
}

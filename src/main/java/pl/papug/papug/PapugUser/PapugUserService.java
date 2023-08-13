package pl.papug.papug.PapugUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PapugUserService {

    private final PapugUserRepository papugUserRepository;

    @Autowired
    public PapugUserService(PapugUserRepository papugUserRepository) {
        this.papugUserRepository = papugUserRepository;
    }

    public List<PapugUser> getAllUsers() {
        return papugUserRepository.findAll();
    }

    public Optional<PapugUser> getUserById(Long id) {
        return papugUserRepository.findById(id);
    }

    public void saveUser(PapugUser user) {
        papugUserRepository.save(user);
    }

    public void deleteUser(Long id) {
        papugUserRepository.deleteById(id);
    }
}


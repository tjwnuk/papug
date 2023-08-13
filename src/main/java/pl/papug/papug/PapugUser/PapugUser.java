package pl.papug.papug.PapugUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PapugUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String fullname;
    private String password;
    private String phoneNumber;

    public PapugUser(String username, String email, String fullname, String password, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}

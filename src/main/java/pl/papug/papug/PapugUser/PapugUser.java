package pl.papug.papug.PapugUser;

import jakarta.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    public PapugUser(String username, String email, String fullname, String password, String phoneNumber, AccountType accountType) {
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
    }
}

package pl.papug.papug.model;

import jakarta.persistence.*;

import java.util.*;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class UserAccount implements UserDetails {

    @Getter
    @Id
    @GeneratedValue //
    private Long id;
    @Getter
    @Column(unique = true)
    private String username;
    @Getter
    private String password;
    @Getter
    private String role;
    @ElementCollection(fetch = FetchType.EAGER) //
    private List<GrantedAuthority> authorities = //
            new ArrayList<>();

    protected UserAccount() {
    }

    public UserAccount(String username, String password, String role, String... authorities) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.authorities = Arrays.stream(authorities) //
                .map(SimpleGrantedAuthority::new) //
                .map(GrantedAuthority.class::cast) //
                .toList();
    }

    public UserDetails asUser() {
        return User.withDefaultPasswordEncoder() //
                .username(getUsername()) //
                .password(getPassword()) //
                .authorities(getAuthorities()) //
                .build();
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GrantedAuthority> getAuthorities() {
        if (authorities == null) {
            this.authorities = new ArrayList<>();
        }
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserAccount user = (UserAccount) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username)
                && Objects.equals(password, user.password) && Objects.equals(authorities, user.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, authorities);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", authorities="
                + authorities + '}';
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.role));
        return authorities;
    }

}
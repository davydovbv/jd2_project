package by.academy.it.user.pojo;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "user_credentials")
@Data
public class AppUserCredentials implements Serializable, UserDetails {

    @Id
    @Column(name = "user_credentials_id")
    @SequenceGenerator(name = "user_credentials_pk", sequenceName = "user_credentials_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_credentials_pk")
    private Integer id;

    @Column(name = "app_user_id")
    private int appUserId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "isActive")
    @ColumnDefault("true")
    private boolean active;

    @Column(name = "account_expired")
    @ColumnDefault("false")
    private boolean accountExpired;

    @Column(name = "account_locked")
    @ColumnDefault("false")
    private boolean accountLocked;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !accountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !accountLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
}

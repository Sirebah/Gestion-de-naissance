package Sire.tech.profiles;

import java.awt.PageAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Sire.tech.shared.entities.Adresse;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "profiles")
public class Profile implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Civility civility;

    @Column(length = 100, unique = true)
    private String email;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    private String phone;

    @Column(length = 150)
    private String Password;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "roles_id")
    private Role role;

    public boolean active;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // Création de la liste de simple GrantedAuthority
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        // Ajout du role

        authorities.add(new SimpleGrantedAuthority("ROLE_"+ this.role.getName().toUpperCase()));

        // Ajout de la liste des permissions

        for (Permission permission : this.role.getPermissions()) {
            authorities.add(new SimpleGrantedAuthority(permission.getName().toUpperCase()));
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.active;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}

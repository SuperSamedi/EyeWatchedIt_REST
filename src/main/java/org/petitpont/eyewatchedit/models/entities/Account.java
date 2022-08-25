package org.petitpont.eyewatchedit.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter @Setter
@NoArgsConstructor
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "WATCHED_FILM",
        joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
        inverseJoinColumns = @JoinColumn(name = "FILM_ID")
    )
    private Set<Film> watchedList = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    @Column(name = "JOINED_DATE")
    private LocalDateTime joinDate;

    @Column(name = "ENABLED")
    boolean enabled = true;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map( role -> new SimpleGrantedAuthority("ROLE_" + role))
                .toList();
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

}

package org.petitpont.eyewatchedit.services.Impl;

import org.petitpont.eyewatchedit.mappers.AccountMapper;
import org.petitpont.eyewatchedit.models.dtos.AccountDTO;
import org.petitpont.eyewatchedit.models.entities.Account;
import org.petitpont.eyewatchedit.models.forms.AccountSignUpForm;
import org.petitpont.eyewatchedit.repositories.AccountRepository;
import org.petitpont.eyewatchedit.services.AccountService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService, AccountService {

    private final AccountRepository repository;
    private final AccountMapper mapper;
    private final PasswordEncoder encoder;

    public CustomUserDetailsServiceImpl(AccountRepository repository, AccountMapper mapper, PasswordEncoder encoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.encoder = encoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("Username not found.") );
    }

    @Override
    public AccountDTO signUp(AccountSignUpForm form ) {
        Account account = mapper.toEntity( form );
        account.setPassword( encoder.encode( account.getPassword() ) );
        return mapper.toDTO( repository.save( account ) );
    }
}

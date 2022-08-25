package org.petitpont.eyewatchedit.mappers;

import org.petitpont.eyewatchedit.models.dtos.AccountDTO;
import org.petitpont.eyewatchedit.models.entities.Account;
import org.petitpont.eyewatchedit.models.forms.AccountSignUpForm;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountMapper {

    public Account toEntity(AccountSignUpForm form) {
        Account account = new Account();

        account.setUsername( form.getUsername() );
        account.setPassword(form.getPassword() );
        account.setRoles( List.of("MEMBER") );

        return account;
    }

    public AccountDTO toDTO( Account entity ) {
        AccountDTO dto = new AccountDTO();

        dto.setId(entity.getId() );
        dto.setUsername( entity.getUsername() );

        return dto;
    }
}

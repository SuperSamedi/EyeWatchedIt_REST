package org.petitpont.eyewatchedit.services;

import org.petitpont.eyewatchedit.models.dtos.AccountDTO;
import org.petitpont.eyewatchedit.models.forms.AccountSignUpForm;


public interface AccountService {

    AccountDTO signUp(AccountSignUpForm form);

}

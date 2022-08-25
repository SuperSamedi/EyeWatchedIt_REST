package org.petitpont.eyewatchedit.controllers;

import org.petitpont.eyewatchedit.models.dtos.AccountDTO;
import org.petitpont.eyewatchedit.models.forms.AccountSignUpForm;
import org.petitpont.eyewatchedit.services.Impl.CustomUserDetailsServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/account")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AccountController {
    private final CustomUserDetailsServiceImpl service;

    public AccountController(CustomUserDetailsServiceImpl service) {
        this.service = service;
    }


    @PostMapping(path = "/sign-up")
    public AccountDTO signUp(@Valid @RequestBody AccountSignUpForm form) {
        return service.signUp(form);
    }

}

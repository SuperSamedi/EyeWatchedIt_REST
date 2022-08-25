package org.petitpont.eyewatchedit.controllers;

import org.petitpont.eyewatchedit.models.dtos.FilmDTO;
import org.petitpont.eyewatchedit.models.forms.FilmAddForm;
import org.petitpont.eyewatchedit.services.FilmService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping(path = "/api/film")
public class FilmController {

    private final FilmService service;

    public FilmController(FilmService service) {
        this.service = service;
    }



    @PostMapping(path = "/add")
    public FilmDTO create(@Valid @RequestBody FilmAddForm form) {
        return service.create(form);
    }

    @GetMapping(path = "/all")
    public List<FilmDTO> getAll() {
            return service.getAll();
    }

    @DeleteMapping(path = "/{id:[0-9]+}")
    public boolean delete( @NotNull @PathVariable Long id ) {
        return service.delete( id );
    }

}

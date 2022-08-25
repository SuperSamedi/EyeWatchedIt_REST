package org.petitpont.eyewatchedit.services;

import org.petitpont.eyewatchedit.models.dtos.FilmDTO;
import org.petitpont.eyewatchedit.models.forms.FilmAddForm;

import java.util.List;

public interface FilmService {

        List<FilmDTO> getAll();
        FilmDTO create(FilmAddForm form);
        boolean delete(Long id);

}

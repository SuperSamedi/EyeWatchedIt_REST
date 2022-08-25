package org.petitpont.eyewatchedit.mappers;

import org.petitpont.eyewatchedit.models.dtos.FilmDTO;
import org.petitpont.eyewatchedit.models.entities.Film;
import org.petitpont.eyewatchedit.models.forms.FilmAddForm;
import org.springframework.stereotype.Service;

@Service
public class FilmMapper {

    public FilmDTO toDTO(Film entity) {
        FilmDTO dto = new FilmDTO();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());

        return dto;
    }


    public Film toEntity(FilmAddForm form) {
        if (form == null) {
            return null;
        }

        Film entity = new Film();

        entity.setTitle(form.getTitle());

        return entity;
    }
}

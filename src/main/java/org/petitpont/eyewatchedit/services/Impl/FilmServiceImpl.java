package org.petitpont.eyewatchedit.services.Impl;

import org.petitpont.eyewatchedit.exceptions.ElementNotFoundException;
import org.petitpont.eyewatchedit.mappers.FilmMapper;
import org.petitpont.eyewatchedit.models.dtos.FilmDTO;
import org.petitpont.eyewatchedit.models.entities.Film;
import org.petitpont.eyewatchedit.models.forms.FilmAddForm;
import org.petitpont.eyewatchedit.repositories.FilmRepository;
import org.petitpont.eyewatchedit.services.FilmService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository repository;
    private final FilmMapper mapper;

    public FilmServiceImpl(FilmRepository repository, FilmMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public FilmDTO create(@NotNull FilmAddForm form) {
        Film film = mapper.toEntity(form);
        film = repository.save(film);

        return mapper.toDTO(film);
    }

    @Override
    public List<FilmDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public boolean delete(Long id) {
        Film entity = repository.findById(id)
                .orElseThrow( () -> new ElementNotFoundException(Film.class, id));

        repository.delete(entity);
        return true;
    }

}

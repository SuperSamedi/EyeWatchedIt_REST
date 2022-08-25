package org.petitpont.eyewatchedit.utils;

import org.petitpont.eyewatchedit.models.forms.FilmAddForm;
import org.petitpont.eyewatchedit.services.FilmService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataInit implements InitializingBean {

    private final FilmService filmService;

    public DataInit(FilmService filmService) {
        this.filmService = filmService;
    }


    private List<FilmAddForm> films = List.of(
        new FilmAddForm("The Sea Beast"),
        new FilmAddForm("The Lord of the Rings: The Fellowship of the Ring"),
        new FilmAddForm("The Lord of the Rings: The Two Towers"),
        new FilmAddForm("The Lord of the Rings: The Return of the King")
    );


    @Override
    public void afterPropertiesSet() throws Exception {
//        films.forEach(filmService::create);
    }
}

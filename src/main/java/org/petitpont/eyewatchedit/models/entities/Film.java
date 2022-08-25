package org.petitpont.eyewatchedit.models.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.petitpont.eyewatchedit.utils.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "running_time")
    private Long runningTime;

    @Column(name = "poster_link")
    private String posterLink;

    @Column(name = "wikipedia_link")
    private String wikipediaLink;

    private Float rating;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Category> categories = new ArrayList<>();

    public Film(String title) {
        this.title = title;
    }
}

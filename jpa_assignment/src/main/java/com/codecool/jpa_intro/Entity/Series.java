package com.codecool.jpa_intro.Entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {

    public enum Rating {
        UNRATED,
        G,
        EVERYONE,
        ADULT
    }

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Singular
    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Season> seasons;
}

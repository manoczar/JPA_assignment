package com.codecool.jpa_intro.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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

    @OneToOne
    private Season season;
}

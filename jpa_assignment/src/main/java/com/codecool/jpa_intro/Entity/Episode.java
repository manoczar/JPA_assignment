package com.codecool.jpa_intro.Entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Episode {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private int length;

    @ElementCollection
    @Singular
    private List <String> guestActors;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Season season;


}

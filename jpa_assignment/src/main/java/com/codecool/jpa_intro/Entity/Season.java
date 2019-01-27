package com.codecool.jpa_intro.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {


    @Id
    @GeneratedValue
    private Long id;

    private int title;

    @Transient
    private int transientInt;

    @Singular
    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Episode> episodes;

    @ManyToOne
    private Series series;

}

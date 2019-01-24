package com.codecool.jpa_intro.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Episode {

    @Id
    @GeneratedValue
    private Long id;

    private Long seasonId;

    @OneToOne(mappedBy="Id")
    private Season season;

    private String title;

    private int length;


}

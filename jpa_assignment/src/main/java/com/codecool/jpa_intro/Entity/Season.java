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
public class Season {


    @Id
    @GeneratedValue
    private Long id;

    public Long seriesId;

    private int title;

    @Transient
    private int transientInt;

    @OneToOne(mappedBy = "Id")
    private Series series;

}

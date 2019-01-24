package com.codecool.jpa_intro.repository;

import com.codecool.jpa_intro.Entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository <Series, Long> {

}

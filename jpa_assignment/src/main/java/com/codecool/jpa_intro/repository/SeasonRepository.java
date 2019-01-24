package com.codecool.jpa_intro.repository;

import com.codecool.jpa_intro.Entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository <Season, Long> {

}

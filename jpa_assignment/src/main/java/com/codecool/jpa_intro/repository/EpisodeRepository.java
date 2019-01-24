package com.codecool.jpa_intro.repository;

import com.codecool.jpa_intro.Entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository <Episode, Long> {

}

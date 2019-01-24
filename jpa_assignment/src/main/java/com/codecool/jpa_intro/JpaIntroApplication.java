package com.codecool.jpa_intro;

import com.codecool.jpa_intro.Entity.Episode;
import com.codecool.jpa_intro.Entity.Season;
import com.codecool.jpa_intro.Entity.Series;
import com.codecool.jpa_intro.repository.EpisodeRepository;
import com.codecool.jpa_intro.repository.SeasonRepository;
import com.codecool.jpa_intro.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class JpaIntroApplication {

   @Autowired
   private SeriesRepository seriesRepository;
   @Autowired
   private SeasonRepository seasonRepository;
   @Autowired
   private EpisodeRepository episodeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaIntroApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {

        return args -> {
            Series bigBangTheory = Series.builder()
                    .title("Big Bang Theory")
                    .releaseDate(LocalDate.of(2008, 03, 15))
                    .rating(Series.Rating.ADULT)
                    .build();

            seriesRepository.save(bigBangTheory);

            for (int i = 1; i < 8; i++) {
                Season bigBangTheorySeasons = Season.builder()
                        .seriesId(bigBangTheory.getId())
                        .title(i)
                        .transientInt(i)
                        .build();

                seasonRepository.save(bigBangTheorySeasons);

            }

            for (int i = 1; i < 11; i++) {
                Episode bigBangTheoryEpisode = Episode.builder()
                        .id(bigBangTheory.getId())
                        .length(40)
                        .title("Episode " + i)
                        .build();

                episodeRepository.save(bigBangTheoryEpisode);

            }

        };

    }

}


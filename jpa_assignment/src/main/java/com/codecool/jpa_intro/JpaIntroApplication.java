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
   SeasonRepository seasonRepository;
   @Autowired
   private EpisodeRepository episodeRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaIntroApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {

        return args -> {

            Episode bigBangTheoryEpisode1 = Episode.builder()
                    .length(40)
                    .title("Episode 1")
                    .guestActor("Robert Downey Jr")
                    .guestActor("Michael J. Fox")
                    .guestActor("Darth Vader")
                    .build();

            Episode bigBangTheoryEpisode2 = Episode.builder()
                    .length(40)
                    .title("Episode 2")
                    .guestActor("Yoda")
                    .build();

            Episode bigBangTheoryEpisode3 = Episode.builder()
                    .length(40)
                    .title("Episode 3")
                    .guestActor("Iron Man")
                    .build();


            Season bigBangTheorySeasons1 = Season.builder()
                    .title(1)
                    .episode(bigBangTheoryEpisode1)
                    .episode(bigBangTheoryEpisode2)
                    .transientInt(1)
                    .build();

            Season bigBangTheorySeasons2 = Season.builder()
                    .title(2)
                    .episode(bigBangTheoryEpisode3)
                    .transientInt(1)
                    .build();


            Series bigBangTheory = Series.builder()
                    .title("Big Bang Theory")
                    .releaseDate(LocalDate.of(2008, 03, 15))
                    .rating(Series.Rating.ADULT)
                    .season(bigBangTheorySeasons1)
                    .season(bigBangTheorySeasons2)
                    .build();

            bigBangTheoryEpisode1.setSeason(bigBangTheorySeasons1);
            bigBangTheoryEpisode2.setSeason(bigBangTheorySeasons1);
            bigBangTheoryEpisode3.setSeason(bigBangTheorySeasons2);

            bigBangTheorySeasons1.setSeries(bigBangTheory);
            bigBangTheorySeasons2.setSeries(bigBangTheory);

            seriesRepository.save(bigBangTheory);


            /*for (int i = 1; i < 8; i++) {


                for (int j = 1; j < 11; j++) {

                }

            }*/



        };

    }

}


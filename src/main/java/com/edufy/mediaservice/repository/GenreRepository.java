package com.edufy.mediaservice.repository;

import com.edufy.mediaservice.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {


    Genre findByName(String genreName);
}

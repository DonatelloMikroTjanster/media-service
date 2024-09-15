package com.edufy.mediaservice.repository;

import com.edufy.mediaservice.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    ;
}

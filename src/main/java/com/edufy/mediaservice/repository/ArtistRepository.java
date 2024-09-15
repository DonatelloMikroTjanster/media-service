package com.edufy.mediaservice.repository;

import com.edufy.mediaservice.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findByName(String name);
}

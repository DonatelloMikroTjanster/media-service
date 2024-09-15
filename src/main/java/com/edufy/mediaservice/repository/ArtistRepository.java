package com.edufy.mediaservice.repository;

import com.edufy.mediaservice.entity.Artist;
import com.edufy.mediaservice.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    ;
}

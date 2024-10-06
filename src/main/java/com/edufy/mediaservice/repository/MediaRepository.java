package com.edufy.mediaservice.repository;

import com.edufy.mediaservice.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {

    List<Media> findByMediaType(String mediaType);
    List<Media> findByGenreName(String name);
    List<Media> findByArtistsId(Long id);


}

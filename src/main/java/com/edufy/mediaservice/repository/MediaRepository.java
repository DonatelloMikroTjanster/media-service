package com.edufy.mediaservice.repository;

import com.edufy.mediaservice.entities.Media;
import com.edufy.mediaservice.entities.MediaCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {
    List<Media> findByCategory(MediaCategory category);
    List<Media> findByGenresName(String genreName);
    List<Media> findByArtistsId(Long id);


}

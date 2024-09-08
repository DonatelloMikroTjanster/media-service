package com.edufy.mediaservice.repository;

import com.edufy.mediaservice.entity.Media;
import com.edufy.mediaservice.entity.MediaCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media, Long> {

    List<Media> findByTitleContaining(String title);
    List<Media> findByCategory(MediaCategory category);
    List<Media> findByGenresName(String genreName);
    List<Media> findByArtistsName(String artistName);

}

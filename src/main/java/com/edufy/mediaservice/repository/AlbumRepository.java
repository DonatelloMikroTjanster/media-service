package com.edufy.mediaservice.repository;

import com.edufy.mediaservice.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}

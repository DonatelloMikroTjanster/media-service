package com.edufy.mediaservice.services;

import com.edufy.mediaservice.entities.Album;
import com.edufy.mediaservice.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Optional<Album> getAlbumById(Long id) {
        return albumRepository.findById(id);
    }

    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    public Album updateAlbum(Long id, Album albumDetails) {

        Optional<Album> album = albumRepository.findById(id);
        if (album.isPresent()) {
            albumDetails.setId(id);
            return albumRepository.save(albumDetails);
        } else {
            return null;
        }

    }


    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }




}

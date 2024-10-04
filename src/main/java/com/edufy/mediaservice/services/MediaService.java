package com.edufy.mediaservice.services;

import com.edufy.mediaservice.entities.*;
import com.edufy.mediaservice.repository.AlbumRepository;
import com.edufy.mediaservice.repository.ArtistRepository;
import com.edufy.mediaservice.repository.GenreRepository;
import com.edufy.mediaservice.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MediaService {


    @Autowired
    private MediaRepository mediaRepository;
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private GenreRepository genreRepository;


    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    public Optional<Media> getMediaById(Long id) {
        return mediaRepository.findById(id);
    }


    public List<Media> getMediaByType(String mediaType) {

        List<Media> mediaList = mediaRepository.findByMediaType(mediaType);
        if (mediaList.isEmpty()) {
            throw new RuntimeException("No media found for category");
        }
        return mediaList;
    }

    public List<Media> getMediaByGenre(String genre) {

        String genreName = genre.substring(0, 1).toUpperCase() + genre.substring(1).toLowerCase();
        List<Media> mediaList = mediaRepository.findByGenreName(genreName);
        if (mediaList.isEmpty()) {
            throw new RuntimeException("No media found for genre");
        } else {
            return mediaList;
        }
    }

    public List<Media> getAllMediaByArtistId(Long id) {
        List<Media> mediaList =  mediaRepository.findByArtistsId(id);
        if (mediaList.isEmpty()) {
            throw new RuntimeException("No media found for artist");
        } else {
            return mediaList;
        }
    }

    public Media saveMedia(Media media) {
        validateMedia(media);

        if (media.getAlbum() != null) {
            media.setAlbum(findAlbumById(media.getAlbum().getId()));
        }

        if (media.getArtists() != null && !media.getArtists().isEmpty()) {
            media.setArtists(findArtistsByIds(media.getArtists()));
        }

        if (media.getGenre() != null && !media.getGenre().getName().isEmpty()) {
            media.setGenre(findGenreByName(media.getGenre().getName()));
        } else {
            throw new RuntimeException("Genre not found");
        }

        return mediaRepository.save(media);
    }

    private void validateMedia(Media media) {
        if (media.getTitle() == null || media.getTitle().isEmpty()) {
            throw new RuntimeException("Title is required");
        }
        if (media.getUrl() == null || media.getUrl().isEmpty()) {
            throw new RuntimeException("URL is required");
        }
        if (media.getReleaseDate() == null) {
            throw new RuntimeException("Release date is required");
        }
        if (media.getMediaType() == null) {
            throw new RuntimeException("Category is required");
        }
    }

    private Album findAlbumById(Long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album not found"));
    }

    private Set<Artist> findArtistsByIds(Set<Artist> artists) {
        Set<Artist> foundArtists = new HashSet<>();
        for (Artist artist : artists) {
            foundArtists.add(artistRepository.findById(artist.getId())
                    .orElseThrow(() -> new RuntimeException("Artist not found")));
        }
        return foundArtists;
    }

    private Genre findGenreByName(String name) {
        String genreName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        return genreRepository.findByName(genreName);
    }

    public Media updateMedia(Long id, Media mediaDetails) {
        Media media = mediaRepository.findById(id).orElse(null);
        if (media != null) {
            mediaDetails.setId(id);
            return mediaRepository.save(mediaDetails);
        } else {
            throw new RuntimeException("Media not found");
        }
    }

    public void deleteMedia(Long id) {
        try {
            mediaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EmptyResultDataAccessException("Media not found", 1);
        }
    }


}
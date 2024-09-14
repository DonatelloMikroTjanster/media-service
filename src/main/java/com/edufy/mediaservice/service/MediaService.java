package com.edufy.mediaservice.service;

import com.edufy.mediaservice.entity.*;
import com.edufy.mediaservice.repository.AlbumRepository;
import com.edufy.mediaservice.repository.ArtistRepository;
import com.edufy.mediaservice.repository.GenreRepository;
import com.edufy.mediaservice.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public Media saveMedia(Media media) {
        if (media.getTitle() == null || media.getTitle().isEmpty()) {
            throw new RuntimeException("Title is required");
        }
        if (media.getUrl() == null || media.getUrl().isEmpty()) {
            throw new RuntimeException("URL is required");
        }
        if (media.getReleaseDate() == null) {
            throw new RuntimeException("Release date is required");
        }
        if (media.getCategory() == null) {
            throw new RuntimeException("Category is required");
        }

        if (media.getAlbum() != null) {
            Optional<Album> album = albumRepository.findById(media.getAlbum().getId());
            if (album.isPresent()) {
                media.setAlbum(album.get());
            } else {
                throw new RuntimeException("Album not found");
            }
        }

        if (media.getArtists() != null && !media.getArtists().isEmpty()) {
            Set<Artist> artists = new HashSet<>();
            for (Artist artist : media.getArtists()) {
                Optional<Artist> foundArtist = artistRepository.findById(artist.getId());
                if (foundArtist.isPresent()) {
                    artists.add(foundArtist.get());
                } else {
                    throw new RuntimeException("Artist not found");
                }
            }
            media.setArtists(artists);
        }

        if (media.getGenres() != null && !media.getGenres().isEmpty()) {
            Set<Genre> genres = new HashSet<>();
            for (Genre genre : media.getGenres()) {
                Optional<Genre> foundGenre = genreRepository.findById(genre.getId());
                if (foundGenre.isPresent()) {
                    genres.add(foundGenre.get());
                } else {
                    throw new RuntimeException("Genre not found");
                }
            }
            media.setGenres(genres);
        }


        return mediaRepository.save(media);

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

    public List<Media> getMediaByCategory(MediaCategory category) {
        return mediaRepository.findByCategory(category);
    }

}

package com.edufy.mediaservice.services;

import com.edufy.mediaservice.entities.Genre;
import com.edufy.mediaservice.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(Long id) {
        return genreRepository.findById(id);
    }

    public Genre saveGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre updateGenre(Long id, Genre genreDetails) {

        Optional<Genre> genre = genreRepository.findById(id);
        if (genre.isPresent()) {
            genreDetails.setId(id);
            return genreRepository.save(genreDetails);
        } else {
            return null;
        }

    }

    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}

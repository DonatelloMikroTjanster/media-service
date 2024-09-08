package com.edufy.mediaservice.controller;


import com.edufy.mediaservice.entity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  com.edufy.mediaservice.service.GenreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<Genre> getAllGenres() {
        return genreService.getAllGenres();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id) {
        Optional<Genre> genre = genreService.getGenreById(id);
        return genre.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreService.saveGenre(genre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genreDetails) {
        Genre updatedGenre = genreService.updateGenre(id, genreDetails);
        return ResponseEntity.ok(updatedGenre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return ResponseEntity.noContent().build();
    }




}

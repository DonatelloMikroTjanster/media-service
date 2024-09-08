package com.edufy.mediaservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edufy.mediaservice.service.ArtistService;
import com.edufy.mediaservice.entity.Artist;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        Optional<Artist> artist = artistService.getArtistById(id);
        return artist.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistService.saveArtist(artist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artist> updateArtist(@PathVariable Long id, @RequestBody Artist artistDetails) {
        Artist updatedArtist = artistService.updateArtist(id, artistDetails);
        return ResponseEntity.ok(updatedArtist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return ResponseEntity.noContent().build();
    }




}

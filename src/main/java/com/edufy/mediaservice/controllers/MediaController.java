package com.edufy.mediaservice.controllers;

import com.edufy.mediaservice.entities.Media;
import com.edufy.mediaservice.entities.MediaCategory;
import com.edufy.mediaservice.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;


    @GetMapping
    public List<Media> getAllMedia() {
        return mediaService.getAllMedia();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Media> getMediaById(@PathVariable Long id) {
        Optional<Media> media = mediaService.getMediaById(id);
        return media.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/artist/{id}")
    public ResponseEntity<?> getMediaByArtist(@PathVariable Long id) {
        try {
            List<Media> mediaList = mediaService.getAllMediaByArtistId(id);
            return ResponseEntity.ok(mediaList);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/bygenre/{genre}")
    public ResponseEntity<?> getMediaByGenre(@PathVariable String genre) {
        try {
            List<Media> mediaList = mediaService.getMediaByGenre(genre);
            return ResponseEntity.ok(mediaList);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/bycategory/{category}")
    public ResponseEntity<?> getMediaByCategory(@PathVariable String category) {
        try {
            MediaCategory mediaCategory = MediaCategory.valueOf(category.toUpperCase());
            List<Media> mediaList = mediaService.getMediaByCategory(mediaCategory);
            return ResponseEntity.ok(mediaList);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body("Invalid category");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


    @PostMapping
    public Media createMedia(@RequestBody Media media) {
        return mediaService.saveMedia(media);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Media> updateMedia(@PathVariable Long id, @RequestBody Media mediaDetails) {
        Media updatedMedia = mediaService.updateMedia(id, mediaDetails);
        return ResponseEntity.ok(updatedMedia);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
        return ResponseEntity.ok("Media with id " + id + " deleted successfully");
    }





}

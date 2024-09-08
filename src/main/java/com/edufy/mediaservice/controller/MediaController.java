package com.edufy.mediaservice.controller;

import com.edufy.mediaservice.entity.Media;
import com.edufy.mediaservice.entity.MediaCategory;
import com.edufy.mediaservice.service.MediaService;
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
    public ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
        mediaService.deleteMedia(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{category}")
    public List<Media> getMediaByCategory(@PathVariable MediaCategory category) {
        return mediaService.getMediaByCategory(category);
    }


}

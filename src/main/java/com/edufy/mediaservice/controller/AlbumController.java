package com.edufy.mediaservice.controller;

import com.edufy.mediaservice.entity.Album;
import com.edufy.mediaservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        Optional<Album> album = albumService.getAlbumById(id);
        return album.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
        return albumService.saveAlbum(album);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Album albumDetails) {
      Album updatedAlbum = albumService.updateAlbum(id, albumDetails);
        return ResponseEntity.ok(updatedAlbum);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.noContent().build();
    }




}

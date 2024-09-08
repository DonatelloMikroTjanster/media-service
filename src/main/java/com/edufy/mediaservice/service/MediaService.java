package com.edufy.mediaservice.service;

import com.edufy.mediaservice.entity.Media;
import com.edufy.mediaservice.entity.MediaCategory;
import com.edufy.mediaservice.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MediaService {


    @Autowired
    private MediaRepository mediaRepository;

    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    public Optional<Media> getMediaById(Long id) {
        return mediaRepository.findById(id);
    }

    public Media saveMedia(Media media) {
        return mediaRepository.save(media);
    }

    public Media updateMedia(Long id, Media mediaDetails) {
        Media media = mediaRepository.findById(id).orElse(null);
        if (media != null) {
            mediaDetails.setId(id);
            return mediaRepository.save(mediaDetails);
        } else {
            return null;
        }
    }

    public void deleteMedia(Long id) {
        mediaRepository.deleteById(id);
    }

    public List<Media> getMediaByCategory(MediaCategory category) {  // Updated method to handle MediaCategory
        return mediaRepository.findByCategory(category);
    }

}

package com.edufy.mediaservice.services;

import com.edufy.mediaservice.entities.Artist;
import com.edufy.mediaservice.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService  {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Artist saveArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist updateArtist(Long id, Artist artistDetails) {

        Optional<Artist> artist = artistRepository.findById(id);
        if (artist.isPresent()) {
            artistDetails.setId(id);
            return artistRepository.save(artistDetails);
        } else {
            return null;
        }

    }


    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }

}

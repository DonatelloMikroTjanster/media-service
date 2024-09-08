package com.edufy.mediaservice.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 100)
    private String title;

    @Column (name = "category", length = 100)
    @Enumerated(EnumType.STRING)
    private MediaCategory category;

    @Column(name = "release_date", length = 100)
    private Date releaseDate;

    @Column(name = "url", length = 100)
    private String url;

    @ManyToMany
    @JoinTable(name = "media_genre",
            joinColumns = @JoinColumn(name = "media_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToMany
    @JoinTable(name = "media_artist",
            joinColumns = @JoinColumn(name = "media_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private Set<Artist> artists;

    // Getters and setters


    public Media() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MediaCategory getCategory() {
        return category;
    }

    public void setCategory(MediaCategory category) {
        this.category = category;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }
}
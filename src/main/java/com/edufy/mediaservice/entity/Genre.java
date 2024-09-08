package com.edufy.mediaservice.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "name", length = 100 )
    private String name;

    @Column(name = "media", length = 100 )
    @ManyToMany(mappedBy = "genres")
    private Set<Media> media;

    public Genre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Media> getMedia() {
        return media;
    }

    public void setMedia(Set<Media> media) {
        this.media = media;
    }
}

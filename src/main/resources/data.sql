-- Insert Artists
INSERT INTO artist (id, name, genre)
VALUES
    (1, 'The Beatles', 'Rock'),
    (2, 'Michael Jackson', 'Pop'),
    (3, 'Elon Musk', 'Technology'),
    (4, 'David Attenborough', 'Nature');

-- Insert Albums
INSERT INTO album (id, name, release_date)
VALUES
    (1, 'Abbey Road', '1969-09-26'),
    (2, 'Thriller', '1982-11-30'),
    (3, 'Tech Talk Series', '2023-01-01'),
    (4, 'Planet Earth II Series', '2016-11-06');

-- Insert Media with album associations
INSERT INTO media (id, title, media_type, genre, release_date, url, duration, album_id)
VALUES
    (1, 'Tech Talk Episode 1', 'Podcast', 'Technology', '2023-01-01', 'http://example.com/tech-talk-1', '30:00', 3),
    (2, 'Planet Earth II Episode 1', 'Documentary', 'Nature', '2016-11-06', 'http://example.com/planet-earth-2-1', '60:00', 4),
    (3, 'Come Together', 'Song', 'Rock', '1969-09-26', 'http://example.com/come-together', '4:20', 1),
    (4, 'Billie Jean', 'Song', 'Pop', '1982-11-30', 'http://example.com/billie-jean', '4:54', 2);

-- Insert into media_artist link table
INSERT INTO media_artist (media_id, artist_id)
VALUES
    (1, 3),
    (2, 4),
    (3, 1),
    (4, 2);
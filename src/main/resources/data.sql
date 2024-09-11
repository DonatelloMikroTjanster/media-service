-- Insert Genres
INSERT INTO genre (id, name) VALUES
                                 (1, 'Pop'),
                                 (2, 'Rock'),
                                 (3, 'Technology'),
                                 (4, 'Documentary');
-- Insert Artists
INSERT INTO artist (id, name) VALUES
                                  (1, 'The Beatles'),
                                  (2, 'Michael Jackson'),
                                  (3, 'Elon Musk'),
                                  (4, 'David Attenborough'),
                                  (5, 'Paul McCartney'),
                                  (6, 'Quincy Jones');
-- Insert Albums
INSERT INTO album (id, name, release_date)
VALUES
    (1, 'Abbey Road', '1969-09-26'),
    (2, 'Thriller', '1982-11-30'),
    (3, 'Tech Talk Series', '2023-01-01'),
    (4, 'Planet Earth II', '2016-11-06');

-- Insert Media
INSERT INTO media ( title, release_date, url, category, album_id)
VALUES
    ('Come Together', '1969-09-26', 'https://spotify.com/music/come-together', 'MUSIC', 1),
    ('Billie Jean', '1982-11-30', 'https://spotify.com/music/billie-jean', 'MUSIC', 2),
    ('Tech Talk Episode 1', '2023-01-15', 'https://spotify.com/podcasts/tech-talk-1', 'PODCAST', 3),
    ('Planet Earth II Episode 1', '2016-11-06', 'https://netflix.com/videos/planet-earth-ii-1', 'VIDEO', 4);


-- Insert into media_genre link table
INSERT INTO media_genre (media_id, genre_id) VALUES
                                                 (1, 1), -- 'Come Together' is 'Pop'
                                                 (2, 1), -- 'Billie Jean' is 'Pop'
                                                 (3, 3), -- 'Tech Talk Episode 1' is 'Technology'
                                                 (4, 4); -- 'Planet Earth II Episode 1' is 'Documentary'

-- Insert into media_artist link table
INSERT INTO media_artist (media_id, artist_id) VALUES
                                                   (1, 1), -- 'Come Together' by 'The Beatles'
                                                   (1, 5), -- 'Come Together' also by 'Paul McCartney'
                                                   (2, 2), -- 'Billie Jean' by 'Michael Jackson'
                                                   (2, 6), -- 'Billie Jean' also by 'Quincy Jones'
                                                   (3, 3), -- 'Tech Talk Episode 1' by 'Elon Musk'
                                                   (4, 4); -- 'Planet Earth II Episode 1' by 'David Attenborough'


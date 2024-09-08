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
                                  (4, 'David Attenborough');
-- Insert Albums
INSERT INTO album (id, name, release_date)
VALUES
    (1, 'Abbey Road', '1969-09-26'),
    (2, 'Thriller', '1982-11-30'),
    (3, 'Tech Talk Series', '2023-01-01'),
    (4, 'Planet Earth II', '2016-11-06');
-- Insert Media
INSERT INTO media (id, title, release_Date, url, category, album_id)
VALUES
    (1, 'Come Together', '1969-09-26', 'https://spotify.com/music/come-together', 'MUSIC', 1),
    (2, 'Billie Jean', '1982-11-30', 'https://spotify.com/music/billie-jean', 'MUSIC', 2),
    (3, 'Tech Talk Episode 1', '2023-01-15', 'https://spotify.com/podcasts/tech-talk-1', 'PODCAST', 3),
    (4, 'Planet Earth II Episode 1', '2016-11-06', 'https://netflix.com/videos/planet-earth-ii-1', 'VIDEO', 4);
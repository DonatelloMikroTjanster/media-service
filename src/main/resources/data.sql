
-- Insert Genres
INSERT IGNORE INTO genre (id, name)
VALUES
    (1, 'Technology'),
    (2, 'Nature'),
    (3, 'Rock'),
    (4, 'Pop'),
    (5, 'Jazz'),
    (6, 'Classical');



-- Insert media entries with album IDs
INSERT IGNORE INTO media (id, title, media_type, genre_id, release_date, url, duration, album_id)
VALUES
    (1, 'Tech Talk Episode 1', 'Podcast', 1, '2023-01-01', 'http://example.com/tech-talk-1', '00:30:00', 3),
    (2, 'Planet Earth II Episode 1', 'Documentary', 2, '2016-11-06', 'http://example.com/planet-earth-2-1', '01:00:00', 4),
    (3, 'Come Together', 'Song', 3, '1969-09-26', 'http://example.com/come-together', '00:04:20', 1),
    (4, 'Billie Jean', 'Song', 4, '1982-11-30', 'http://example.com/billie-jean', '00:04:54', 2),
    (5, 'So What', 'Song', 5, '1959-08-17', 'http://example.com/so-what', '00:09:22', NULL),
    (6, 'Beethoven Symphony No. 9', 'Song', 6, '1824-05-07', 'http://example.com/beethoven-9', '01:05:00', NULL),
    (7, 'Jazz Vibes Episode 2', 'Podcast', 5, '2022-06-08', 'http://example.com/jazz-vibes-2', '00:40:00', NULL),
    (8, 'The Future of Tech II', 'Podcast', 1, '2023-03-01', 'http://example.com/future-tech-2', '00:35:00', 3),
    (9, 'Nature Wonders', 'Documentary', 2, '2018-01-05', 'http://example.com/nature-wonders', '00:50:00', 4),
    (10, 'Rock Legends Vol 2', 'Music', 3, '1997-08-22', 'http://example.com/rock-legends-2', '00:03:50', NULL),
    (11, 'Pop Classics', 'Music', 4, '2021-09-30', 'http://example.com/pop-classics', '00:03:20', NULL),
    (12, 'Classical Gems', 'Music', 6, '1805-01-01', 'http://example.com/classical-gems', '01:20:00', NULL),
    (13, 'Technology Insights', 'Podcast', 1, '2023-04-05', 'http://example.com/tech-insights', '00:25:00', 3),
    (14, 'The Nature Chronicles', 'Documentary', 2, '2021-07-12', 'http://example.com/nature-chronicles', '00:45:00', 4),
    (15, 'Rock Legends Vol 3', 'Music', 3, '1999-10-10', 'http://example.com/rock-legends-3', '00:04:10', NULL),
    (16, 'Pop Forever', 'Music', 4, '2022-11-18', 'http://example.com/pop-forever', '00:03:30', NULL),
    (17, 'Jazz Beats', 'Podcast', 5, '2022-02-01', 'http://example.com/jazz-beats', '00:38:00', 3),
    (18, 'Classical Elegance', 'Music', 6, '1810-12-20', 'http://example.com/classical-elegance', '01:30:00', NULL),
    (19, 'Tech Innovators', 'Podcast', 1, '2023-05-15', 'http://example.com/tech-innovators', '00:30:00', 3),
    (20, 'Exploring Nature', 'Documentary', 2, '2021-05-20', 'http://example.com/exploring-nature', '00:55:00', 4);




-- Insert into media_artist link table
INSERT IGNORE INTO media_artist (media_id, artist_id)
VALUES
    (1, 3),  -- Tech Talk Episode 1 by Elon Musk
    (2, 4),  -- Planet Earth II Episode 1 by David Attenborough
    (3, 1),  -- Come Together by The Beatles
    (4, 2),  -- Billie Jean by Michael Jackson
    (5, 1),  -- So What by The Beatles (example)
    (6, 2),  -- Beethoven Symphony No. 9 by Michael Jackson (example)
    (7, 3),  -- Jazz Vibes Episode 2 by Elon Musk (example)
    (8, 3),  -- The Future of Tech II by Elon Musk (example)
    (9, 4),  -- Nature Wonders by David Attenborough (example)
    (10, 1), -- Rock Legends Vol 2 by The Beatles (example)
    (11, 2), -- Pop Classics by Michael Jackson (example)
    (12, 1), -- Classical Gems by The Beatles (example)
    (13, 3), -- Technology Insights by Elon Musk (example)
    (14, 4), -- The Nature Chronicles by David Attenborough (example)
    (15, 1), -- Rock Legends Vol 3 by The Beatles (example)
    (16, 2), -- Pop Forever by Michael Jackson (example)
    (17, 3), -- Jazz Beats by Elon Musk (example)
    (18, 1), -- Classical Elegance by The Beatles (example)
    (19, 3), -- Tech Innovators by Elon Musk (example)
    (20, 4); -- Exploring Nature by David Attenborough (example)
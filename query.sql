use libraryservice;
-- Insert Authors
INSERT INTO Author (name) VALUES
  ('Author 1'),
  ('Author 2'),
  ('Author 3'),
  ('Author 4'),
  ('Author 5');

-- Insert Books
INSERT INTO Book (title, author_id) VALUES
  ('Book 1 by Author 1', 1),
  ('Book 2 by Author 1', 1),
  ('Book 1 by Author 2', 2),
  ('Book 2 by Author 2', 2),
  ('Book 1 by Author 3', 3),
  ('Book 2 by Author 3', 3),
  ('Book 3 by Author 3', 3),
  ('Book 1 by Author 4', 4),
  ('Book 2 by Author 4', 4),
  ('Book 3 by Author 4', 4),
  ('Book 4 by Author 4', 4),
  ('Book 1 by Author 5', 5),
  ('Book 2 by Author 5', 5);

-- Insert Readers
INSERT INTO Reader (name) VALUES
  ('Reader 1'),
  ('Reader 2'),
  ('Reader 3'),
  ('Reader 4'),
  ('Reader 5'),
  ('Reader 6'),
  ('Reader 7'),
  ('Reader 8'),
  ('Reader 9');

-- Insert relationships between Books and Readers
-- Book 1 by Author 1
INSERT INTO reader_book (book_id, reader_id) VALUES (1, 1);
INSERT INTO reader_book (book_id, reader_id) VALUES (1, 2);
-- Book 2 by Author 1
INSERT INTO reader_book (book_id, reader_id) VALUES (2, 2);
INSERT INTO reader_book (book_id, reader_id) VALUES (2, 3);
-- Book 1 by Author 2
INSERT INTO reader_book (book_id, reader_id) VALUES (3, 3);
INSERT INTO reader_book (book_id, reader_id) VALUES (3, 4);
-- Book 2 by Author 2
INSERT INTO reader_book (book_id, reader_id) VALUES (4, 4);
INSERT INTO reader_book (book_id, reader_id) VALUES (4, 5);
-- Book 1 by Author 3
INSERT INTO reader_book (book_id, reader_id) VALUES (5, 6);
INSERT INTO reader_book (book_id, reader_id) VALUES (5, 7);
-- Book 2 by Author 3
INSERT INTO reader_book (book_id, reader_id) VALUES (6, 7);
INSERT INTO reader_book (book_id, reader_id) VALUES (6, 8);
-- Book 3 by Author 3
INSERT INTO reader_book (book_id, reader_id) VALUES (7, 8);
INSERT INTO reader_book (book_id, reader_id) VALUES (7, 9);
-- Book 1 by Author 4
INSERT INTO reader_book (book_id, reader_id) VALUES (8, 1);
INSERT INTO reader_book (book_id, reader_id) VALUES (8, 3);
-- Book 2 by Author 4
INSERT INTO reader_book (book_id, reader_id) VALUES (9, 2);
INSERT INTO reader_book (book_id, reader_id) VALUES (9, 4);
-- Book 3 by Author 4
INSERT INTO reader_book (book_id, reader_id) VALUES (10, 5);
INSERT INTO reader_book (book_id, reader_id) VALUES (10, 7);
-- Book 4 by Author 4
INSERT INTO reader_book (book_id, reader_id) VALUES (11, 6);
INSERT INTO reader_book (book_id, reader_id) VALUES (11, 9);
-- Book 1 by Author 5
INSERT INTO reader_book (book_id, reader_id) VALUES (12, 1);
INSERT INTO reader_book (book_id, reader_id) VALUES (12, 2);
-- Book 2 by Author 5
INSERT INTO reader_book (book_id, reader_id) VALUES (13, 3);
INSERT INTO reader_book (book_id, reader_id) VALUES (13, 4);

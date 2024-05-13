CREATE SCHEMA IF NOT EXISTS example_db;

CREATE TABLE IF NOT EXISTS example_db.movie (
  id INT auto_increment,
  genre VARCHAR NOT NULL
)

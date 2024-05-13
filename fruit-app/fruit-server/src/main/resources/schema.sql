CREATE SCHEMA IF NOT EXISTS example_db;

CREATE TABLE IF NOT EXISTS example_db.fruit (
  id INT auto_increment,
  name VARCHAR NOT NULL
)

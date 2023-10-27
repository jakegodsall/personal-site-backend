DROP TABLE IF EXISTS course;

CREATE TABLE course (
    id BIGINT PRIMARY KEY,
    last_modified_date DATETIME NOT NULL,
    created_date DATETIME NOT NULL,
    name VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    url VARCHAR(100) NOT NULL
);
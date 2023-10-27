DROP TABLE IF EXISTS tag;

CREATE TABLE tag (
    id BIGINT PRIMARY KEY,
    last_modified_date DATETIME NOT NULL,
    created_date DATETIME NOT NULL,
    name VARCHAR(100) NOT NULL
);
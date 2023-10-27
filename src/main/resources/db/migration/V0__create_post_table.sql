DROP TABLE IF EXISTS post;

CREATE TABLE post (
    id BIGINT PRIMARY KEY,
    last_modified_date DATETIME NOT NULL,
    created_date DATETIME NOT NULL,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    content MEDIUMTEXT NOT NULL
);
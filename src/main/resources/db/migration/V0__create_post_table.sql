DROP TABLE IF EXISTS post;
CREATE TABLE post (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    last_modified_date TIMESTAMP,
    created_date TIMESTAMP,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    content MEDIUMTEXT NOT NULL
);
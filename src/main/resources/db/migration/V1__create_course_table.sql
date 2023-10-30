DROP TABLE IF EXISTS course;
CREATE TABLE course (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    last_modified_date DATETIME,
    created_date DATETIME,
    name VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    url VARCHAR(100) NOT NULL
);
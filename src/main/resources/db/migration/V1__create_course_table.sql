DROP TABLE IF EXISTS course;

CREATE TABLE course
(
    id                 BIGINT UNIQUE NOT NULL AUTO_INCREMENT,
    last_modified_date DATETIME,
    created_date       DATETIME,
    version            BIGINT        NOT NULL DEFAULT 0,
    name               VARCHAR(100)  NOT NULL,
    author             VARCHAR(100)  NOT NULL,
    url                VARCHAR(100)  NOT NULL,
    PRIMARY KEY (id)
);


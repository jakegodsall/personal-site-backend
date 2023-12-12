DROP TABLE IF EXISTS post;

CREATE TABLE post
(
    id                 BIGINT       NOT NULL UNIQUE AUTO_INCREMENT,
    last_modified_date TIMESTAMP,
    created_date       TIMESTAMP,
    version            BIGINT       NOT NULL DEFAULT 0,
    title              VARCHAR(100) NOT NULL,
    description        VARCHAR(100) NOT NULL,
    content            MEDIUMTEXT   NOT NULL,
    PRIMARY KEY (id)
);


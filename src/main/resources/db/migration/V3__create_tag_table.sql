DROP TABLE IF EXISTS tag;

CREATE TABLE tag
(
    id                 BIGINT       NOT NULL UNIQUE AUTO_INCREMENT,
    last_modified_date TIMESTAMP,
    created_date       TIMESTAMP,
    version            BIGINT       NOT NULL DEFAULT 0,
    name               VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS authority;

CREATE TABLE authority
(
    id                 BIGINT       NOT NULL UNIQUE AUTO_INCREMENT,
    created_date       TIMESTAMP,
    last_modified_date TIMESTAMP,
    version            BIGINT       NOT NULL DEFAULT 0,
    permission         VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

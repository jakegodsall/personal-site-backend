DROP TABLE IF EXISTS skill;

CREATE TABLE skill
(
    id                 BIGINT       NOT NULL UNIQUE AUTO_INCREMENT,
    last_modified_date DATETIME     NOT NULL,
    created_date       DATETIME     NOT NULL,
    version            BIGINT       NOT NULL DEFAULT 0,
    name               VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

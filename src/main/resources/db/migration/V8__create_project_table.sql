DROP TABLE IF EXISTS project;

CREATE TABLE project
(
    id                 BIGINT       NOT NULL UNIQUE AUTO_INCREMENT,
    last_modified_date DATETIME     NOT NULL,
    created_date       DATETIME     NOT NULL,
    version            BIGINT       NOT NULL DEFAULT 0,
    name               VARCHAR(100) NOT NULL,
    project_start_date DATE         NOT NULL,
    project_end_date   DATE         NOT NULL,
    github_url         VARCHAR(100),
    live_url           VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE project (
    id BIGINT PRIMARY KEY,
    last_modified_date DATETIME NOT NULL,
    created_date DATETIME NOT NULL,
    name VARCHAR(100) NOT NULL,
    project_start_date DATE NOT NULL,
    project_end_date DATE NOT NULL,
    github_url VARCHAR(100),
    live_url VARCHAR(100)
);
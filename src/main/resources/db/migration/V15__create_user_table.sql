DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    created_date TIMESTAMP,
    last_modified_date TIMESTAMP,
    version BIGINT NOT NULL DEFAULT 0,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    is_account_non_expired BOOLEAN DEFAULT 1,
    is_account_non_locked BOOLEAN DEFAULT 1,
    is_credentials_non_expired BOOLEAN DEFAULT 1,
    is_enabled BOOLEAN DEFAULT 1,
    PRIMARY KEY (id)
);
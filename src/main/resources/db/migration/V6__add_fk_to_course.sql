ALTER TABLE course
    ADD COLUMN post_id BIGINT NOT NULL;


ALTER TABLE course
    ADD FOREIGN KEY (post_id) REFERENCES post (id);

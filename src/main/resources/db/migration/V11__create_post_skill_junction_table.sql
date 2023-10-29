CREATE TABLE post_skill (
    post_id BIGINT,
    skill_id BIGINT,
    PRIMARY KEY (post_id, skill_id),
    FOREIGN KEY (post_id) REFERENCES post(id),
    FOREIGN KEY (skill_id) REFERENCES skill(id)
);
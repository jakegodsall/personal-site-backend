CREATE TABLE project_skill (
    project_id BIGINT,
    skill_id BIGINT,
    PRIMARY KEY (project_id, skill_id),
    FOREIGN KEY (project_id) REFERENCES project(id),
    FOREIGN KEY (skill_id) REFERENCES skill(id)
);

CREATE TABLE project_tag (
    project_id BIGINT,
    tag_id BIGINT,
    PRIMARY KEY (project_id, tag_id),
    FOREIGN KEY (project_id) REFERENCES project(id),
    FOREIGN KEY (tag_id) REFERENCES tag(id)
);

CREATE TABLE project_post (
    project_id BIGINT,
    post_id BIGINT,
    PRIMARY KEY (project_id, post_id),
    FOREIGN KEY (project_id) REFERENCES project(id),
    FOREIGN KEY (post_id) REFERENCES post(id)
);
DROP TABLE IF EXISTS course_tag;

CREATE TABLE course_tag
(
    course_id BIGINT NOT NULL,
    tag_id    BIGINT NOT NULL,
    PRIMARY KEY (course_id, tag_id),
    FOREIGN KEY (course_id) REFERENCES course (id),
    FOREIGN KEY (tag_id) REFERENCES tag (id)
);

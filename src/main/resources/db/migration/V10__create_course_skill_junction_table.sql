CREATE TABLE course_skill (
    course_id BIGINT,
    skill_id BIGINT,
    PRIMARY KEY (course_id, skill_id),
    FOREIGN KEY (course_id) REFERENCES course(id),
    FOREIGN KEY (skill_id) REFERENCES skill(id)
);
package com.jakegodsall.personalsite.bootstrap;

import com.jakegodsall.personalsite.payload.CourseDto;
import com.jakegodsall.personalsite.payload.PostDto;
import com.jakegodsall.personalsite.payload.SkillDto;
import com.jakegodsall.personalsite.payload.TagDto;
import com.jakegodsall.personalsite.service.CourseService;
import com.jakegodsall.personalsite.service.PostService;
import com.jakegodsall.personalsite.service.SkillService;
import com.jakegodsall.personalsite.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.ArrayList;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final TagService tagService;
    private final SkillService skillService;
    private final PostService postService;
    private final CourseService courseService;

    @Override
    public void run(String... args) throws Exception {
        initializeTags();
        initializeSkills();
        initializePosts();
        initializeCourses();
    }

    private void initializeTags() {
        ArrayList<TagDto> tags = new ArrayList<>();
        tags.add(new TagDto("programming"));
        tags.add(new TagDto("quantified self"));
        tags.add(new TagDto("life"));

        for (TagDto tag : tags) {
            tagService.createTag(tag);
        }
    }

    private void initializeSkills() {
        ArrayList<SkillDto> skills = new ArrayList<>();
        skills.add(new SkillDto("java"));
        skills.add(new SkillDto("spring boot"));
        skills.add(new SkillDto("mysql"));

        for (SkillDto skill : skills) {
            skillService.createSkill(skill);
        }
    }

    private void initializePosts() {
        ArrayList<PostDto> posts = new ArrayList<>();
        posts.add(new PostDto("Building a RESTful API with Spring Boot",
                "How to build REST APIs using Spring Boot and Java",
                "Lorem ipsum..."));
        posts.add(new PostDto("Linear Algebra for Dummies",
                "All the linear algebra you need to know to work with matrices in Python",
                "Lorem ipsum..."));
        posts.add(new PostDto("How to use Reppd",
                "An introduction to using Reppd to supercharge your life.",
                "Lorem ipsum..."));

        for (PostDto post : posts) {
            postService.createPost(post);
        }
    }

    private void initializeCourses() {
        ArrayList<CourseDto> courses = new ArrayList<>();
        courses.add(new CourseDto("Web Development with React", "John Smith", "https://course1.com"));
        courses.add(new CourseDto("Machine Learning for Beginners", "Alice Johnson", "https://course2.com"));
        courses.add(new CourseDto("Python Programming Masterclass", "David Miller", "https://course3.com"));
        courses.add(new CourseDto("Game Development in Unity", "Sarah Davis", "https://course4.com"));
        courses.add(new CourseDto("Blockchain and Cryptocurrency Fundamentals", "Michael Anderson", "https://course5.com"));
        courses.add(new CourseDto("Cybersecurity: Ethical Hacking and Penetration Testing", "Emily Roberts", "https://course6.com"));
        courses.add(new CourseDto("Data Science with R: Analyzing Big Data", "Chris Baker", "https://course7.com"));
        courses.add(new CourseDto("iOS App Development with Swift", "Emma Wilson", "https://course8.com"));
        courses.add(new CourseDto("Full-Stack Web Development with Node.js", "Daniel Garcia", "https://course9.com"));
        courses.add(new CourseDto("Artificial Intelligence: From Basics to Advanced", "Sophia Lee", "https://course10.com"));

        for (CourseDto course : courses) {
            courseService.createCourse(course);
        }
    }
}

package com.jakegodsall.personalsite.utils;

import com.jakegodsall.personalsite.payload.TagDto;
import com.jakegodsall.personalsite.service.TagService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final TagService tagService;

    public DataInitializer(TagService tagService) {
        this.tagService = tagService;
    }

    @Override
    public void run(String... args) throws Exception {

        TagDto[] tags = {
                new TagDto("machine-learning"),
                new TagDto("programming-languages"),
                new TagDto("Java")
        };

        for (TagDto tag : tags) {
            tagService.createTag(tag);
        }

    }
}

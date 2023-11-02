package com.jakegodsall.personalsite.controller;

import com.jakegodsall.personalsite.service.SkillService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SkillController.class)
class SkillControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private SkillService skillService;

    @Test
    void testGetAllSkills() throws Exception {
        mockMvc.perform(get("/api/v1/skills")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testCreateSkill() throws Exception {

    }

    @Test
    void testGetSkillById() throws Exception {
        mockMvc.perform(get("/api/v1/skills/1")
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testUpdateSkillById() throws Exception {

    }

    @Test
    void deleteSkillById() throws Exception {

    }

}
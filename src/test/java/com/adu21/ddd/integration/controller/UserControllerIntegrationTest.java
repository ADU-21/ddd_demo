package com.adu21.ddd.integration.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.adu21.ddd.controller.rest.UserController;
import com.adu21.ddd.integration.BaseIntegrationTest;

public class UserControllerIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private UserController userController;

    private String intputJson;

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(userController).build();
    }

    @Test
    public void registerSuccess() throws Exception {
        intputJson = "{\"username\":\"N95\",\"password\":\"WP\"}";
        mockMvc.perform(post("/api/user")
                .contentType(APPLICATION_JSON).content(intputJson))
                .andExpect(status().isCreated());
    }
}

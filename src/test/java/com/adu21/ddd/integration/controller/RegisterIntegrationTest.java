package com.adu21.ddd.integration.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.adu21.ddd.controller.rest.UserController;
import com.adu21.ddd.integration.BaseIntegrationTest;
import com.adu21.ddd.model.Policy;
import com.adu21.ddd.model.User;
import com.adu21.ddd.repository.PolicyRepository;
import com.adu21.ddd.repository.UserRepository;

public class RegisterIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PolicyRepository policyRepository;

    private String intputJson;

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(userController).build();
        userRepository.save(new User("uuid", null,"email"));
        policyRepository.save(new Policy("123","uuid"));
    }

    @Test
    public void registerSuccessWithEmailAndPolicyNumber() throws Exception {
        intputJson = "{\"email\":\"email\",\"policyNumber\":\"123\"}";
        mockMvc.perform(post("/api/user")
                .contentType(APPLICATION_JSON).content(intputJson))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.uuid").isString());
    }
}

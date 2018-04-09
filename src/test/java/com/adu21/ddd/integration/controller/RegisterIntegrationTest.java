package com.adu21.ddd.integration.controller;

import com.adu21.ddd.controller.rest.UserController;
import com.adu21.ddd.integration.BaseIntegrationTest;
import com.adu21.ddd.model.HomePolicy;
import com.adu21.ddd.model.User;
import com.adu21.ddd.repository.HomePolicyRepository;
import com.adu21.ddd.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.String.format;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class RegisterIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HomePolicyRepository homePolicyRepository;

    private String inputJson;

    @Before
    public void setUp() {
        mockMvc = standaloneSetup(userController).build();
        userRepository.save(new User("user", "password", "email"));
        userRepository.save(new User("userWaitingForResetPassword", null, "emailWaitingForResetPassword"));
        HomePolicy homePolicy = new HomePolicy();
        homePolicy.setPolicyNumber(3);
        homePolicy.setOwnerEmail("mailUnregistered");
        homePolicyRepository.save(homePolicy);
    }

    @Test
    public void registerSuccess() throws Exception {
        inputJson = "{\"ownerEmail\":\"mailUnregistered\",\"policyNumber\":\"3\"}";
        mockMvc.perform(post("/api/user")
                .contentType(APPLICATION_JSON).content(inputJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.uuid").isString());
    }

    @Test
    public void resetPasswordSuccess() throws Exception {
        String uuid = "userWaitingForResetPassword";
        inputJson = "{\"password\":\"xxx\"}";
        mockMvc.perform(put(format("/api/user/password?uuid=%s", uuid))
                .contentType(APPLICATION_JSON).content(inputJson))
                .andExpect(status().isAccepted());
    }

    @Test
    public void userLoginSuccess() throws Exception {
        inputJson = "{\"email\":\"email\",\"password\":\"password\"}";
        mockMvc.perform(post("/api/user/login")
                .contentType(APPLICATION_JSON).content(inputJson))
                .andExpect(status().isFound())
                .andExpect(jsonPath("$.uuid").value("user"));
    }
}

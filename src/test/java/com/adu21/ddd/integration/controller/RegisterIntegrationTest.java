//package com.adu21.ddd.integration.controller;
//
//import com.adu21.ddd.policy.domain.model.PolicyEntity;
//import com.adu21.ddd.user.UserController;
//import com.adu21.ddd.integration.BaseIntegrationTest;
//import com.adu21.ddd.user.domain.model.User;
//import com.adu21.ddd.policy.repository.PolicyRepository;
//import com.adu21.ddd.user.UserRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static java.lang.String.format;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
//public class RegisterIntegrationTest extends BaseIntegrationTest {
//
//    @Autowired
//    private UserController userController;
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private PolicyRepository policyRepository;
//
//    private String inputJson;
//
//    @Before
//    public void setUp() {
//        mockMvc = standaloneSetup(userController).build();
//        userRepository.save(new User("user", "password", "email"));
//        userRepository.save(new User("userWaitingForResetPassword", null, "emailWaitingForResetPassword"));
//        policyRepository.save(new PolicyEntity("policyWaitingForRegistered","emailWaitingForRegistered"));
//    }
//
//    @Test
//    public void registerSuccess() throws Exception {
//        inputJson = "{\"ownerEmail\":\"emailWaitingForRegistered\",\"policyNumber\":\"policyWaitingForRegistered\"}";
//        mockMvc.perform(post("/api/user/register")
//                .contentType(APPLICATION_JSON).content(inputJson))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    public void resetPasswordSuccess() throws Exception {
//        String uuid = "userWaitingForResetPassword";
//        inputJson = "{\"password\":\"xxx\"}";
//        mockMvc.perform(put(format("/api/user/password?uuid=%s", uuid))
//                .contentType(APPLICATION_JSON).content(inputJson))
//                .andExpect(status().isAccepted());
//    }
//
//    @Test
//    public void userLoginSuccess() throws Exception {
//        inputJson = "{\"email\":\"email\",\"password\":\"password\"}";
//        mockMvc.perform(post("/api/user/login")
//                .contentType(APPLICATION_JSON).content(inputJson))
//                .andExpect(status().isFound());
//    }
//}

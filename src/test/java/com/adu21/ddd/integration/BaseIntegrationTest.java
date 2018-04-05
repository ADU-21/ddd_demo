package com.adu21.ddd.integration;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.adu21.ddd.DddApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = DddApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Transactional
public abstract class BaseIntegrationTest {
    protected MockMvc mockMvc;
}

package com.balu.learn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.balu.LearnApplication;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootConfiguration(classes = LearnApplication.class)   // 2
//@ContextConfiguration
//@WebAppConfiguration  spring 1.3

//spring 1.4 orward 
@SpringBootTest(classes = LearnApplication.class,webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class RestControllerTest {
    
    @Autowired
    private WebApplicationContext ctx;
	@Autowired
	    private TestRestTemplate restTemplate;
	 
    private MockMvc mockMvc;
 
    @Before 
    public void setUp() 
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }
    
    @Test 
    public void helloWorld() throws Exception 
    {
    		mockMvc.perform(
                MockMvcRequestBuilders.get("/greeting").accept(MediaType.TEXT_PLAIN))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
                //.andExpect(MockMvcResultMatchers.content().string("Hello, World!"));
    }
   
}

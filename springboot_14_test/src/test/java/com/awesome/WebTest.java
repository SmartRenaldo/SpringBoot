package com.awesome;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// start mock mvc
@AutoConfigureMockMvc
public class WebTest {
    @Test
    void testWeb(@Autowired MockMvc mvc) throws Exception {
        // create virtual request
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        mvc.perform(builder);
    }

    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception {
        // create virtual request
        // MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/bookss");
        ResultActions perform = mvc.perform(builder);

        // set expectation value, and compare it with actual value
        // define the expectation value
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // It is expected that this call will be successful, status code 200
        ResultMatcher ok = status.isOk();

        perform.andExpect(ok);
    }

    @Test
    void testBody(@Autowired MockMvc mvc) throws Exception {
        // create virtual request
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions perform = mvc.perform(builder);

        // set expectation value, and compare it with actual value
        // define the expectation value
        ContentResultMatchers content = MockMvcResultMatchers.content();
        // It is expected that this call content is "getById running..."
        //ResultMatcher string = content.string("getById running...");
        ResultMatcher string = content.string("getById running.,..");
        perform.andExpect(string);
    }

    @Test
    void testJSON(@Autowired MockMvc mvc) throws Exception {
        // create virtual request
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/books");
        ResultActions perform = mvc.perform(builder);

        // set expectation value, and compare it with actual value
        // define the expectation value
        ContentResultMatchers content = MockMvcResultMatchers.content();
        // It is expected that this call content is "getById running..."
        //ResultMatcher string = content.string("getById running...");
        //ResultMatcher json = content.json("{\"id\":1,\"name\":\"Sheldon\"}");
        ResultMatcher json = content.json("{\"id\":1,\"name\":\"Sheldonn\"}");
        perform.andExpect(json);
    }

    @Test
    void testContentType(@Autowired MockMvc mvc) throws Exception {
        // create virtual request
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/books");
        ResultActions perform = mvc.perform(builder);

        // set expectation value, and compare it with actual value
        // define the expectation value
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        //ResultMatcher string = header.string("Content-Type", "application/json");
        ResultMatcher string = header.string("Content-Type", "application/jsson");
        perform.andExpect(string);
    }

    @Test
    void testGetBuId(@Autowired MockMvc mvc) throws Exception {
        // create virtual request
        // MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/books");
        ResultActions perform = mvc.perform(builder);

        // set expectation value, and compare it with actual value
        // define the expectation value
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // It is expected that this call will be successful, status code 200
        ResultMatcher ok = status.isOk();

        perform.andExpect(ok);

        ContentResultMatchers content = MockMvcResultMatchers.content();
        // It is expected that this call content is "getById running..."
        //ResultMatcher string = content.string("getById running...");
        //ResultMatcher json = content.json("{\"id\":1,\"name\":\"Sheldon\"}");
        ResultMatcher json = content.json("{\"id\":1,\"name\":\"Sheldon\"}");
        perform.andExpect(json);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        //ResultMatcher string = header.string("Content-Type", "application/json");
        ResultMatcher string = header.string("Content-Type", "application/json");
        perform.andExpect(string);
    }
}

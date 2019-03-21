package com.yusufcancelik.demo;

import com.yusufcancelik.demo.Controllers.HR.HRJobListingController;
import com.yusufcancelik.demo.Services.Concrete.JobService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JobListingUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private JobService jobService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
     public void ifJobListingCreatedByUnauthenticatedUserShouldReturnLoginURL() throws Exception {
         RequestBuilder request = post("/hr/job/create")
                 .param("title", "testTitle")
                 .param("description", "testDescription")
                 .param("numberofHire","12")
                 .param("lastApplicationDate","21-3-2019")
                 .with(csrf());
         mockMvc
                 .perform(request)
                 .andDo(MockMvcResultHandlers.print())
                 .andExpect(redirectedUrl("http://localhost/login"));
     }

    @Test
    @WithMockUser(username = "yusufcancelik@hotmail.com", password = "zxczxc", authorities = "ROLE_HR")
    public void ifJobListingCreatedByUnauthenticatedUserShouldReturnJoblistURL() throws Exception {
        RequestBuilder request = post("/hr/job/create")
                .param("description", "testDescription")
                .param("numberofHire","12")
                .param("lastApplicationDate","21-3-2019")
                .with(csrf());
        mockMvc
                .perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(redirectedUrl("/joblist"));
    }

}

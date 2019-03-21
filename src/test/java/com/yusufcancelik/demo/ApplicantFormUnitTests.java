package com.yusufcancelik.demo;

import com.yusufcancelik.demo.Controllers.ApplicantController;
import com.yusufcancelik.demo.DTO.ApplicantDTO;
import com.yusufcancelik.demo.Services.Concrete.ApplicantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ApplicantController.class, secure = false)
public class ApplicantFormUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplicantService applicantService;

    @Test
    public void givenEmptyApplicantDTOShouldReturnErrors() throws Exception {
        mockMvc.perform(post("/applicant/form")
                .content("{\"name\":,\"email\":,\"Phone\":,\"address\":,\"thoughts\":,\"file\":,\"jobId\":}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}

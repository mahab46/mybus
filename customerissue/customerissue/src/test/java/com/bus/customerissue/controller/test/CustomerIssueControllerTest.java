package com.bus.customerissue.controller.test;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.bus.customerissue.controller.CustomerIssueController;
import com.bus.customerissue.model.CustomerIssueModel;
import com.bus.customerissue.service.CustomerIssueService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CustomerIssueController.class)
public class CustomerIssueControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CustomerIssueService customerIssueService;

    @InjectMocks
    private CustomerIssueController customerIssueController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddIssue() throws Exception {
        // Create a sample CustomerIssueModel
        CustomerIssueModel issue = new CustomerIssueModel("Issue1", "User1", "Open", "Pending");

        // Mock the service method
        doNothing().when(customerIssueService).addissue(any(CustomerIssueModel.class));

        // Perform the POST request
        mockMvc.perform(post("/addIssue")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(issue)))
                .andExpect(status().isOk())
                .andExpect(content().string("Apologies for hearing the Issue. Our Admin will look into these"));

        // Verify that the service method was called
        verify(customerIssueService).addissue(any(CustomerIssueModel.class));
    }
}


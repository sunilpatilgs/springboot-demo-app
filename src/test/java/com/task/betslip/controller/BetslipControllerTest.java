package com.task.betslip.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.betslip.models.CreateBetslipRequest;
import com.task.betslip.service.BetslipService;


/**
 * @author sunil
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BetslipController.class)
@AutoConfigureMockMvc
public class BetslipControllerTest {
	
	
	@MockBean
	private BetslipService betslipService;
	
	@Autowired
    private MockMvc mockMvc;
	
	@Before
	public void setUp() {
	}
	
	@Test
	public void createBetslipValidationTest() throws Exception {
		CreateBetslipRequest createBetslipRequest = new CreateBetslipRequest();
    	createBetslipRequest.setCustomerId(1L);
    	//createBetslipRequest.setTeamAFactor(10.0);
    	createBetslipRequest.setTeamBFactor(20.0);
    	createBetslipRequest.setTieFactor(5.0);
    	
    	mockMvc.perform(post("/api/v1/betslip/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(createBetslipRequest)))
                .andExpect(status().is4xxClientError());

	}
	
	@Test
	public void createBetslipTest() throws Exception {
		CreateBetslipRequest createBetslipRequest = new CreateBetslipRequest();
    	createBetslipRequest.setCustomerId(1L);
    	createBetslipRequest.setTeamAFactor(10.0);
    	createBetslipRequest.setTeamBFactor(20.0);
    	createBetslipRequest.setTieFactor(5.0);
    	
    	mockMvc.perform(post("/api/v1/betslip/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(createBetslipRequest)))
                .andExpect(status().isCreated());

	}
	
	@Test
	public void updateBetslipValidationTest() throws Exception {
		CreateBetslipRequest createBetslipRequest = new CreateBetslipRequest();
    	//createBetslipRequest.setCustomerId(1L);
    	createBetslipRequest.setTeamAFactor(10.0);
    	createBetslipRequest.setTeamBFactor(20.0);
    	createBetslipRequest.setTieFactor(5.0);
    	
    	mockMvc.perform(put("/api/v1/betslip/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(createBetslipRequest)))
                .andExpect(status().is4xxClientError());

	}
	
	@Test
	public void updateBetslipTest() throws Exception {
		
		CreateBetslipRequest createBetslipRequest = new CreateBetslipRequest();
    	createBetslipRequest.setCustomerId(1L);
    	createBetslipRequest.setTeamAFactor(10.0);
    	createBetslipRequest.setTeamBFactor(20.0);
    	createBetslipRequest.setTieFactor(5.0);
    	
    	mockMvc.perform(post("/api/v1/betslip/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(createBetslipRequest)))
                .andExpect(status().isCreated());
    	
    	
    	createBetslipRequest.setCustomerId(1L);
    	createBetslipRequest.setTeamAFactor(12.0);
    	createBetslipRequest.setTeamBFactor(25.0);
    	createBetslipRequest.setTieFactor(60.0);
    	
    	mockMvc.perform(put("/api/v1/betslip/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(createBetslipRequest)))
                .andExpect(status().isOk());

	}
	
	@Test
	public void getBetslipDetailsTest() throws Exception {
		mockMvc.perform(get("/api/v1/betslip/1")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void deleteBetslipTest() throws Exception {
		mockMvc.perform(delete("/api/v1/betslip/1")).andDo(print()).andExpect(status().isOk());
	}

}

package com.inventory.inventorydocker;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inventory.controller.TestController;
import com.inventory.service.AdminService;

public class TestControllerTest {
	
	@Mock
	AdminService adminService;
	
	TestController adminController;
	private MockMvc mockMvc;
	
	@LocalServerPort
    private int port;

	@Before
    public void setUp() throws Exception
    {
        this.adminController = new TestController();
        this.mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }
	
	@Test
    public void getDataReturn200WhenHitURL() throws Exception
    {
        mockMvc.perform(get("/hello"))
           .andExpect(status().isOk());
    }
	@Test
    public void getDataReturn200WhenHittestURL() throws Exception
    {
        mockMvc.perform(get("/test"))
           .andExpect(status().isOk());
    }
}

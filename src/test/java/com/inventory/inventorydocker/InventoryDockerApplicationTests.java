package com.inventory.inventorydocker;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.inventory.controller.AdminController;
import com.inventory.service.AdminService;

@RunWith(MockitoJUnitRunner.class)

public class InventoryDockerApplicationTests {
	
	@Mock
	AdminService adminService;
	
	AdminController adminController;
	private MockMvc mockMvc;
	
	@LocalServerPort
    private int port;

	@Before
    public void setUp() throws Exception
    {
        this.adminController = new AdminController();
        this.mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }
	
	@Test
    public void getDataReturn400WhenHitWrongURL() throws Exception
    {
		assertFalse(false);
        //when(adminService.getInventory("today")).thenReturn("");

        mockMvc.perform(get("/hello"))
           .andExpect(status().isNotFound());
    }
	@Test
    public void getDataReturn200WhenHit() throws Exception
    {
		assertFalse(false);
        //when(adminService.getInventory("today")).thenReturn("");

        mockMvc.perform(get("/getJsonResponce"))
           .andExpect(status().isOk());
    }
}

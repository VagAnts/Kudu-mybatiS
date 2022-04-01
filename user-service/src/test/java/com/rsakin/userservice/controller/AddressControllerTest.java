
package com.rsakin.userservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rsakin.userservice.dto.UserDTO;
import com.rsakin.userservice.entity.Address;
import com.rsakin.userservice.entity.User;
import com.rsakin.userservice.exception.AddressNotFoundException;
import com.rsakin.userservice.service.AddressService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressService addressService;

    // constants
    public static final int TEST_ADDRESS_COUNT = 8;

    @Test
    void should_getAll() throws Exception {
        // stubbing
        List<Address> sampleAddressList = getSampleAddressList(TEST_ADDRESS_COUNT);

        // when
        Mockito.when(addressService.getAll()).thenReturn(sampleAddressList);

        // then
        String url = "/api/address/all";
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                // check the response address size
                .andExpect(jsonPath("$", hasSize(TEST_ADDRESS_COUNT)));
    }

    @Test
    void should_getOneById() throws Exception {
        // stub
        Address stubAddress = getSampleAddressList(1).get(0);

        // when
        Mockito.when(addressService.getOne(any(Integer.class)))
                .thenReturn(stubAddress);

        // then
        String url = "/api/address/{id}";
        mockMvc.perform(get(url, stubAddress.getId()))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.city", is(stubAddress.getCity())))
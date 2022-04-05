
package com.rsakin.userservice.service;

import com.rsakin.userservice.entity.Address;
import com.rsakin.userservice.exception.AddressNotFoundException;
import com.rsakin.userservice.repository.AddressRepository;
import com.rsakin.userservice.service.impl.AddressServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class AddressServiceTest {

    @InjectMocks
    AddressServiceImpl addressService;

    @Mock
    AddressRepository addressRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_getAllAddresses() {

        // stub
        List<Address> addressList = getSampleAddressList(5);

        // when
        Mockito.when(addressRepository.findAll())
                .thenReturn(addressList);

        // then
        List<Address> addresses = addressService.getAll();

        assertEquals(5, addresses.size());
        assertNotNull(addresses.get(0));
        assertEquals("City-0", addresses.get(0).getCity());
        assertEquals(new Integer(1), addresses.get(0).getBuildingNo());

        verify(addressRepository, times(1)).findAll();

    }

    @Test
    public void should_createAddress() {
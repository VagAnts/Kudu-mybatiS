
package com.rsakin.userservice.service;

import com.rsakin.userservice.dto.UserDTO;
import com.rsakin.userservice.entity.User;
import com.rsakin.userservice.exception.UserNotFoundException;
import com.rsakin.userservice.repository.UserRepository;
import com.rsakin.userservice.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    AddressService addressService;

    UserServiceImpl userService;


    @Before
    public void setup() {
        ModelMapper modelMapper = new ModelMapper();
        userService = new UserServiceImpl(userRepository, addressService);
        userService.setModelMapper(modelMapper);
    }

    @Test
    public void should_getAllUsers() {
        // stub
        List<User> sampleUserList = getSampleUserList(8);

        // when
        // Mockito.when(modelMapper.map(org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.any())).thenReturn(temp);
        Mockito.when(userRepository.findAll()).thenReturn(sampleUserList);

        // then
        List<UserDTO> userDTOList = userService.getAll();

        assertEquals(8, userDTOList.size());
        assertEquals("name0", userDTOList.get(0).getName());
        assertEquals("lastname0", userDTOList.get(0).getLastname());

    }

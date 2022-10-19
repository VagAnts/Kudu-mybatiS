
package com.rsakin.getaxi.proxy.controller;

import com.rsakin.getaxi.proxy.dao.model.User;
import com.rsakin.getaxi.proxy.dao.model.UserDTO;
import com.rsakin.getaxi.proxy.model.JwtRequest;
import com.rsakin.getaxi.proxy.model.JwtResponse;
import com.rsakin.getaxi.proxy.service.JwtUserDetailsService;
import com.rsakin.getaxi.proxy.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@Slf4j
@RefreshScope
@CrossOrigin(origins = "*")
public class GatewayController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Value("${sample.variable:Sample variable could not be retrieved}")
    private String sampleVar;

    @Value("${sample.common:Common variable could not be retrieved}")
    private String commonVar;

    @GetMapping("/hello")
    public ResponseEntity<String> hi() {
        return new ResponseEntity<>("Profile Variable : " + sampleVar + " ---- "
                + " common var : " + commonVar, HttpStatus.OK);
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody @Valid JwtRequest authenticationRequest) {

        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(authenticationRequest.getUsername());
package com.rsakin.getaxi.proxy.service;

import com.rsakin.getaxi.proxy.dao.feign.UserServiceFeign;
import com.rsakin.getaxi.proxy.dao.model.User;
import com.rsakin.getaxi.proxy.dao.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import or
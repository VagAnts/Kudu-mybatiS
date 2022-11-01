package com.rsakin.getaxi.proxy.filter;

import com.rsakin.getaxi.proxy.service.JwtUserDetailsService;
import com.rsakin.getaxi.proxy.util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org
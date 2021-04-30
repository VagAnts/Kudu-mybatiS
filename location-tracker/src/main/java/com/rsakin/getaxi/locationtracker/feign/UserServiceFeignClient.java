package com.rsakin.getaxi.locationtracker.feign;


import com.rsakin.getaxi.locationtracker.model.Location;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import javax.naming.ServiceUnavailableException;
import java.util.List;

@FeignClient(value = "user-service-feign", url = "localhost:9001/api/user", fallback = UserSe
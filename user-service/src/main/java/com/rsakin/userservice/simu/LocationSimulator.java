package com.rsakin.userservice.simu;

import com.rsakin.userservice.entity.User;
import com.rsakin.userservice.model.Location;
import com.rsakin.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationSimulator {

    private final UserService userService;
    private Map<Integer, Location> driversLocationCache = new ConcurrentHashMap<>();

    // Turkey latitude-longitude coordinates
    private static final double MIN_LAT = 36;
    private static final double MAX_LAT = 42;
    private static 
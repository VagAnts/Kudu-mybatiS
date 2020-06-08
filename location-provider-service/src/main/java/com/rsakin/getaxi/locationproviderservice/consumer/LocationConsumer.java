package com.rsakin.getaxi.locationproviderservice.consumer;

import com.rsakin.getaxi.locationproviderservice.exception.LocationNotFoundException;
import com.rsakin.getaxi.locationproviderservice.model.Location;
import com.rsakin.getaxi.locationproviderservice.service.LocationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocationConsumer {

    private final LocationService locationService;

    @KafkaListener(topics = "t_locations", containerFactory = "locationKafkaListenerFactory", groupId = "group_json")
    public void consumeLocations(List<Map<String, Object>> locationMap) {
        log.info("Consumed Location Map : {}", locationMap);

        locationMap.forEach(stringObjectMap -> {
            Integer userId = (Integer) stringObjectMap.get("userId");
            Integer latitude = (Integer) stringObjectMap.get("latitude");
            Integer longitude = (Integer) stringObjectMap.get("longitude");
     
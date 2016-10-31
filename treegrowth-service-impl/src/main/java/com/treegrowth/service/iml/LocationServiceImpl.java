package com.treegrowth.service.iml;

import com.treegrowth.service.LocationService;
import com.treegrowth.service.bo.location.LocationAnalysisResponse;
import com.treegrowth.service.bo.location.LocationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.client.RestTemplate;

@EnableConfigurationProperties(value = LocationConfiguration.class)
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationConfiguration locationConfiguration;

    public LocationAnalysisResponse analysisAddress(String ip) {
        return new LocationAnalysisResponse(this.getRestTemplate().getForObject(locationConfiguration.getIpLocation(), String.class, ip));
    }

    private RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

package com.treegrowth.service.bo.location;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "tree.location")
public class LocationConfiguration {

    @NotNull
    private String baseUrl;

    @NotNull
    private String key;

    @NotNull
    private String ipLocation;

    @NotNull
    private String geoLocation;

    private double nearbyDistance;

    private long nearbyLimit;

    private long recentLimit;

    private double rateDistance;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIpLocation() {
        return ipLocation;
    }

    public void setIpLocation(String ipLocation) {
        this.ipLocation = ipLocation;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public double getNearbyDistance() {
        return nearbyDistance;
    }

    public void setNearbyDistance(double nearbyDistance) {
        this.nearbyDistance = nearbyDistance;
    }

    public long getNearbyLimit() {
        return nearbyLimit;
    }

    public void setNearbyLimit(long nearbyLimit) {
        this.nearbyLimit = nearbyLimit;
    }

    public long getRecentLimit() {
        return recentLimit;
    }

    public void setRecentLimit(long recentLimit) {
        this.recentLimit = recentLimit;
    }

    public double getRateDistance() {
        return rateDistance;
    }

    public void setRateDistance(double rateDistance) {
        this.rateDistance = rateDistance;
    }

}

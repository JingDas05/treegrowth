package com.treegrowth.service;

import com.treegrowth.service.bo.location.LocationAnalysisResponse;

public interface LocationService {

    LocationAnalysisResponse analysisAddress(String ip);
}

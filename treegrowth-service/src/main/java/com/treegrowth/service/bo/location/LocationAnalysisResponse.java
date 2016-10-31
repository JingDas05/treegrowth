package com.treegrowth.service.bo.location;

import com.treegrowth.common.utils.Json;

import static com.treegrowth.common.utils.Json.readNode;

public class LocationAnalysisResponse {

    private Integer status;
    private String message;
    private String data;

    public LocationAnalysisResponse() {}

    public LocationAnalysisResponse(String responseBody) {
        this.status = Integer.parseInt(readNode(responseBody, "status"));
        this.message = readNode(responseBody, "message");
        this.data = readNode(responseBody, "result");

    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

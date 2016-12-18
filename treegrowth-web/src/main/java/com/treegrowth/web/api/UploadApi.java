package com.treegrowth.web.api;

import com.treegrowth.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("api/upload")
public class UploadApi {

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/token", method = GET)
    String uploadToken(){
        return uploadService.getUploadToken();
    };
}

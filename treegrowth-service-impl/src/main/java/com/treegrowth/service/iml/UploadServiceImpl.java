package com.treegrowth.service.iml;

import com.qiniu.util.Auth;
import com.treegrowth.service.UploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {

    @Value("${qiniu.ak}")
    private String accessKey;
    @Value("${qiniu.sk}")
    private String secretKey;
    @Value("${qiniu.bucket-name}")
    private String bucketName;

    @Override
    public String getUploadToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucketName);
    }
}

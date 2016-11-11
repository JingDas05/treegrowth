package com.treegrowth.service.iml.qiniudemo.upload;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.IOException;

public class UploadDirectDemo {

    //设置好账号的ACCESS_KEY和SECRET_KEY
    private String ACCESS_KEY = "Access_Key";
    private String SECRET_KEY = "Secret_Key";
    //要上传的空间
    private String bucketname = "Bucket_Name";
    //上传到七牛后保存的文件名
    private String key = "my-java.png";
    //上传文件的路径
    private String FilePath = "/.../...";

    //密钥配置
    private Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    private UploadManager uploadManager = new UploadManager();

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(){
        return auth.uploadToken(bucketname);
    }

    public void upload() throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    public static void main(String args[]) throws IOException{
        new UploadDirectDemo().upload();
    }

}

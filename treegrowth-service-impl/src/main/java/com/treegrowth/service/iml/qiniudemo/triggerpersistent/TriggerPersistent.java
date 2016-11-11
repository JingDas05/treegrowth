package com.treegrowth.service.iml.qiniudemo.triggerpersistent;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.processing.OperationManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

public class TriggerPersistent {

    public static void main(String[] args) throws QiniuException {
        //设置账号的AK,SK
        String ACCESS_KEY = "Access_Key";
        String SECRET_KEY = "Secret_Key";
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //新建一个OperationManager对象
        OperationManager operater = new OperationManager(auth);
        //设置要转码的空间和key，并且这个key在你空间中存在
        String bucket = "Bucket_Name";
        String key = "Bucket_key";
        //设置转码操作参数
        String fops = "avthumb/mp4/s/640x360/vb/1.25m";
        //设置转码的队列
        String pipeline = "yourpipelinename";
        //可以对转码后的文件使用saveas参数自定义命名，当然也可以不指定，文件会默认命名并保存在当前空间
        String urlbase64 = UrlSafeBase64.encodeToString("目标Bucket_Name:自定义文件key");
        String pfops = fops + "|saveas/" + urlbase64;
        //设置pipeline参数
        StringMap params = new StringMap().putWhen("force", 1, true).putNotEmpty("pipeline", pipeline);
        try {
            String persistid = operater.pfop(bucket, key, pfops, params);
            //打印返回的persistid
            System.out.println(persistid);
        } catch (QiniuException e) {
            //捕获异常信息
            Response r = e.response;
            // 请求失败时简单状态信息
            System.out.println(r.toString());
            try {
                // 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }
}
/**
 * 上面的 Demo 只是针对视频转码功能，如果您需要使用比如音视频切片、视频截图、视频拼接等功能只需要修改上面 fops 后面的参数即可，
 * 如：$fops = vframe/jpg/offset/1/w/480/h/360/rotate/90 就表示视频截图了
 * 通过上面的代码我们就可以触发将存储在空间中的视频从 mp4 格式转换成 m3u8 格式，
 * 并设置分辨率和视频码率。 但这个只是将转码这个耗时的操作提交到队列中，要想知道转码操作现在的状态，
 * 需要根据返回的 persitentId 进行查询。如果您不方便持续轮询每个异步处理的进度和状态，七牛可以异步处理完成后通知您们的业务服务器。
 */

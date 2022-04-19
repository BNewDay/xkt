package com.example.system_master_springboot_maven.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.system_master_springboot_maven.pojo.DataStreams;
import com.example.system_master_springboot_maven.pojo.Iot10086;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
/*
* 执行OneNet连接
* 上传+获取数据
* */
public class OneNetUtil {
    private static final String apiUrl = "http://api.heclouds.com/devices/";

    //获取OneNet设备所有数据流
    public static JSONObject getDataStreams(Iot10086 iot, String dataStream) {
        HttpClient client = HttpClientBuilder.create().build();
        String url_get = apiUrl + iot.getDevice_id() + "/datastreams";
        if (dataStream != null) {
            url_get = url_get + "/" + dataStream;
        }
        HttpGet get = new HttpGet(url_get);
        get.addHeader("api-key", iot.getApiKey());
        JSONObject response = null;
        try {
            HttpResponse res = client.execute(get);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

                org.apache.http.HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(entity);
                response = JSONObject.parseObject(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    //设置OneNet设备数据流吧
    public static JSONObject setDataStreams(DataStreams dataStreams) {
        String url_post = apiUrl + dataStreams.getIot().getDevice_id() + "/datapoints";
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url_post);
        post.addHeader("api-key", dataStreams.getIot().getApiKey());
        JSONObject response = null;
        String str = "{\n" +
                "  \"datastreams\":[{\n" +
                "      \"id\":\"" + dataStreams.getDataStream() + "\",\n" +
                "      \"datapoints\":[{\n" +
                "          \"value\":\"" + dataStreams.getValue() + "\"\n" +
                "      }]\n" +
                "  }]\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(str);
        try {
            StringEntity s = new StringEntity(jsonObject.toString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                org.apache.http.HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(entity);
                response = JSONObject.parseObject(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}

package com.example.springboothttpclient.service;

import com.example.springboothttpclient.domain.HttpResult;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class HttpAPIService {

    private static Logger logger = LoggerFactory.getLogger(HttpAPIService.class);

    // 注入HttpClient实例
    @Resource(name = "httpClientManagerFactoryBean")
    private CloseableHttpClient httpClient;

    @Autowired
    private RequestConfig config;


    /**
     * 不带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回空字符串
     * @param url
     * @return
     * @throws Exception
     */
    public String doGet(String url) throws Exception {

        String str="";
        // 声明 http get 请求
        HttpGet httpGet = new HttpGet(url);
        // 装载配置信息
        httpGet.setConfig(config);
        //返回实体
        HttpEntity entity=null;
        try {
            // 发起请求
            CloseableHttpResponse response = this.httpClient.execute(httpGet);

            // 判断状态码是否为200
            if (response.getStatusLine().getStatusCode() == 200) {

                entity= response.getEntity();
                // 返回响应体的内容
                str = EntityUtils.toString(entity, "UTF-8");

            }
            return str;
        }catch(IOException e){
            logger.error(e.getMessage(),e);
            throw e;
        }finally{
            EntityUtils.consumeQuietly(entity);// 释放连接
        }

    }

    /**
     * 带参数的get请求，如果状态码为200，则返回body，如果不为200，则返回空字符串
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public String doGet(String url, Map<String, Object> map) throws Exception {
        // 调用不带参数的get请求
        return this.doGet(formatUrl(url,map));
    }

    /**
     * 带参数的post请求
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public HttpResult doPost(String url,Map<String, Object> map)throws Exception{
        HttpPost httpPost=null;
        try {
            httpPost = new HttpPost(url);
            httpPost.setConfig(config);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

            // 判断map是否为空，不为空则进行遍历，封装from表单对象
            if (map != null) {
                List<NameValuePair> list = new ArrayList<NameValuePair>();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
                }
                // 构造from表单对象
                UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(list, "UTF-8");


                // 把表单放到post里
                httpPost.setEntity(urlEncodedFormEntity);
            }

            // 发起请求

            return execute(httpPost);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            throw e;
        }finally{
            httpPost.releaseConnection();
        }

    }

    /**
     * 带参数的post请求
     * @param url
     * @param params
     * @param jsonParam
     * @return
     * @throws Exception
     */
    public HttpResult doPostForJsonParam(String url,Map<String,Object> params,String jsonParam) throws Exception{
        HttpPost httpPost =null;
        try {
            // 声明httpPost请求
            httpPost=new HttpPost(formatUrl(url, params));

            // 加入配置信息
            httpPost.setConfig(config);
            httpPost.setHeader("Content-Type", "application/json");

            StringEntity stringEntity = new StringEntity(jsonParam, "UTF-8");

            httpPost.setEntity(stringEntity);

            return execute(httpPost);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            throw e;
        }finally {
            httpPost.releaseConnection();
        }
    }

    /**
     * 带参数的post请求
     * @param url
     * @param jsonParam
     * @return
     * @throws Exception
     */
    public HttpResult doPostForJsonParam(String url,String jsonParam) throws Exception{

        return doPostForJsonParam(url,null,jsonParam);
    }

    private HttpResult execute(HttpPost httpPost)throws Exception{

        HttpEntity entity=null;

        try {
            // 发起请求
            CloseableHttpResponse response  = this.httpClient.execute(httpPost);

            entity=response.getEntity();

            String str=EntityUtils.toString(entity, "UTF-8");

            return new HttpResult(response.getStatusLine().getStatusCode(), str);

        } catch (IOException e) {
            logger.error(e.getMessage(),e);
            throw e;
        }finally{
            EntityUtils.consumeQuietly(entity);// 释放连接
        }
    }

    private String formatUrl(String url,Map<String,Object> map){
        String format=url;
        try {
            URIBuilder uriBuilder  = new URIBuilder(url);
            if (map != null) {
                // 遍历map,拼接请求参数
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
                }

                return uriBuilder.build().toString();
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return format;
    }

    /**
     * 不带参数post请求
     *
     * @param url
     * @return
     */
    public HttpResult doPost(String url) throws Exception{
        return this.doPost(url, null);
    }
}
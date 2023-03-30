package com.example.demo.utils;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * chat http工具类
 */
@Component
public class ChatHttpClientUtil {

    @Resource(name = "customRestTemplate")
    RestTemplate customRestTemplate;


    /**
     * 定义请求地址
     */
    private final static String requestUrl = "https://api.openai.com/v1/chat/completions";

    /**
     * apiKey
     */
    private final static String apiKey = "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";

    public String postHttp(String message) {
        //1.请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(org.springframework.http.MediaType.parseMediaType("application/json; charset=UTF-8"));
        httpHeaders.add("Content-Type", org.springframework.http.MediaType.APPLICATION_JSON.toString());
        httpHeaders.add("Authorization", "Bearer " + apiKey);
        List<Map<String, String>> messages = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("role", "user");
        map.put("content", message);
        messages.add(map);

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("model", "gpt-3.5-turbo");
        reqBody.put("messages", messages);
        reqBody.put("temperature", 0.7);
        //2.请求体
        HttpEntity<Map<String, Object>> httpEntityEmpty = new HttpEntity<>(reqBody, httpHeaders);
        ResponseEntity<String> exchange = customRestTemplate.exchange(requestUrl, HttpMethod.POST, httpEntityEmpty, String.class);
        return exchange.getBody();
    }

    public Response requestChatOpenPost(String message) {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .proxy(new Proxy(Proxy.Type.HTTP,new InetSocketAddress("localhost",8081)))
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        List<Map<String, String>> messages = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("role", "user");
        map.put("content", message);
        messages.add(map);

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("model", "gpt-3.5-turbo");
        reqBody.put("messages", messages);
        reqBody.put("temperature", 0.7);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), JSON.toJSONBytes(reqBody));
        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .post(requestBody)
                .build();

        Response response = null;
        try {
            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return response;
    }

    public void relay(String message) throws IOException {

        String endpoint = "http://localhost:8081/open/relay";
        URL url = new URL(endpoint);

        // Create a HttpURLConnection object with the proxy and URL details
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // Set the HTTP request method, headers and body
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        String requestBody = "{\"prompt\": \""+message+"\"}";
        con.getOutputStream().write(requestBody.getBytes(StandardCharsets.UTF_8));

        // Send the HTTP request and read the response
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Print the HTTP response code and response body
        System.out.println("HTTP response code: " + responseCode);
        System.out.println("HTTP response body: " + response.toString());
    }

}

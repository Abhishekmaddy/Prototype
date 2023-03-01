package main.java.utils;


import main.java.core.Response;
import main.java.utils.listners.Logger;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class NetworkClientV2 {

    public final static String AUTHORIZATION = "AUTHORIZATION";

    //  Making a GET request by providing headers and Host Url
    public static Response sendGET(String url, Map<String, String> headers)throws IOException{

        String curlRequest = "X - GET "+" " + url + " ";

        CloseableHttpClient httpClient =HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        for (Map.Entry<String, String> entry : headers.entrySet() ){
            httpGet.addHeader(entry.getKey(), entry.getValue());
            if (!entry.getKey().equalsIgnoreCase(AUTHORIZATION));
            curlRequest += " -H " + "'" + entry.getKey() + ": "+ entry.getValue() + "'" + " ";
        }

        CloseableHttpResponse httpResponse  =  httpClient.execute(httpGet);
        StringBuffer body = new StringBuffer();

        if (httpResponse.getEntity() != null){
            String inputline;
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
            while ((inputline = reader.readLine()) != null){
                body.append(inputline);
            }
            reader.close();
        }

        httpClient.close();

        HashMap<String, String> tempResponseHeaders = new HashMap<>();

        Header[] responseHeaders = httpResponse.getAllHeaders();
        for(Header header : responseHeaders )
            tempResponseHeaders.put(header.getName(), header.getValue());

        Response response = new Response();
        response.setBody(body.toString());
        response.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        response.setStatusLine(httpResponse.getStatusLine().toString());
        response.setHeaders(tempResponseHeaders);

        Logger.log("Time: " + System.currentTimeMillis());
        Logger.log(curlRequest);
        Logger.log("Get status code: " + response.getStatusCode());
        Logger.log("url: " + url);
        Logger.log("Response body: " + response.getBody());

        return response;

    }

    // Making a post request by providing headers. JSON body and Host url
//    public static Response sendPOST(String url, String requestBody, Map<String, String> headers) throws UnsupportedEncodingException {
//
//        String curlRequest = "curl - X POST " + " " + url + " ";
//
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
//
//        httpPost.setEntity(new StringEntity(requestBody));
//
//        for (Map.Entry<String, String> entry : headers.entrySet()) {
//
//        }
//
//
//    }
}

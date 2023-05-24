package main.java.core;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter

public class Response {

    private String statusLine;
    private Integer statusCode;
    private String body;
    private HashMap<String, String> headers;

    public String getHeaders(String headersLKey) {
        return headers.get(headersLKey);
    }
}

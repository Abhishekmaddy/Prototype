package main.java.books.actions;

import io.qameta.allure.Step;
import main.java.books.endpoint.BooksEndPoint;
import main.java.core.Response;
import main.java.utils.NetworkClientV2;

import java.io.IOException;
import java.util.Map;

public class BooksActions {

    @Step("Create Book")
    public  static Response createBook(String requestBody, Map<String, String> requestHeaders) throws IOException {
        return (NetworkClientV2.sendPOST(BooksEndPoint.getBooksEndpoint().getCreateBooksEndPoint(), requestBody, requestHeaders)) ;
    }
}

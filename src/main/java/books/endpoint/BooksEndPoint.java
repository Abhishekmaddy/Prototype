package main.java.books.endpoint;

import lombok.Getter;

@Getter
public class BooksEndPoint {
    private static BooksEndPoint booksendpoint = null;

    public BooksEndPoint(){

    }

    public static synchronized BooksEndPoint getBooksEndpoint(){
        if (booksendpoint == null){
            booksendpoint = new BooksEndPoint();
        }
        return booksendpoint;
    }

    private String createBooksEndPoint = "/maps/api/place/add/json?key=qaclick123";

}

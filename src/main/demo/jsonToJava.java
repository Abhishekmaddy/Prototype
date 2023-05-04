package main.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.protocol.Resultset;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class jsonToJava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
     Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= null;
        ArrayList<CustomerDetails>  ar= new ArrayList<CustomerDetails>();
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "root");


        //object of statement class will help us to execute quries
        Statement st= conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from CustomerInfo where location ='Asia' and PurchasedDate=CURDATE();");
        while (rs.next()){
            CustomerDetails cd= new CustomerDetails();
            cd.setCourseName(rs.getString(1));
            cd.setPurchaseDate(rs.getString(2));
            cd.setAmount(rs.getInt(3));
            cd.setLocation(rs.getString(4));

            ar.add(cd);
        }

        for (int i =0; i<ar.size(); i++)
        {
            ObjectMapper ob = new ObjectMapper();
            ob.writeValue(new File("C:\\Users\\abhir\\IdeaProjects\\Prototype\\CustomerInfo"+i+".json"), ar.get(i));
        }


        conn.close();
    }
}

package main.java.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.lang.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class jsonToJava2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
     Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn= null;
        ArrayList<demo.CustomerDetails>  ar= new ArrayList<demo.CustomerDetails>();
        JSONArray js= new JSONArray();
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "root");


        //object of statement class will help us to execute quries
        Statement st= conn.createStatement();
        ResultSet rs=st.executeQuery("Select * from CustomerInfo where location ='Asia' and PurchasedDate=CURDATE();");
        while (rs.next()){
            demo.CustomerDetails cd= new demo.CustomerDetails();
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
            Gson g = new Gson();
            String jsonString=g.toJson(ar.get(i));
            js.add(jsonString);
        }
        //Json Simple
        JSONObject jo = new JSONObject();
        jo.put("data",js);
        System.out.println(jo.toJSONString());
        String unescapeString=StringEscapeUtils.unescapeJava(jo.toJSONString());
        System.out.println(unescapeString);
        String string1=unescapeString.replace("\"{","{");
        String finalString = string1.replace("}\"","}");
        System.out.println(finalString);
        try (FileWriter file = new FileWriter("C:\\Users\\abhir\\IdeaProjects\\Prototype\\single.json")){
            file.write(finalString);
        }


        conn.close();

    }
}

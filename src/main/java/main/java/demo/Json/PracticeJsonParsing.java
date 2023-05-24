package main.java.demo.Json;

import org.json.JSONObject;

public class PracticeJsonParsing {
    public static void main(String[] args) {
        String content = "{\n" +
                "  \"CustomerId\": \"ad4334ad-c415-4382-9370-cead8db9ea8a\",\n" +
                "  \"EmploymentStatus\": \"Salaried\",\n" +
                "  \"CurrentEmployer\": \"hotel\",\n" +
                "  \"NetMonthlyIncome\": 120000,\n" +
                "  \"LiveWith\": \"NoOne\",\n" +
                "  \"MinimumMonthlySpending\": 0,\n" +
                "  \"MaximumMonthlySpending\": 5000\n" +
                "}";

        JSONObject jsonObject = new JSONObject(content);




    }
}

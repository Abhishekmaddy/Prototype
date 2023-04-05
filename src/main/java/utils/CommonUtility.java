package main.java.utils;


import main.java.constants.MathConstants;
import main.java.enums.CalenderEnums;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonUtility {

    //    This method generates random Pan Numbers
    public static String randomPAN() {
        String firstpart = randomchar(3);
        String secondpart = randomchar(1);
        String thirdpart = randomdigit(4);
        String fourthPart = randomchar(1);
        return firstpart + "P" + secondpart + thirdpart + fourthPart;
    }

    public static String randomchar(int numberofchars) {
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = null;
        final int N = alphabet.length();
        Random r = new Random();
        sb = new StringBuffer();
        for (int i = 0; i < numberofchars; i++) {
            sb = sb.append(alphabet.charAt(r.nextInt(N)));
        }
        return sb.toString();
    }

    private static String randomdigit(int numberofchars) {
        final String alphabet = "1234567890";
        StringBuffer sb = null;
        final int N = alphabet.length();
        Random r = new Random();
        sb = new StringBuffer();
        for (int i = 0; i < numberofchars; i++) {
            sb = sb.append(alphabet.charAt(r.nextInt(N)));
        }
        return sb.toString();
    }

    //    To generate the first digit of mobile number from a given set of digits
    public static String randomdigitPhone(int numberofchars) {
        final String alphabet = "6789";
        StringBuffer sb = null;
        final int N = alphabet.length();
        Random r = new Random();
        sb = new StringBuffer();
        for (int i = 0; i < numberofchars; i++) {
            sb = sb.append(alphabet.charAt(r.nextInt(N)));
        }
        return sb.toString();
    }

    //    This is to generate random mobileNumber
    public static String randomMobileNumber() {
        String firstPart = randomdigitPhone(1);
        String secondPart = randomdigit(9);
        return firstPart + secondPart;
    }

    public static String findDOBByAge(int age) {

        Calendar calendar = Calendar.getInstance();
        // Subtract allowed age age in terms of years
        calendar.add(Calendar.YEAR, -age);

        Date currentTime = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(currentTime);
    }

    public static String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        Date currentTime = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(currentTime);
    }

    public static String getCurrentDateTime() {
        Calendar calendar = Calendar.getInstance();
        Date currentTime = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(currentTime);
    }

    public static String getRequiredDateTimeInHours(String addSubtract, int hour, CalenderEnums dateFormat) {
        Calendar calendar = Calendar.getInstance();
        if (addSubtract.equals(MathConstants.ADDITION)) {
            calendar.add(Calendar.HOUR_OF_DAY, hour);
        } else if (addSubtract.equals(MathConstants.SUBTRACT)) {
            calendar.add(Calendar.HOUR_OF_DAY, -hour);
        }
        Date currentTime = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat.label);
        return sdf.format(currentTime);
    }

    public static String getRequiredDateTimeInHoursUtc(String addSubtract, int hour, CalenderEnums dateFormat) {
        Calendar calendar = Calendar.getInstance();
        if (addSubtract.equals(MathConstants.ADDITION)) {
            calendar.add(Calendar.HOUR_OF_DAY, hour);
        } else if (addSubtract.equals(MathConstants.SUBTRACT)) {
            calendar.add(Calendar.HOUR_OF_DAY, -hour);
        }
        Date currentTime = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat.label);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(currentTime);
    }

    public static String getCurrentDateTimeWithT() {
        Calendar calendar = Calendar.getInstance();
        Date currentTime = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return sdf.format(currentTime);
    }

    // Get date by adding or subtracting specified number
    public static String getDateByAddingSubtractingDaysFromCurrentDate(int daysMonthsYears, CalenderEnums calenderEnums, String Operation) {
        Calendar calendar = Calendar.getInstance();
        switch (calenderEnums) {
            case DATE:
                if (Operation.equalsIgnoreCase(MathConstants.ADDITION)) {
                    calendar.add(Calendar.DATE, +daysMonthsYears);
                } else if (Operation.equalsIgnoreCase(MathConstants.SUBTRACT)) {
                    calendar.add(Calendar.DATE, -daysMonthsYears);
                }
                break;
            case MONTH:
                if (Operation.equalsIgnoreCase(MathConstants.ADDITION)) {
                    calendar.add(Calendar.MONTH, +daysMonthsYears);
                } else if (Operation.equalsIgnoreCase(MathConstants.SUBTRACT)) {
                    calendar.add(Calendar.MONTH, -daysMonthsYears);
                }
                break;
            case YEAR:
                if (Operation.equalsIgnoreCase(MathConstants.ADDITION)) {
                    calendar.add(Calendar.YEAR, +daysMonthsYears);
                } else if (Operation.equalsIgnoreCase(MathConstants.SUBTRACT)) {
                    calendar.add(Calendar.YEAR, -daysMonthsYears);
                }
                break;
        }
        Date currentTime = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(currentTime);
    }

    // Get date by adding or subtracting specified number and you can get specified date format
    public static String getDateByAddingSubtractingDaysFromCurrentDate(int daysMonthsYears, CalenderEnums calenderEnums, String Operation, String dateFormat) {
        Calendar calendar = Calendar.getInstance();
        switch (calenderEnums) {
            case DATE:
                if (Operation.equalsIgnoreCase(MathConstants.ADDITION)) {
                    calendar.add(Calendar.DATE, +daysMonthsYears);
                } else if (Operation.equalsIgnoreCase(MathConstants.SUBTRACT)) {
                    calendar.add(Calendar.DATE, -daysMonthsYears);
                }
                break;
            case MONTH:
                if (Operation.equalsIgnoreCase(MathConstants.ADDITION)) {
                    calendar.add(Calendar.MONTH, +daysMonthsYears);
                } else if (Operation.equalsIgnoreCase(MathConstants.SUBTRACT)) {
                    calendar.add(Calendar.MONTH, -daysMonthsYears);
                }
                break;
            case YEAR:
                if (Operation.equalsIgnoreCase(MathConstants.ADDITION)) {
                    calendar.add(Calendar.YEAR, +daysMonthsYears);
                } else if (Operation.equalsIgnoreCase(MathConstants.SUBTRACT)) {
                    calendar.add(Calendar.YEAR, -daysMonthsYears);
                }
                break;
        }
        Date currentTime = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(currentTime);
    }

    // Get date in UTC format by adding or subtracting specified number and you can get specified date format
    public static String getDateInUTCFormatByAddingSubtractingDaysFromCurrentDate(int daysMonthsYears, CalenderEnums calenderEnums, String Operation, String dateFormat) {
        Calendar calendar = Calendar.getInstance();
        switch (calenderEnums) {
            case DATE:
                if (Operation.equalsIgnoreCase(MathConstants.ADDITION)) {
                    calendar.add(Calendar.DATE, +daysMonthsYears);
                } else if (Operation.equalsIgnoreCase(MathConstants.SUBTRACT)) {
                    calendar.add(Calendar.DATE, -daysMonthsYears);
                }
                break;
            case MONTH:
                if (Operation.equalsIgnoreCase(MathConstants.ADDITION)) {
                    calendar.add(Calendar.MONTH, +daysMonthsYears);
                } else if (Operation.equalsIgnoreCase(MathConstants.SUBTRACT)) {
                    calendar.add(Calendar.MONTH, -daysMonthsYears);
                }
                break;
            case YEAR:
                if (Operation.equalsIgnoreCase(MathConstants.ADDITION)) {
                    calendar.add(Calendar.YEAR, +daysMonthsYears);
                } else if (Operation.equalsIgnoreCase(MathConstants.SUBTRACT)) {
                    calendar.add(Calendar.YEAR, -daysMonthsYears);
                }
                break;
        }
        Date currentTime = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(currentTime);
    }

    // Pass the classLoader and filepath to get the inputStream and don't forget to close the resource
    public static InputStream getInputStreamForFile(ClassLoader classLoader, String filePath) {
        InputStream input = classLoader.getResourceAsStream(filePath);
        return input;
    }

//    // Pass the classLoader and filepath to get the inputStream and don't forget to close the resource
//    public static void polling60SecondsForDBRecords(String query, String[] queryParams ) throws Exception {
//        int i = 0;
//        while (i < 60) {
//            int recordSize = DBUtils.getMultipleColumnData(DBUtils.createQuery(query, queryParams)).size();
//            if (recordSize > 0) break;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            i++;
//            Logger.log("Waiting for record - polled " + i + " time.");
//
//        }
//    }

    public static String mapTimeFormat(String date, String In, String out) throws ParseException {
        return Optional.ofNullable(new SimpleDateFormat(In).parse(date))
                .map(d1->new SimpleDateFormat(out).format(d1))
                .orElse("");
    }
}

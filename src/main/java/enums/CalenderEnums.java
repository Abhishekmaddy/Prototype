package main.java.enums;

public enum CalenderEnums {
    DATE("date"),
    MONTH("month"),
    YEAR("year"),
    DATEFORMATyyyyMMddTHHmmss("yyyy-MM-dd'T'HH:mm:ss"),
    DATEFORMATyyyyMMdd("yyyy-MM-dd"),
    DATEFORMATyyyyMMdd_HHmmss("yyyy-MM-dd HH:mm:ss"),
    DATEFORMATyyyyMMddTHHmmssSSSSSS("yyyy-MM-dd HH:mm:ss.SSSSSS"),
    DATEFORMATyyyyMMddTHHmmssSSS("yyyy-MM-dd'T'HH:mm:ss.SSS"),
    DATEFORMATyyyyMMddTHHmmssZ("yyyy-MM-dd'T'HH:mm:ss'Z'"),
    DATEFORMATyyyyMMddTHHmmsssssZ("yyyy-MM-dd'T'HH:mm:ss.sssZ"),
    DATEFORMATyyyyMMddTHHmmssssssssZ("yyyy-MM-dd'T'HH:mm:ss.ssssssZ");

    public final String label;

    private CalenderEnums(String label) {
        this.label = label;
    }
}

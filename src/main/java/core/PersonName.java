package main.java.core;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonName {
    private String firstName;
    private String middleName;
    private String lastName;

    public PersonName(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}

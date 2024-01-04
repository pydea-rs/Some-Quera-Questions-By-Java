package CivilRegistry;

import java.util.regex.Pattern;

public class Person {
    private String name, lastName;
    public String getName() {
        return this.name;
    }
    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.name + " " + this.lastName;
    }

    public Person(String name, String lastName) throws InvalidName {
        if(!Pattern.matches("[A-Z][a-z]+ {3,}", name))
            throw new InvalidName(name);
        if(!Pattern.matches("[A-Z][a-z]+ {3,}", lastName))
            throw new InvalidName(lastName);
        this.name = name;
        this.lastName = lastName;
    }

    public boolean equals(Person other) {
        return this.name.equals(other.getName()) && this.lastName.equals(other.getLastName());
    }

}

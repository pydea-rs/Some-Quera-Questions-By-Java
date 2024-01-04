package CivilRegistry;

public class CivilRegistrationBranch {
    private String areaName;
    private Person[] people;

    public Person[] getPeople() {
        return this.people;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public void setAreaName(String newAreaName) {
        this.areaName = newAreaName;
    }

    public CivilRegistrationBranch(String areaName) {
        this.areaName = areaName;
    }

    public void addPerson(Person newPerson) throws PersonAlreadyExists {
        if(this.people == null) {
            this.people = new Person[1];
            this.people[0] = newPerson;
        }
        else {
            Person[] newList = new Person[this.people.length + 1];
            for(int i = 0; i < this.people.length; i++) {
                if(newPerson.equals(this.people[i]))
                    throw new PersonAlreadyExists(newPerson);
                newList[i] = this.people[i];
            }
            newList[this.people.length] = newPerson;
            this.people = newList;
        }
    }

    public void removePerson(Person person) throws PersonDoesntExist {
        if(this.people == null)
            throw new PersonDoesntExist(person);
        int position = -1;
        for(int i = 0; i < this.people.length; i++) {
            if(person.equals(this.people[i])) {
                position = i;
                break;
            }
        }
        if(position == -1)
            throw new PersonDoesntExist(person);
        Person[] newList = new Person[this.people.length - 1];
        for(int i = 0; i < position; i++)
            newList[i] = this.people[i];
        for(int i = position + 1; i < this.people.length; i++)
            newList[i - 1] = this.people[i];
        this.people = newList;
    }

    public boolean equals(CivilRegistrationBranch other) {
        return this.areaName.equals(other.getAreaName());
    }

}

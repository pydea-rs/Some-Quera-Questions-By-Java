package CivilRegistry;

public class GovernmentException extends Exception {
    public GovernmentException(String message) {
        super(message);
    }
}
class CivilRegistrationBranchDoesntExist extends GovernmentException {
    public CivilRegistrationBranchDoesntExist(String areaName) {
        super("There is no branch in " + areaName);
    }
}
class CivilRegistrationBranchAlreadyExists extends GovernmentException {
    public CivilRegistrationBranchAlreadyExists(CivilRegistrationBranch branch) {
        super(branch.getAreaName() + " already exists in branches list.");
    }
}
class InvalidName extends GovernmentException {
    public InvalidName(String name) {
        super(name + " is an invalid name.");
    }
}
class PersonAlreadyExists extends GovernmentException {
    public PersonAlreadyExists(Person person) {
        super(person.getFullName() + " already exists in this branch.");
    }
}
class PersonDoesntExist extends GovernmentException {
    public PersonDoesntExist(Person person) {
        super(person.getFullName() + " doesnt exist in this branch.");
    }
    public PersonDoesntExist(String name, String lastName) {
        super(name + " " + lastName + " doesnt exist in this branch.");
    }
}

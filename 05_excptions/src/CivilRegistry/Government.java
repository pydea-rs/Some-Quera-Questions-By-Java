package CivilRegistry;

public class Government {
    private CivilRegistrationBranch[] civilRegistrationBranches;

    public CivilRegistrationBranch[] getBranches() {
        return  this.civilRegistrationBranches;
    }

    public CivilRegistrationBranch getBranchByAreaName(String areaName) throws CivilRegistrationBranchDoesntExist {
        if(this.civilRegistrationBranches == null)
            throw new CivilRegistrationBranchDoesntExist(areaName);
        for(int i = 0; i < this.civilRegistrationBranches.length; i++) {
            if(areaName.equals(this.civilRegistrationBranches[i].getAreaName())) {
                return this.civilRegistrationBranches[i];
            }
        }
        throw new CivilRegistrationBranchDoesntExist(areaName);
    }

    public void addCivilRegistration(CivilRegistrationBranch civilRegistrationBranch) throws CivilRegistrationBranchAlreadyExists {
        if(this.civilRegistrationBranches == null) {
            this.civilRegistrationBranches = new CivilRegistrationBranch[1];
            this.civilRegistrationBranches[0] = civilRegistrationBranch;
        }
        else {
            CivilRegistrationBranch[] newList = new CivilRegistrationBranch[this.civilRegistrationBranches.length + 1];
            for(int i = 0; i < this.civilRegistrationBranches.length; i++) {
                if(civilRegistrationBranch.equals(this.civilRegistrationBranches[i]))
                    throw new CivilRegistrationBranchAlreadyExists(civilRegistrationBranch);
                newList[i] = this.civilRegistrationBranches[i];
            }
            newList[this.civilRegistrationBranches.length] = civilRegistrationBranch;
            this.civilRegistrationBranches = newList;
        }
    }

    public int getNumberOfPeople(String name, String lastName) throws InvalidName, PersonDoesntExist {
        int count = 0;

        if(this.civilRegistrationBranches != null) {
            for(int i = 0; i < this.civilRegistrationBranches.length; i++) {
                final Person[] people = this.civilRegistrationBranches[i].getPeople();
                if(people != null) {
                    for(int j = 0; j < people.length; j++) {
                        final Person person = people[j];
                        if((name.equals(person.getName()) || name.equals("")) && (lastName.equals(person.getLastName()) || lastName.equals("")))
                            count++;
                    }
                }
            }
        }

        if(count == 0)
            throw new PersonDoesntExist(name, lastName);
        return count;
    }
    public int getPopulation(String name, String lastName) {
        int count = 0;

        if(this.civilRegistrationBranches != null) {
            for(int i = 0; i < this.civilRegistrationBranches.length; i++) {
                final Person[] people = this.civilRegistrationBranches[i].getPeople();
                if(people != null) {
                    count += people.length;
                }
            }
        }
        return count;
    }
}

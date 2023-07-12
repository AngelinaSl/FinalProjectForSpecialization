package Animals;

public abstract class Animal {
    protected String name;
    protected String dOB;   // dateOfBirth

    protected String skills;

    public Animal(String name, String birth, String skills) {
        this.name = name;
        this.dOB = birth;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void learnCommands(String command) {
    }

    public void showCommand() {
    }
}

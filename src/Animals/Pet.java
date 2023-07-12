package Animals;

public abstract class Pet extends Animal {

    public String home = "house"; // переменная добавлена просто ради создания нового конструктора

    public Pet(String name, String dOB, String skills, String home) {
        super(name, dOB, skills);
        this.home = home;
    }
}

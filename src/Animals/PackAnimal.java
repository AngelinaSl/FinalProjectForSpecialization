package Animals;

public abstract class PackAnimal extends Animal {

    public String home = "stable"; // переменная добавлена ради создания нового конструктора

    public PackAnimal(String name, String dOB, String skills, String home) {
        super(name, dOB, skills);
        this.home = home;
    }
}

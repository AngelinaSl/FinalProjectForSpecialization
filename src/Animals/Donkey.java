package Animals;

public class Donkey extends PackAnimal{

    public Donkey(String name, String dOB, String skills, String home) {
        super(name, dOB, skills, home);
    }
    @Override
    public void showCommand() {
        System.out.println("Осел " + getName() + " умеет: " + getSkills());
    }
    @Override
    public void learnCommands(String command) {
        String newSkills = getSkills() + ", " + command;
        setSkills(newSkills);
        System.out.println("Команда " + command + " добавлена в копилку умений осла " + getName());
    }
}

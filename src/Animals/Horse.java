package Animals;

public class Horse extends PackAnimal {
    public Horse(String name, String dOB, String skills, String home) {
        super(name, dOB, skills, home);
    }

    @Override
    public void showCommand() {
        System.out.println("Конь " + getName() + " умеет: " + getSkills());
    }

    @Override
    public void learnCommands(String command) {
        String newSkills = getSkills() + ", " + command;
        setSkills(newSkills);
        System.out.println("Команда " + command + " добавлена в копилку умений коня " + getName());
    }
}

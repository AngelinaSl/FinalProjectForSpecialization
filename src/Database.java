import Animals.*;

import java.io.*;
import java.util.*;

public class Database {
    public int lines = 0;
    private final List<Animal> animals;
    private static final String FILE_PATH = "src/database.txt";

    public Database() {
        animals = new ArrayList<>();
        loadingDatabase();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        saveDatabase();
    }

    public void addNewCommand(String name, String command) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                String[] commands = command.split(",");
                for (int i = 0; i < commands.length; i++) {
                    String trimmedCommand = commands[i].trim();
                    commands[i] = trimmedCommand;
                }
                animal.learnCommands(command);
                saveDatabase();
                System.out.println("Команда успешно добавлена.");
                return;
            }
        }
        System.out.println("Животное с именем " + name + " не найдено.");
    }

    public void showCommands(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                animal.showCommand();
                return;
            }
        }
        System.out.println("Животное с именем " + name + " не найдено.");
    }

    private void loadingDatabase() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 4) {
                    String className = data[0];
                    String name = data[1];
                    String dOB = data[2];
                    String skills = String.join(",", Arrays.copyOfRange(data, 3, data.length));
                    Animal animal;

                    switch (className) {
                        case "Dog" -> animal = new Dog(name, dOB, skills, "house");
                        case "Cat" -> animal = new Cat(name, dOB, skills, "house");
                        case "Hamster" -> animal = new Hamster(name, dOB, skills, "house");
                        case "Donkey" -> animal = new Donkey(name, dOB, skills,  "stable");
                        case "Horse" -> animal = new Horse(name, dOB, skills,  "stable");
                        case "Camel" -> animal = new Camel(name, dOB, skills,  "stable");
                        default -> {
                            System.out.println("Неизвестный класс животного: " + className);
                            continue;
                        }
                    }
                    animals.add(animal);
                    this.lines++;
                } else {
                    System.out.println("Некорректные данные в файле: " + line);
                }
            }
            System.out.println("База данных успешно загружена.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении базы данных: " + e.getMessage());
        }
    }

    public static void showAllAnimals() {
        try {
            File file = new File(FILE_PATH);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String animalData = fileScanner.nextLine();
                System.out.println(animalData);
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }

    private void saveDatabase() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Animal animal : animals) {
                String className = animal.getClass().getSimpleName();
                String name = animal.getName();
                String dOB = animal.getdOB();
                String skills = animal.getSkills().replaceAll(",\\s+", ",");

                String line = className + "," + name + "," + dOB + "," + skills;
                writer.write(line);
                writer.newLine();
            }
            System.out.println("База данных успешно сохранена.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении базы данных: " + e.getMessage());
        }
    }

//    public static long getLineCountByIncrement(String fileName) throws IOException {
//        var lines = 0L;
//        try (var reader = new BufferedReader(new FileReader(fileName))) {
//            while (reader.readLine() != null) {
//                lines++;
//            }
//            return lines;
//        }
//    }

    public int getLines() {
        return lines;
    }
}
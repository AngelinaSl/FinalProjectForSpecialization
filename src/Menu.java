import Animals.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu  implements MenuInterface{
    private final Database database;
    private final Scanner scanner;

    public Menu(Database database) {
        this.database = database;
        scanner = new Scanner(System.in);
    }
    public void showMenu() {
        while (true) {
            try {
                System.out.println("Меню:");
                System.out.println("1. Добавить новое животное");
                System.out.println("2. Показать список всех животных");
                System.out.println("3. Просмотреть команды животного");
                System.out.println("4. Добавить новую команду");
                System.out.println("0. Выход");
                System.out.print("Выберите пункт меню: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addNewAnimal();
                    case 2 -> Database.showAllAnimals();
                    case 3 -> menuShowAnimalCommands();
                    case 4 -> menuAddNewCommand();
                    case 0 -> {
                        System.out.println("Выход");
                        return;
                    }
                    default -> System.out.println("Такого пункта нет. Попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: неверный формат ввода. Попробуйте снова.");
                scanner.nextLine();
            }
        }
    }


    private void addNewAnimal() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения в формате гггг.мм.дд:");
        String dOB = scanner.nextLine();
        System.out.println("Введите список команд через запятую:");
        String skills = scanner.nextLine();

        System.out.println("Выберите класс животного:");
        System.out.println("1. Собака");
        System.out.println("2. Кошка");
        System.out.println("3. Хомяк");
        System.out.println("4. Осёл");
        System.out.println("5. Конь");
        System.out.println("6. Верблюд");
        int animalClass = scanner.nextInt();
        scanner.nextLine();

//        if (counter.addCount(name, dOB, skills) = true);
        Animal animal;
        switch (animalClass) {
            case 1 -> animal = new Dog(name, dOB, skills, "house");
            case 2 -> animal = new Cat(name, dOB, skills, "house");
            case 3 -> animal = new Hamster(name, dOB, skills, "house");
            case 4 -> animal = new Donkey(name, dOB, skills, "stable");
            case 5 -> animal = new Horse(name, dOB, skills, "stable");
            case 6 -> animal = new Camel(name, dOB, skills, "stable");
            default -> {
                System.out.println("Такого животного нет в списке.");
                return;
            }
        }

        database.addAnimal(animal);
        System.out.println("Животное успешно добавлено в базу данных.");
    }

    private void menuShowAnimalCommands() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        database.showCommands(name);
    }

    private void menuAddNewCommand() {
        System.out.println("Введите имя животного:");
        String name = scanner.nextLine();
        System.out.println("Введите новые команды через запятую:");
        String command = scanner.nextLine();
        database.addNewCommand(name,  command);
//        System.out.println("Команда успешно добавлена для животного.");
    }
}

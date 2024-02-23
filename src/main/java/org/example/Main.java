package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Registry registry;

    public static void main(String[] args) {

        registry = new Registry();

        menu();

    }

    public static void menu() {
        System.out.println("1. Добавить животное");
        System.out.println("2. Вывод список команд животного");
        System.out.println("3. Добавить обученную команду");
        System.out.println("4. Вывод списка животных по дате рождения");
        System.out.println("5. Завершить");

        System.out.print("Ввод: ");
        String search = scanner.next();
        switch (search) {
            case "1" -> {
                addAnimalFriend();
            }
            case "2" -> {
                userInput();
            }
            case "3" -> {
                System.out.print("Введите имя животного: ");
                String name = scanner.next();
                System.out.print("Введите обученную команду: ");
                String skill = scanner.next();
                System.out.println(registry.addSkills(name, skill));
                menu();
            }
            case "4" -> {
                registry.printListOfFriends();
                menu();
            }
            case "5" -> {
                return;
            }
            default -> {
                System.out.println("Повторите попытку");
                menu();
            }
        }
    }

    public static void userInput() {
        System.out.print("Введите искомое имя: ");
        String input = scanner.next();
        System.out.println(registry.findFriend(input));
        menu();
    }

    public static void addAnimalFriend() {

        System.out.println("1. собака");
        System.out.println("2. кошка");
        System.out.println("3. хомяк");
        System.out.println("4. лошадь");
        System.out.println("5. верблюд");
        System.out.println("6. осёл");
        System.out.println("7. Вернуться в основное меню");
        System.out.print("Ввод: ");

        int input = 0;

        //проверка на ввод числа
        String inputStr = scanner.next();
        if (inputStr.matches("\\d+")) {
            input = Integer.parseInt(inputStr);
        } else {
            System.out.println("Повторите попытку");
            addAnimalFriend();
        }

        if (input > 7 || input < 1) {
            System.out.println("Повторите попытку");
            addAnimalFriend();
        } else if (input == 7) {
            return;
        } else {
            System.out.print("Введите имя животного: ");
            String name = scanner.next();

            System.out.print("Введите дату рождения животного формата(гггг-мм-дд): ");
            String birthday = scanner.next();
            try {
                LocalDate birthday1 = LocalDate.parse(birthday);
            } catch (Exception e) {
                System.out.println("не возможно преобразовать в дату. Повторите ввод");
                addAnimalFriend();
            }

            System.out.print("Введите команду, которую умеет выполнять: ");
            String skills = scanner.next();

            switch (input) {
                case 1 -> registry.addFriend(new Dog(name, LocalDate.parse(birthday), skills));
                case 2 -> registry.addFriend(new Cat(name, LocalDate.parse(birthday), skills));
                case 3 -> registry.addFriend(new Hamster(name, LocalDate.parse(birthday), skills));
                case 4 -> registry.addFriend(new Horse(name, LocalDate.parse(birthday), skills));
                case 5 -> registry.addFriend(new Camel(name, LocalDate.parse(birthday), skills));
                case 6 -> registry.addFriend(new Donkey(name, LocalDate.parse(birthday), skills));
                default -> {
                    System.out.println("Повторите попытку!");
                    addAnimalFriend();
                }
            }
        }
        menu();

    }
}
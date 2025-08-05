package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();
        System.out.println("Таблица users создана");

        userService.saveUser("Иван", "Иванов", (byte) 25);
        userService.saveUser("Петр", "Петров", (byte) 30);
        userService.saveUser("Сергей", "Сергеев", (byte) 35);
        userService.saveUser("Алексей", "Алексеев", (byte) 40);

        System.out.println("\nВсе пользователи в базе:");
        userService.getAllUsers().forEach(System.out::println);

        userService.cleanUsersTable();
        System.out.println("\nТаблица users очищена");

        userService.dropUsersTable();
        System.out.println("Таблица users удалена");
    }
}
package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/new?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    // Приватный конструктор, чтобы предотвратить создание экземпляров
    public Util() {
        // Пустой конструктор
    }

    // Получение соединения с базой данных
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Успешное подключение к базе данных");
        } catch (ClassNotFoundException e) {
            System.out.println("Не найден класс драйвера: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных: " + e.getMessage());
        }
        return connection;
    }

    // Закрытие соединения
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Соединение закрыто");
            } catch (SQLException e) {
                System.out.println("Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
    }
}
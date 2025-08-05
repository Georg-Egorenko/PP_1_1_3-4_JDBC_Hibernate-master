package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();

            // Базовые настройки подключения
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydb?useSSL=false")
                    .setProperty("hibernate.connection.username", "Georg")
                    .setProperty("hibernate.connection.password", "Georg")
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

            /*****************************************************************
             * КОГДА У ВАС ПОЯВЯТСЯ КЛАССЫ СУЩНОСТЕЙ (User и др.):
             *
             * 1. Раскомментируйте строку ниже
             * 2. Замените User.class на ваш класс сущности
             * 3. Добавьте дополнительные классы через запятую
             *
             * Пример:
             * configuration.addAnnotatedClass(User.class)
             *              .addAnnotatedClass(Product.class);
             *****************************************************************/
            // configuration.addAnnotatedClass(User.class);

            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Ошибка при создании SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
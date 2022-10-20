package com.artech.workerslogin.core.query;

import java.sql.*;

/**
 * Дескриптор базы данных
 */
public final class DatabaseHandle {
    /**
     * Путь к базе данных
     */
    private final String url;
    private final String user;
    private final String password;
    /**
     * Подключение к базе данных
     */
    private Connection connection;

    /**
     * Констурктор дескриптора
     * @param url Путь к БД
     */
    public DatabaseHandle(String url, String user, String password) throws SQLException, ClassNotFoundException {
        this.url = url;
        this.user = user;
        this.password = password;
        connect();
    }

    /**
     * Подключает дескриптор к БД
     */
    private void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(this.url+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", this.user, this.password);
    }

    /**
     * отключает дескриптор от Бд
     */
    public void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException exception) {
            System.err.println(exception.getMessage());
        }
    }

    /**
     * Создает запрос БД
     * @param query Запрос
     * @return Prepared-запрос к БД
     */
    public PreparedStatement buildStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }
}
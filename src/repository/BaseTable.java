package repository;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseTable implements Closeable {
    static Connection connection;  // JDBC-соединение для работы с таблицей

    //Активизация соединения с СУБД, если оно не активно.
    static void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = Database.getConnection();
        }
    }

    // Закрытие
    public void close() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка закрытия SQL соединения!");
        }
    }

    // Выполнить SQL команду для изменения СУБД
    static void modifyDatabase(String sql) throws SQLException {
        reopenConnection();             // переоткрываем (если оно неактивно) соединение с СУБД
        Statement statement = connection.createStatement(); // Создаем statement для выполнения sql-команд
        statement.executeUpdate(sql);   // Выполняем statement - sql команду
        statement.close();              // Закрываем statement для фиксации изменений в СУБД
    }

    static ResultSet getDataSQL(String sql) throws  SQLException{
        reopenConnection();             // переоткрываем (если оно неактивно) соединение с СУБД
        Statement statement = connection.createStatement();  // Создаем statement для выполнения sql-команд
        ResultSet resultSet = statement.executeQuery(sql);    // Выполняем statement - sql команду
        //statement.close();              // Закрываем statement для фиксации изменений в СУБД
        return  resultSet;
    }
}




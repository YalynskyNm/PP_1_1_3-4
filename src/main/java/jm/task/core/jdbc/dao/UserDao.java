package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age) throws SQLException;

    void removeUserById(long id) throws SQLException;

    List<User> getAllUsers();

    void cleanUsersTable();

    default void printSQLException(SQLException ex) {
        for (Throwable e: ex){
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState"+((SQLException)e).getSQLState());
                System.err.println("Error Code"+((SQLException)e).getErrorCode());
                System.err.println("message" + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null){
                    System.out.println("cause"+t);
                    t=t.getCause();
                }
            }
        }
    }
}

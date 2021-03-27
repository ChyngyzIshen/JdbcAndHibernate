package peaksoft.dao;

import peaksoft.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static peaksoft.util.Util.connect;

public class UserDaoJdbcImpl implements UserDao {


    public UserDaoJdbcImpl() { }

    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS users(id SERIAL PRIMARY KEY, name VARCHAR (255) NOT NULL, lastName VARCHAR(255) NOT NULL, age INT NOT NULL)";
        try (Connection conn = connect();
             Statement statement = conn.createStatement()){
             statement.executeUpdate(SQL);
            System.out.println("Table created successfully!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void dropUsersTable() {
        String SQL = "DROP TABLE IF EXISTS users";
        try (Connection conn = connect();
             Statement statement = conn.createStatement()){
            statement.executeUpdate(SQL);
            System.out.println("Table deleted successfully!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3,  age);
            statement.executeUpdate();
            System.out.println(name + " " + lastName + " successfully added!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void removeUserById(long id) {
        String SQL = "DELETE FROM users WHERE id = ?";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQL)){
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println("User id#" + id + " deleted successfully!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String SQL = "SELECT * FROM users";
        try (Connection conn = connect();
             Statement statement = conn.createStatement()){
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next()){
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                byte age = rs.getByte("age");
                users.add(new User(name, lastName, age));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        users.forEach(System.out::println);
        return users;
    }

    public void cleanUsersTable() {
        String SQL = "TRUNCATE TABLE ONLY users";
        try (Connection conn = connect();
             Statement statement = conn.createStatement()){
            statement.executeUpdate(SQL);
            System.out.println("Table cleaned successfully!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
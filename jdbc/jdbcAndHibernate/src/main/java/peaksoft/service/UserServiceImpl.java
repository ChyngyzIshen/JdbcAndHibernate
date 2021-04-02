package peaksoft.service;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;



public class UserServiceImpl implements UserService {

    UserDaoJdbcImpl jdbc = new UserDaoJdbcImpl();
    UserDaoHibernateImpl hibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {

        //jdbc.createUsersTable();
        hibernate.createUsersTable();
    }

    public void dropUsersTable() {

        //jdbc.dropUsersTable();
        hibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {

        //jdbc.saveUser(name, lastName, age);
        hibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {

        //jdbc.removeUserById(id);
        hibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {

        //return jdbc.getAllUsers();
        return hibernate.getAllUsers();
    }

    public void cleanUsersTable() {

        //jdbc.cleanUsersTable();
        hibernate.cleanUsersTable();
    }
}

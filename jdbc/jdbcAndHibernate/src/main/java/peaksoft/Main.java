package peaksoft;

import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
       
//         userService.createUsersTable();
//        userService.saveUser("Chyngyz", "Sharshekeev", (byte) 34);
//        userService.saveUser("Asan", "Usonov", (byte) 30);
//        userService.saveUser("John", "Doe", (byte) 20);
//        userService.saveUser("Natali", "Portman", (byte) 25);
//        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();



        UserServiceImpl hibernate = new UserServiceImpl();
//        hibernate.createUsersTable();

//        hibernate.saveUser("Chyngyz", "Sharshekeev", (byte) 34);
//        hibernate.saveUser("Asan", "Usonov", (byte) 30);
//        hibernate.saveUser("John", "Doe", (byte) 20);
//        hibernate.saveUser("Natali", "Portman", (byte) 25);
//
//        hibernate.removeUserById(2);
//        hibernate.getAllUsers();
//        hibernate.createUsersTable();
        hibernate.dropUsersTable();


        Util.shutDown();
    }
}

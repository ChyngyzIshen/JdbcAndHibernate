package peaksoft;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.service.UserServiceImpl;
import peaksoft.util.Util;

public class Main {
    public static void main(String[] args) {
//        Util util = new Util();
//        util.connect();

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Chyngyz", "Sharshekeev", (byte) 34);
        userService.saveUser("Asan", "Usonov", (byte) 30);
        userService.saveUser("John", "Doe", (byte) 20);
        userService.saveUser("Natali", "Portman", (byte) 25);
        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();


//        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
//        userDaoJdbc.getAllUsers();


    }
}

package peaksoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.List;

import static peaksoft.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        try {
            Session session = getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users (" +
                    "id serial primary key, " +
                    "name varchar(255) not null, " +
                    "lastName varchar(255) not null, " +
                    "age int not null)").executeUpdate();
            System.out.println("Table successfully created!!!");


            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try {
            Session session = getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("DROP TABLE IF EXISTS User");
            query.executeUpdate();
            System.out.println("Table successfully deleted!!!");


            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try {
            Session session = getSessionFactory().openSession();
            transaction = session.beginTransaction();

            User users = new User();
            users.setName(name);
            users.setLastName(lastName);
            users.setAge(age);
            session.persist(users);
            System.out.println("User " + name + " " + lastName + " successfully added!!!");

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try {
            Session session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            User user1 = (User) session.get(User.class, id);
            if (user1 != null) {
                session.delete(user1);
                System.out.println("User 1 " + user1 + " " + "successfully deleted!!!");
            }
            User user2 = new User();
            user2.setId(2);
            session.delete(user2);
            System.out.println("User 2 " + user2 + " " + "successfully deleted!!!");

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        Transaction transaction = null;
        List<User> users = null;
        try {
            Session session = getSessionFactory().openSession();
            transaction = session.beginTransaction();

            users = session.createQuery("FROM User").list();
            for (User user : users) {
                System.out.println("Founded " + user);

                transaction.commit();
                session.close();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try {
            Session session = getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("DELETE FROM User");
            query.executeUpdate();
            System.out.println("Users table successfully cleaned!!!");

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }
    }

}

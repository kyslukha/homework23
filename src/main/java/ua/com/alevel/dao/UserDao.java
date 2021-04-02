package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.util.HibernateSessionFactoryUtil;
import ua.com.alevel.model.User;

import java.util.List;


public class UserDao {

    private  static SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public static void createUser(User newUser) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(newUser);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUserExisting(String userMail) {
        List<User> users = getAllUsers();
        boolean flag = false;
        for (User user : users) {
            if (user.getEmail().equals(userMail)) {
                flag=true;
            }
        }
        return flag;
    }

    public static List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<User> query = session.createQuery(" FROM  User ", User.class);
            List<User> resultList = query.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }


    public static void showUser() {
        List<User> categoryList = getAllUsers();
        for (User user : categoryList) {
            System.out.println("\n" + user + "\n");
        }
    }

    public  static void deleteUser(Integer id){
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE user_id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public  static void updateUser(int userId, String updateName, String updateLastName,
            String updateAddress, String updateMail) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Query query = session.createQuery("UPDATE User SET first_name =: newName, last_name =: newLastName," +
                    " address =: newAddress, email =: newMail WHERE user_id =: userId");
            if(!checkUserExisting(updateMail)) {
                query.setParameter("userId", userId);
                query.setParameter("newLastName",updateLastName);
                query.setParameter("newName", updateName);
                query.setParameter("newAddress", updateAddress);
                query.setParameter("newMail", updateMail);
                int rows = query.executeUpdate();
                session.getTransaction().commit();
                if(rows > 0){
                    System.out.println("User is successfully updated");
                }
            }else {
                System.out.println("User with same mail is already Exists");
            }
        }
    }



}

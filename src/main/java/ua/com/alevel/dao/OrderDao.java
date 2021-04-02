package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.model.Category;
import ua.com.alevel.model.Order;
import ua.com.alevel.model.Product;
import ua.com.alevel.model.User;
import ua.com.alevel.util.HibernateSessionFactoryUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class OrderDao {

    private static SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();


    public static void createOrder(String productName, String email, String order_status) {
        Product product = null;
        User user =  null;
        if(productExisting(productName)){
            product = getProductIdByName(productName);
        }else{
            System.out.println("There is no product with same name.");
        }

        if(userExisting(email)){
            user = getUserIdByMail(email);
        }else {
            System.out.println("There is no user with same mail.");
        }
        LocalDate date = LocalDate.now();
        Date dataToSet = Date.valueOf(date);
        Order order = new Order(product,user,dataToSet,order_status);
        {
            try(Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.save(order);
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static boolean userExisting(String mail) {
        List<User> users = UserDao.getAllUsers();
        for (User user : users) {
            if (mail.equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }
    public static User getUserIdByMail(String mail) {
        List<User> users = UserDao.getAllUsers();
        for (User user : users) {
            if (mail.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }
    public static boolean productExisting(String name){
        List<Product> list = ProductDao.getAllProducts();
        for(Product product : list){
            if(name.equals(product.getProductName())){
                return true;
            }
        }
        return false;
    }

    public static Product getProductIdByName(String name){
        List<Product> list = ProductDao.getAllProducts();
        for(Product product : list){
            if(name.equals(product.getProductName())){
                return product;
            }
        }
        return null;
    }

    public static List<Order> getAllOrders() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Order> query = session.createQuery("  FROM  orders ", Order.class);
            List<Order> resultList = query.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }


    public static void showOrders() {
        List<Order> categoryList = getAllOrders();
        for (Order order : categoryList) {
            System.out.println("\n" + order + "\n");
        }
    }
}

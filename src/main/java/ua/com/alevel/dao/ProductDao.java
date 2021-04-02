package ua.com.alevel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.model.Category;
import ua.com.alevel.util.HibernateSessionFactoryUtil;
import ua.com.alevel.model.Product;
import ua.com.alevel.helpers.HelperCategory;

import java.util.List;


public class ProductDao {
    private static SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();



    public static void createProduct(Product product){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void updateProduct(int productId, String newName, Integer newPrice, String categoryName) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Query query = session.createQuery("UPDATE Product SET product_name =: newName, price =:newPrice," +
                    " category_id =: category WHERE Id =: id");
            if(ua.com.alevel.dao.CategoryDao.checkCategoryExisting(categoryName)) {
                query.setParameter("id", productId);
                query.setParameter("newName",newName);
                query.setParameter("newPrice", newPrice);
                query.setParameter("category", categoryName);
                int rows = query.executeUpdate();
                session.getTransaction().commit();
                if(rows > 0){
                    System.out.println("Product is successfully updated");
                }
            }else if(!ua.com.alevel.dao.CategoryDao.checkCategoryExisting(categoryName)){
                ua.com.alevel.dao.CategoryDao.categoryCreation(HelperCategory.createCategoryModelWithName(categoryName));
                query.setParameter("id", productId);
                query.setParameter("newName",newName);
                query.setParameter("newPrice", newPrice);
                query.setParameter("category",categoryName);
                query.executeUpdate();
                session.getTransaction().commit();

                System.out.println("Product is successfully updated");


            }
        }
    }

    public static void deleteProductWithCategory(String name){
        try (Session session = sessionFactory.openSession()) {
            ua.com.alevel.dao.CategoryDao categoryDao = new ua.com.alevel.dao.CategoryDao();
            List<Category> categoryList = categoryDao.getAllCategories();
            Category idToDelete = null;
            for (Category category : categoryList) {
                if (category.getCategoryName().equals(name)) {
                    idToDelete = category;
                }
            }
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Product WHERE category_id =: idToDelete");
            query.setParameter("idToDelete", idToDelete);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public static void deleteProduct(Integer id){
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Product WHERE product_id =: id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    public  static List<Product> getAllProducts() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Product> query = session.createQuery("  FROM  products ", Product.class);
            List<Product> resultList = query.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }

    public static List<Product> getProductsByCategoryName(String name) {
        try (Session session = sessionFactory.openSession()) {
            ua.com.alevel.dao.CategoryDao categoryDao = new ua.com.alevel.dao.CategoryDao();
            List<Category> categoryList = categoryDao.getAllCategories();
            Integer id = null;
            for (Category category : categoryList) {
                if (category.getCategoryName().equals(name)) {
                    id = category.getCategoryId();
                }
            }
            session.beginTransaction();
            Query<Product> query = session.createQuery("  FROM  Product WHERE category_id =: id", Product.class);
            query.setParameter("id", id);
            List<Product> resultList = query.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }

    public static void showProducts(){
        List<Product> productList = getAllProducts();
        for(Product product : productList){
            System.out.println(product + "\n");
        }
    }

}

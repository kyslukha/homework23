package ua.com.alevel.helpers;

import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.dao.ProductDao;
import ua.com.alevel.model.Category;
import ua.com.alevel.model.Product;

import java.util.List;
import java.util.Scanner;

public class HelperProduct {

    private static final String messageToCreateName = "Enter the Product name to create";
    private static final String messageToDelete = "Enter the Product's id to delete";
    private static final String messageToUpdateName = "Enter the new Product`s name to update";
    private static final String messageToUpdatePrice = "Enter the new Product`s price to update";
    private static final String messageToUpdateCategoryName = "Enter the new Product`s category name to update";
    private static final String messageToGetId = "Enter Product's id to update it";
private static final String messageToCreateCategoryName = "Enter category of product";

    public static Product createProductModel(String name, Integer price, String categoryName) {
        Product product = new Product();
        if(CategoryDao.checkCategoryExisting(categoryName)) {
            product.setProductName(name);
            product.setPrice(price);
            Category categoryToSet = checkCategoryToCreateProduct(categoryName);
            product.setCategoryId(categoryToSet);
            return product;
        }else if(!CategoryDao.checkCategoryExisting(categoryName)){
            product.setProductName(name);
            product.setPrice(price);
            product.setCategoryId(HelperCategory.createCategoryModelWithName(categoryName));
        }
        return product;
    }

    public static Category checkCategoryToCreateProduct(String categoryName) {
        List<Category> categoryList = CategoryDao.getAllCategories();
        Category categoryToSet = null;
        for (Category category : categoryList) {
            if (category.getCategoryName().equals(categoryName)) {
                return categoryToSet = category;
            }
        }
        return categoryToSet;
    }

    private static String getNameProductString(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }


    public static String suggestProductMethod() {
        System.out.println("Here you can Create, Read, Update and Delete Products or or enter Back to return to the main menu");
        System.out.println("Enter the method you wanna do.");
        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        return method;
    }

    public static void methodsProduct(String method){
        if(method.equals("Read")){
            ProductDao.showProducts();
            methodsProduct(suggestProductMethod());
        }else if(method.equals("Update")){
            Integer idToUpdate = getProductInteger(messageToGetId);
            String newName = getNameProductString(messageToUpdateName);
            Integer newPrice = getProductInteger(messageToUpdatePrice);
            String categoryName = getNameProductString(messageToUpdateCategoryName);
            ProductDao.updateProduct(idToUpdate,newName,newPrice,categoryName);
            methodsProduct(suggestProductMethod());
        }else if(method.equals("Create")){
            String newName = getNameProductString(messageToCreateName);
            Integer newPrice = getProductInteger(messageToUpdatePrice);
            String categoryName = getNameProductString(messageToCreateCategoryName);
            ProductDao.createProduct(createProductModel(newName,newPrice,categoryName));
            methodsProduct(suggestProductMethod());
        }else if(method.equals("Delete")){
            Integer idToUpdate = getProductInteger(messageToDelete);
            ProductDao.deleteProduct(idToUpdate);
            methodsProduct(suggestProductMethod());
        }else if(method.equals("Back")){
            HelperApp.methodsApp(HelperApp.appSuggestion());
        }
    }

    private static Integer getProductInteger(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        return id;
    }
}

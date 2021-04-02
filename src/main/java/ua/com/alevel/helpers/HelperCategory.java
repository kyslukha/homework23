package ua.com.alevel.helpers;

import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.model.Category;

import java.sql.Connection;
import java.util.Scanner;

public class HelperCategory {
    private static final String messageToCreate = "Enter the Category name to create";
    private static final String messageToDelete = "Enter the Category name to delete";
    private static final String messageToUpdate = "Enter the new Category name to update";
    private static final String messageToGetId = "Enter Category id to update it";

    public static Category createCategoryModel(){
        String categoryName = getNameCategory(messageToCreate);
        Category category = new Category();
        category.setCategoryName(categoryName);
        return category;
    }
    public static Category createCategoryModelWithName(String categoryName){
        Category category = new Category();
        category.setCategoryName(categoryName);
        return category;
    }

    private static String getNameCategory(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }


    public static String suggestCategoryMethod() {
        System.out.println("Here you can Create, Read, Update and Delete Categories or enter Back to return to the main menu");
        System.out.println("Enter the method you wanna do.");
        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        return method;
    }

    public static void methodsCategory(String method){
        if(method.equals("Read")){
            CategoryDao.showCategories();
            methodsCategory(suggestCategoryMethod());
        }else if(method.equals("Update")){
            Integer idToUpdate = getIdToUpdate(messageToGetId);
            String newName = getNameCategory(messageToUpdate);
            CategoryDao.updateCategory(idToUpdate,newName);
            methodsCategory(suggestCategoryMethod());
        }else if(method.equals("Create")){
            String message = "The category is already exist";
            Category category = createCategoryModel();
            CategoryDao.createCategory(category.getCategoryName(),category,message);
            methodsCategory(suggestCategoryMethod());
        }else if(method.equals("Delete")){
            String categoryToDelete = getNameCategory(messageToDelete);
            CategoryDao.deleteCategory(categoryToDelete);
            methodsCategory(suggestCategoryMethod());
        }else if(method.equals("Back")){
            HelperApp.methodsApp(HelperApp.appSuggestion());
        }
    }

    private static Integer getIdToUpdate(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        return id;
    }

}

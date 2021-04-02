package ua.com.alevel.helpers;


import ua.com.alevel.dao.UserDao;
import ua.com.alevel.model.User;

import java.util.Scanner;

public class HelperUser {


    public static String suggestUserMethod() {
        System.out.println("Here you can Create, Read, Update and Delete Users or press Back to return to the menu");
        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        return method;
    }

    public static void methodsUser(String method){
        if(method.equals("Read")){
            UserDao.showUser();
            methodsUser(suggestUserMethod());
        }else if(method.equals("Update")){
            System.out.println( "Enter User's id to update");
            Integer userIdUpdate = getUserInteger();
            System.out.println("Enter the User's name to update");
            String updateName = getUserString();
            System.out.println("Enter the User's lastname to update");
            String updateLastName = getUserString();
            System.out.println("Enter the User's address to update");
            String updateAddress = getUserString();
            System.out.println("Enter the User's mail to update");
            String updateMail = getUserString();
            UserDao.updateUser(userIdUpdate,updateName,updateLastName,updateAddress,updateMail);
            methodsUser(suggestUserMethod());
        }else if(method.equals("Create")){
            System.out.println("Enter new the User's name");
            String newName = getUserString();
            System.out.println("Enter the User's lastname");
            String newLastName = getUserString();
            System.out.println("Enter the User's mail ");
            String newMail = getUserString();
            System.out.println("Enter the User's address");
            String newAddress = getUserString();
            User user = new User();
            user.setName(newName);
            user.setLast_name(newLastName);
            user.setEmail(newMail);
            user.setAddress(newAddress);
            UserDao.createUser(user);;
            methodsUser(suggestUserMethod());
        }else if(method.equals("Delete")){
            System.out.println("Enter the User's id to delete");
            Integer userDelete = getUserInteger();
            UserDao.deleteUser(userDelete);
            methodsUser(suggestUserMethod());
        }else if(method.equals("Back")){
            HelperApp.methodsApp(HelperApp.appSuggestion());
        }
    }


    private static String getUserString() {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }

    private static Integer getUserInteger() {

        Scanner scanner = new Scanner(System.in);
        Integer integer = scanner.nextInt();
        return integer;
    }
}

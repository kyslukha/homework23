package ua.com.alevel.helpers;

import ua.com.alevel.dao.OrderDao;

import java.util.Scanner;

public class HelperOrder {
    public static String suggestOrderMethod() {
        System.out.println("Here you can Create, Read Orders or press Back to return to the main menu");
        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        return method;
    }

    public static void methodsOrders(String method){
        if(method.equals("Read")){
            OrderDao.showOrders();
            methodsOrders(suggestOrderMethod());
        }else if(method.equals("Create")){
            System.out.println("Enter the product Name to create an order");
            String productNameOrder = getOrder();
            System.out.println("Enter your Mail to create an order");
            String mailOrder = getOrder();
            System.out.println("Enter order status to order");
            String status = getOrder();
            OrderDao.createOrder(productNameOrder,mailOrder, status);
            methodsOrders(suggestOrderMethod());
        }else if(method.equals("Back")){
            HelperApp.methodsApp(HelperApp.appSuggestion());
        }
    }

    private static String getOrder() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }
}

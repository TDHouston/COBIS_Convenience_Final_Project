package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        // Building the Products Array List
        ArrayList<Products> products = new ArrayList<Products>();

        Products prod1 = new Products();
        Products prod2 = new Products();
        Products prod3 = new Products();
        Products prod4 = new Products();
        Products prod5 = new Products();
        Products prod6 = new Products();
        Products prod7 = new Products();
        Products prod8 = new Products();
        Products prod9 = new Products();
        Products prod10 = new Products();

        prod1.setProd("Red-Hot Spicy Doritos");
        prod1.setPrice(2.99);
        products.add(prod1);

        prod2.setProd("Cool Ranch Doritos");
        prod2.setPrice(2.99);
        products.add(prod2);

        prod3.setProd("Coke");
        prod3.setPrice(0.99);
        products.add(prod3);

        prod4.setProd("Diet Coke");
        prod4.setPrice(0.99);
        products.add(prod4);

        prod5.setProd("Pepsi");
        prod5.setPrice(0.99);
        products.add(prod5);

        prod6.setProd("Five Hour Energy");
        prod6.setPrice(3.99);
        products.add(prod6);

        prod7.setProd("Sunflower Seeds");
        prod7.setPrice(0.99);
        products.add(prod7);

        prod8.setProd("Peanuts");
        prod8.setPrice(0.99);
        products.add(prod8);

        prod9.setProd("Macbook Charger");
        prod9.setPrice(120.00);
        products.add(prod9);

        prod10.setProd("Dell Charger");
        prod10.setPrice(50.00);
        products.add(prod10);

        // Prompting User input, displaying the product from array and price

        String answer = "";
        ArrayList<Products> purchases= new ArrayList<Products>();
        ArrayList<Receipt> receipts = new ArrayList<Receipt>();
        String neworder = "";

        do {
            System.out.println("Start New Order? : 1) Yes or 2) No");
            neworder = keyboard.nextLine();

            if (neworder.equals("1")) {
                // Prompting Name
                System.out.println("What is your name? : ");
                String name = keyboard.nextLine();

                //Creating a new receipt and adding it to the receipts list
                Receipt customerreceipt = new Receipt();
                customerreceipt.setCustomername(name);
                receipts.add(customerreceipt);

                double total = 0;

                do {

                    // Prompting purchase choices
                    System.out.println("What do you want to do?");
                    System.out.println("1) add purchase 2) change purchase 3) show purchase(s) 4) finish transaction");
                    answer = keyboard.nextLine();

                    // looping customer items that match the array list
                    if (answer.equals("1")) {
                        System.out.println("What do you wish to buy?");
                        answer = keyboard.nextLine();
                        Products newprod = new Products();
                        newprod.setProd(answer);
                        purchases.add(newprod);
                        for (int i = 0; i < products.size(); i++) {
                            if (answer.equals(products.get(i).getProd())) {
                                System.out.println("Product: " + products.get(i).getProd() + " | Price: " + products.get(i).getPrice());
                                customerreceipt.addCustomerprods(products.get(i));
                                total += products.get(i).getPrice();
                                System.out.println(total);
                                customerreceipt.setReceipttotal(total);
                            }
                        }
                    }
                    if (answer.equals("2")) {
                        System.out.println("What do you wish to change? Enter the name of the item.");
                        for (int i = 0; i < purchases.size(); i++) {
                            System.out.println(purchases.get(i).getProd());
                        }
                        answer = keyboard.nextLine();
                        System.out.println("What would you like to change it to? Enter the name of the item.");
                        String exchange = keyboard.nextLine();

                        for (int i = 0; i < purchases.size(); i++) {
                            if (answer.equals(purchases.get(i).getProd())) {
                                purchases.get(i).setProd(exchange);
                            }
                        }
                    }
                    if (answer.equals("3")) {
                        System.out.println("Which purchase would you like to see?");
                        for (int i = 0; i < purchases.size(); i++) {
                            System.out.println(purchases.get(i).getProd());
                        }
                        answer = keyboard.nextLine();
                        for (int i = 0; i < products.size(); i++) {
                            if (answer.equals(products.get(i).getProd())) {
                                System.out.println("Product: " + products.get(i).getProd() + " | Price: " + products.get(i).getPrice());
                            }
                        }
                    }
                } while(! answer.equals("4"));
            }
        } while (! neworder.equals("2"));

        // looping through receipts and retrieving customer name
        for (int i = 0; i < receipts.size(); i++) {
            System.out.println("Name: " + receipts.get(i).getCustomername());
            // retrieving products in receipt
            for (int j = 0; j < receipts.get(i).getCustomerprods().size(); j++) {
                System.out.println(receipts.get(i).getCustomerprods().get(j).getProd());
            }
            // Retrieving total price for the receipt
            System.out.println("Total: " + receipts.get(i).getReceipttotal());
        }
        double grandtotal = 0;
        for (int i = 0; i < receipts.size(); i++) {
            // Retrieving Grand total price
            grandtotal += receipts.get(i).getReceipttotal();
        }
        System.out.println("Grand Total: " + grandtotal);
    }
}

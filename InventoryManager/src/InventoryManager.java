/*
 *  Assignment: Assignment 5
 *  Description: This program uses arrays for an inventory manager in Java.
 *  Name: James Giatpaiboon
 *  ID: 917848716
 *  Class: CSC 210-01
 *  Semester: Fall 2019
 */

import java.util.Arrays;    // used for sorting arrays
import java.util.Scanner;   // used for scanner-input

public class InventoryManager { //public cass for Inventory Manager - anyone can access
    public static void main (String[] args) {
        final String STORE_NAME = "The Shop";   // Stored store name into a variable, name cannot be changed
        String [] items = new String [5];   // declared an array of 5 string items
        //items given for each array value from assignment page
        items[0] = "onion";
        items[1] = "broccoli";
        items[2] = "carrot";
        items[3] = "zucchini";
        items[4] = "cucumber";

        int [] quantities = new int [5];    // declared an integer variable for number of quantities (5)
        double [] prices = new double [5];  // declared a double variable for array of prices (5)

        Scanner input = new Scanner(System.in); // imported for user input
        // Welcome message for the user
        System.out.println("Welcome to the " + STORE_NAME);
        System.out.println("You are now using The Shop's Inventory Manager.");


        //prompts user to enter the number of quantity and price for each of the items
        System.out.println("Please enter the number of quantity for each of the items: ");
        for(int i = 0; i < quantities.length; i++) {    // for loop to allow user to enter 5 numbers for quantity
            quantities [i] = input.nextInt();   // stores quantity for each arrays
        }
        System.out.println("Enter the prices of each item: ");
        for(double i = 0; i < prices.length; i++) { // for loop to allow user to enter 5 numbers for prices
            prices [(int) i] = input.nextDouble();  // stores price for each of the arrays
        }


        int action = 0; // integer variable for the action that user chooses
        while (action != 5) {   // unless option 5 is chosen, this option menu will be displayed for the user
            //Prompts user to choose an option of what they would like to perform in the program
            System.out.println("What would you like to do?");
            System.out.println("1. Print inventory");
            System.out.println("2. Check for low inventory");
            System.out.println("3. Highest and lowest inventory items");
            System.out.println("4. Total inventory value");
            System.out.println("5. Exit program");
            action = input.nextInt();   // takes the number of action the user would like to perform
            // if-else statements depending on what action the user takes
            if (action == 1) {  // action 1 displays the item name, quantity, price, and total value
                for (int i = 0; i < items.length; i++) {    // for-loop for all the items in the array to be displayed
                    System.out.println("Item: " + items[i]);
                    System.out.println("Quantity: " + quantities[i]);
                    System.out.println("Price: " + "$" + prices[i]);
                    System.out.println("Total value: " + "$" + quantities[i] * prices[i]);
                }
            } else {
                if (action == 2) {  // action 2 displays the items that low on inventory
                    for (int i = 0; i < quantities.length; i++) {   // for loop to check all the items in the array and see if they are low
                        if (quantities[i] < 5) {    // if quantity is low, the following print line statements will be shown for the user:
                            System.out.println("Low on inventory: ");
                            System.out.println("Item: " + items[i]);
                            System.out.println("Quantity: " + quantities[i]);
                            System.out.println("Price: " + "$" + prices[i]);
                            System.out.println("Total value: " + "$" + quantities[i] * prices[i]);
                        }
                    }   // if none of the items are low on inventory, the following print line statement is shown
                    if ((quantities[0] > 5) & (quantities[1] > 5) & (quantities[2] > 5) & (quantities[3] > 5) & (quantities[4] > 5)) {
                        System.out.println("No items are low on inventory."); }
                } else {
                    if (action == 3) {  //action 3 displays the highest and lowest values in the inventory
                        double [] inventoryValue = new double[5];   // array for inventory values to be stored
                        for(int j = 0; j < inventoryValue.length; j++) {    // for loop to get inventory values of each item in the array
                            inventoryValue[j] = quantities[j] * prices[j];  // gets the inventory value by multiplying price by quantity
                        }
                        Arrays.sort(inventoryValue);    // sorts the inventory values from lowest to highest - lowest being array[0] and highest[4]
                        // prints out results for the user to see when choosing option 3
                        System.out.println("Highest value: " + "$" + inventoryValue[4]);
                        System.out.println("Item: " + items[4]);
                        System.out.println("Quantity: " + quantities[4]);
                        System.out.println("Price: " + "$" + prices[4]);

                        System.out.println("Lowest Value: " + "$" + inventoryValue[0]);
                        System.out.println("Item: " + items[0]);
                        System.out.println("Quantity: " + quantities[0]);
                        System.out.println("Price: " + "$" + prices[0]);
                    } else {
                        if (action == 4) {  // action 4 displays the total inventory value for the user
                            double [] inventoryValue = new double[5];   // array for the inventory values of all items
                            double totalInventory = 0;  // final total inventory value declared
                            for (int i = 0; i < quantities.length; i++) {   // for loop to get all the quantities values
                                inventoryValue[i] = quantities[i] * prices[i];  // gets the inventory value by multiplying price by quantity
                                totalInventory += inventoryValue[i];    // adds up all the inventory values to get the total of whole system
                            }
                            System.out.println("Total inventory value: " + "$" + totalInventory);   // prints out total inventory for user
                        } else {
                            if (action == 5) {  // action 5 exits the program and stops the loop
                                System.out.println("Thank you for using The Shop!");    //ending salutation
                            }
                        }
                    }
                }
            }
        }
    }
}

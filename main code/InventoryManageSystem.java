import java.util.ArrayList;
import java.util.Scanner;

class Product{
    private String ProductName;
    private double ProductPrice;

    public Product(String productName, double productPrice) {
        this.ProductName = productName;
        this.ProductPrice = productPrice;
    }

    //setter methods
    public void setName(String name){
        this.ProductName = name;
    }
    public void setPrice(double price){
        this.ProductPrice = price;
    }
    //getter methods
    public String getProductName() {
        return ProductName;
    }
    public double getProductPrice() {
        return ProductPrice;
    }
}

abstract class Users{
    private String Name;
    private String ID;

    public Users(String Name, String ID) {
        this.Name = Name;
        this.ID = ID;
    }

    //getter methods
    public String getName() {
        return Name;
    }
    public String getID() {
        return ID;
    }

    //admin and customer both share method to display products list
    public void ViewProducts(ArrayList<Product> products){

        //if no product in arraylist print no product
        if(products.size() == 0){
            System.out.println("No products available."+"\n");
        }

        //else print the item
        else{
        System.out.println("Product list: ");
        for(int i=0; i<products.size(); i++){
            System.out.printf((i+1) + ". " + products.get(i).getProductName() + " - RM %.2f%n",products.get(i).getProductPrice());
            }
            System.out.println("\n");
        }
    }
}

class Admin extends Users{
//Constructor
public Admin(String name, String ID){
   super(name,ID);
   }
   
//Method to add product
public void AddItem(ArrayList<Product> products, Scanner sc){
   
   System.out.print("Enter Product Name: ");
   String name = sc.nextLine();

while (true) {

   try{
   System.out.print("Enter Product Price: RM");
   double price = sc.nextDouble();
   sc.nextLine();

    if(price<=0){
         System.out.println("Price cannot be zero and negative, enter again"+"\n");
         continue;
    }

    //add new product into array
   products.add(new Product(name, price));

   System.out.println("Product Have Been Added Successfully!!"+"\n");
   break;
   }
   catch(Exception e){
   System.out.println("Unvailable value, enter again"+"\n");
   sc.nextLine();
   continue;
   }
    }
}
   
//Method to delete product
public void DeleteItem(ArrayList<Product> products, Scanner sc) {

    if(products.size()==0){
        System.out.println("No products available."+"\n");
    }
    else{
    while (true) {
    //display product list for user
    ViewProducts(products);

    try{
    System.out.print("Choose the product (1,2,3....) to delete: ");
    int position=sc.nextInt();
    sc.nextLine();

    if(position<1 || position>products.size()){
        System.out.println("Unvailable product selected, enter again"+"\n");
        continue;
    }

    //remove product at selected position from array
    products.remove(position-1);

    System.out.println("The product delete successfully"+"\n");
    break;
    }

    catch(Exception E){
        System.out.println("Unvailable value, enter again"+"\n");
        sc.nextLine();
        continue;
    }
 }
}
}

public void ManageItem(ArrayList<Product> products,Scanner sc){
        if(products.size()==0){
             System.out.println("No products available."+"\n");
        }
        else{
        while (true) {
        //show products list every loops
        ViewProducts(products);
        try{
        System.out.print("Select the product to edit: ");
        int edit=sc.nextInt();
        sc.nextLine();
        
        if(edit<1 || edit>products.size()){
            System.out.println("Unvailable product selected"+"\n");
            continue;
        }

        //product.get(edit-1).getProductName means the ProductName at postion(edit-1)of array
        System.out.println("Editing "+products.get(edit-1).getProductName()+"\n");

        System.out.print("Enter the new name for product: ");
        String NewName=sc.nextLine();

        //set the new name to the selected position of array
        products.get(edit-1).setName(NewName);

        System.out.print("Enter the new price for product: RM");
        Double NewPrice=sc.nextDouble();
        sc.nextLine();

        if(NewPrice<=0){
        System.out.println("Price cannot be zero and negative, enter again"+"\n");
        continue;
        }

        //set the new price to the selected position of array
        products.get(edit-1).setPrice(NewPrice);

        System.out.println("Item change successfully"+"\n");
        break;
    }

        catch(Exception E){
            System.out.println("Unvaliable input, try again"+"\n");
            sc.nextLine();
            continue;
        }
        }
    }
    }
}

class Customer extends Users{
    public Customer(String Name, String ID) {
        super(Name, ID);
    }

    public void AddToCart(ArrayList<Product> cart, ArrayList<Product> products,Scanner sc) {
        
        if(products.size() == 0){
            System.out.println("No products available."+"\n");
        }
        else{
        while (true) {
        //show products list every loops
        ViewProducts(products);

        try{
        System.out.print("Select the product to add to cart: ");
        int add=sc.nextInt();
        sc.nextLine();

        if(add<1 || add>products.size()){
            System.out.println("Unvailable product selected"+"\n");
            continue;
        }

        //add selected product into cart array
        cart.add(products.get(add-1));
        System.out.println(products.get(add-1).getProductName() + " added to cart.\n");
        break;
        }
        catch(Exception E){
            System.out.println("Unvaliable input, try again"+"\n");
            sc.nextLine();
            continue;
        }
        }
    }
}

    public void DeleteFromCart(ArrayList<Product> cart,Scanner sc) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.\n");
        }
        else{
        while(true){
        ViewCart(cart);
        try{
        System.out.print("Enter item number to remove from cart: ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index <0 || index > cart.size()) {
            System.out.println("Invalid item number, try again."+"\n");
            continue;
        }
        else{
            System.out.println(cart.get(index - 1).getProductName() + " removed from cart."+"\n");
            cart.remove(index - 1);
            break;
        }
    }
        catch(Exception e){
        System.out.println("Unvaliable input, try again"+"\n");
        sc.nextLine();
        continue;
   }
  }
 }
}

    public void ViewCart(ArrayList<Product> cart) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.\n");
        } else {
            double priceTotal = 0.00;
            System.out.println("\n--- Your Cart ---");
            for (int i = 0; i < cart.size(); i++) {
                System.out.println((i + 1) + ". " + cart.get(i).getProductName());
                priceTotal += cart.get(i).getProductPrice();
            }
            System.out.printf("Total price: RM %.2f%n",priceTotal);
        }
    }
}


public class InventoryManageSystem {
    public static void main(String[] args) {
    ArrayList<Product> products= new ArrayList<>();
    ArrayList<Product> cart= new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    int select=0;
    boolean running = true;

    //start of the program
    while(running){
        System.out.println("******************************************************");
        System.out.println("************** Welcome to Market System **************");
        System.out.println("**************    Enter 1 for admin     **************");
        System.out.println("**************    Enter 2 for customer  **************");
        System.out.println("**************    Enter 0 to quit       **************");
        System.out.println("******************************************************");
       
        //get user input using try catch to prevent invalid input
        try{
            System.out.print("Enter User Type: ");
            select = sc.nextInt();
            sc.nextLine(); // Consume newline
        }
        catch(Exception e){
            System.out.println("Invalid input. Please enter a number.");
            sc.nextLine(); // Clear the invalid input
            continue; // Restart the loop
        }

        //if input is out of range
        if(select<0 || select>2){
            System.out.println("Invalid input. Please enter a valid number."+"\n");
            continue;
        }
        else{
            switch (select) {
                //admin section
                case 1:

                System.out.println("Pls enter the admin password:");
                String passcode = sc.nextLine();

                if(passcode.equals("Admin123")==false){
                System.out.println("Wrong passwod,You are not the admin "+"\n");
                System.out.println("Returning to Main Menu..."+"\n");
                System.out.println("Press Enter to continue..."+"\n");
                sc.nextLine();
                continue;
             }
                System.out.print("Please enter your name: ");
                String adminName = sc.nextLine();

                //keep asking for name until user enter a valid name
                while (adminName.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again." + "\n");
                System.out.print("Please enter your name: ");
                adminName = sc.nextLine();
                }

                System.out.print("Please enter your admin ID: ");
                String adminId = sc.nextLine();

                //keep asking for id until user enter a valid id
                while (adminId.isEmpty()) {
                System.out.println("ID cannot be empty. Please try again." + "\n");
                System.out.print("Please enter your ID: ");
                adminId = sc.nextLine();
                }

                Admin admin = new Admin(adminName, adminId);

                System.out.println("\n");
                System.out.println("Welcome Admin " + admin.getName()+ " with ID: " +admin.getID());
                System.out.println("\n");
                
                boolean adminMenu = true;
                while(adminMenu){
                    int adminChoice = -1;

                    System.out.println("************** Admin Menu **************");
                    System.out.println("1. View Products");
                    System.out.println("2. Add Product");
                    System.out.println("3. Remove Product");
                    System.out.println("4. Edit Product");
                    System.out.println("0. Return to Main Menu");
                    System.out.println("****************************************");

                    //if user input data besides integer return reason
                    try{
                    System.out.print("Enter choice: ");
                    adminChoice = sc.nextInt();
                    sc.nextLine();
                    }

                    catch(Exception e){
                        System.out.println("Unavailable input,please enter a proper number."+"\n");
                        sc.nextLine();
                        continue;
                       }
                    
                    if(adminChoice<0 || adminChoice>4){
                        System.out.println("Invalid section, pls insert again."+"\n");
                        continue;
                    }

                    switch(adminChoice){
                        case 1:
                        admin.ViewProducts(products);
                        //pause the screen until user press enter
                        System.out.println("Press Enter to continue...");
                        sc.nextLine();
                            break;

                        case 2:
                        admin.AddItem(products, sc);
                        System.out.println("Press Enter to continue...");
                        sc.nextLine();
                            break;

                        case 3:
                        admin.DeleteItem(products, sc);
                        System.out.println("Press Enter to continue...");
                        sc.nextLine();
                            break;

                        case 4:
                        admin.ManageItem(products, sc);
                        System.out.println("Press Enter to continue...");
                        sc.nextLine();
                            break;

                        case 0:
                        //while user enter 0 condition of while(adminMenu) turns to false and break the loop for admin menu
                        System.out.println("Returning to Main menu!"+"\n");
                        System.out.println("Press Enter to continue...");
                        sc.nextLine();
                        adminMenu=false;
                            break;

                    }
                }  
                    break;
                
                //customer section
                case 2:
                System.out.print("Please enter your name: ");
                String customerName = sc.nextLine();

                //keep asking for name until user enter a valid name
                while (customerName.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again." + "\n");
                System.out.print("Please enter your name: ");
                customerName = sc.nextLine();
                }

                System.out.print("Please enter your customer ID: ");
                String customerId = sc.nextLine();

                //keep asking for ID until user enter a valid ID
                while (customerId.isEmpty()) {
                System.out.println("Customer ID cannot be empty. Please try again." + "\n");
                System.out.print("Please enter your customer ID: ");
                customerName = sc.nextLine();
                }

                Customer customer = new Customer(customerName, customerId);

                System.out.println("\n");
                System.out.println("Welcome Customer " + customer.getName()+ " with ID: " +customer.getID());
                System.out.println("\n");
                
                boolean customerMenu = true;

                while(customerMenu){
                    int customerChoice = -1;

                    System.out.println("************** Customer Menu **************");
                    System.out.println("1. View Products");
                    System.out.println("2. Add Product to Cart");
                    System.out.println("3. Delete Product from Cart");
                    System.out.println("4. Check Cart");
                    System.out.println("0. Return to Main Menu");
                    System.out.println("*******************************************");

                    //if user input data besides integer return error reason
                    try{
                    System.out.print("Enter choice: ");
                    customerChoice = sc.nextInt();
                    sc.nextLine();
                    }

                    //catch exception for input besides integer
                    catch(Exception e){
                        System.out.println("Unavailable input,please enter a proper number."+"\n");
                        sc.nextLine();
                        continue;
                       }

                    //if user insert num besides 0 to 4 print error message
                    if(customerChoice <0 || customerChoice >4){
                    System.out.println("Invalid section, pls insert again."+"\n");
                    continue;
                    }

                    else{
                    switch (customerChoice) {
                        case 1:
                        //call view products method
                            customer.ViewProducts(products);
                            System.out.println("Press Enter to continue...");
                            sc.nextLine();
                            break;
                        case 2:
                        //call add to cart method
                            customer.AddToCart( cart, products, sc);
                            System.out.println("Press Enter to continue...");
                            sc.nextLine();
                            break;
                        case 3:
                        //call delete from cart method
                            customer.DeleteFromCart(cart, sc);
                            System.out.println("Press Enter to continue...");
                            sc.nextLine();
                            break;
                        case 4:
                        //call view cart method
                            customer.ViewCart(cart);
                            System.out.println("Press Enter to continue...");
                            sc.nextLine();
                            break;
                        case 0:
                        //while user enter 0, condition of while(customerRunning) turns to false and break the loop for customer menu
                        System.out.println("Returning to Main Menu..."+"\n");
                        System.out.println("Press Enter to continue...");
                        sc.nextLine();
                        customerMenu = false;
                        break;
                    }
                }   
            }
                    break;

                case 0:
                    running = false;
                    System.out.println("Thank you for using the Market System. Goodbye!");
                    break;
            }
        }
    }

    sc.close();
    }

   
}
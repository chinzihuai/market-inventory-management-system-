import java.util.Scanner;
import java.util.ArrayList;
//code for a market system

//class Product
class Product{
    private String Product_name;
    private double Product_price;

    public Product(String name, double price){
        this.Product_name = name;
        this.Product_price = price;
    }

    //getter
    public String getName(){
        return Product_name;
    }

    public double getPrice(){
        return Product_price;
    }

    //setter
    public void setName(String name){
        this.Product_name = name;
    }
    public void setPrice(double price){
        this.Product_price = price;
    }
}
//abstract class User
abstract class User{
    private String name;
    private String id;

    //setter
   public User(String name, String id){
        this.name = name;
        this.id = id;
    }

    //getter
    public String getName(){
         return name; 
    }

    public String getId(){ 
        return id; 
    }

    //admin and customer both share method to display products list
    public void view_products(ArrayList<Product> products){

        //if no product in array return no product
        if(products.size() == 0){
            System.out.println("No products available."+"\n");
        }

        //else print the item
        else{
        System.out.println("Product list: ");
        for(int i=0; i<products.size(); i++){
            System.out.println((i+1) + ". " + products.get(i).getName() + " - RM " + products.get(i).getPrice());
        }
        System.out.println("\n");
    }
    }

    //method to pause the system until user press enter
    public void pause(Scanner sc){
        System.out.println("Press Enter to continue..."+"\n");
        sc.nextLine();
    }    
}
//class Admin extends subclass of User
class Admin extends User{

    public Admin(String name, String id){
        super(name, id);
    }

    //method to let admin add item into array
    public void add_item(ArrayList<Product> products,Scanner sc){
    
    while(true){
    System.out.println("Enter the name of the product :");
    String Product_name= sc.nextLine();

    if (Product_name.isEmpty()) {
        System.out.println("Product name cannot be empty. Please try again." + "\n");
        continue;
    }

    try{
    System.out.println("Enter the price of the product :");
    double Product_price= sc.nextDouble();
    sc.nextLine();

    if(Product_price<=0){
        System.out.println("Price cannot be zero and negative, enter again"+"\n");
        continue;
    }

    //add name and price of new object into array
    products.add(new Product(Product_name,Product_price));
    System.out.println("Product add successfully"+"\n");
    break;
    }
    catch(Exception E){
        System.out.println("Unvailable value, enter again"+"\n");
        sc.nextLine();
        continue;
    }
 }
}

    //method to let admin delete product
    public void delete_item(ArrayList<Product> products,Scanner sc){
    
    if(products.size()==0){
        System.out.println("No products available."+"\n");
    }
    else{
    while (true) {
    ////display product list for user
    System.out.println("Product list: ");
    view_products(products);

    try{
    System.out.println("Choose the product (1,2,3....) to delete");
    int position=sc.nextInt();
    sc.nextLine();

    if(position<1 || position>products.size()){
        System.out.println("Unvailable product selected, enter again"+"\n");
        pause(sc);
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
        pause(sc);
        continue;
    }
 }
}
    }
    
    public void manage_item(ArrayList<Product> products,Scanner sc){
        if(products.size()==0){
             System.out.println("No products available."+"\n");
        }
        else{
        while (true) {
        //show products list every loops
        System.out.println("Product list: ");
        view_products(products);
        try{
        System.out.println("Select the product to edit");
        int edit=sc.nextInt();
        sc.nextLine();
        
        if(edit<1 || edit>products.size()){
            System.out.println("Unvailable product selected"+"\n");
            pause(sc);
            continue;
        }

        //product.get(edit-1).Product_name means the Product_name at postion(edit-1)of array
        System.out.println("Editing "+products.get(edit-1).getName()+"\n");

        System.out.println("Enter the new name for product");
        String new_name=sc.nextLine();

        //make sure product name is not empty
        if (new_name.isEmpty()) {
        System.out.println("Product name cannot be empty. Please try again." + "\n");
        continue;
        }

        products.get(edit-1).setName(new_name);

        System.out.println("Enter the new price for product");
        Double new_price=sc.nextDouble();

        if(new_price<=0){
        System.out.println("Price cannot be zero and negative, enter again"+"\n");
        continue;
        }
        products.get(edit-1).setPrice(new_price);

        System.out.println("Item change successfully"+"\n");
        break;
    }

        catch(Exception E){
            System.out.println("Unvaliable input, try again"+"\n");
            sc.nextLine();
            pause(sc);
            continue;
        }
        }
    }
    }
}
//class Customer extends subclass of User
class Customer extends User{
    public Customer(String name, String id){
        super(name, id);
    }

    //method to add product into cart (similar with the method of addItem in Admin class)
    public void add_to_cart(ArrayList<Product> products, ArrayList<Product> cart, Scanner sc){

        if(products.size()==0){
             System.out.println("No products available."+"\n");
        }

        else{
        
        while (true) {
        //show products list every loops
        System.out.println("Product list: ");
        view_products(products);

        try{
        System.out.println("Select the product to add to cart");
        int add=sc.nextInt();
        sc.nextLine();

        if(add<1 || add>products.size()){
            System.out.println("Unvailable product selected"+"\n");
            pause(sc);
            continue;
        }

        //add selected product into cart array
        cart.add(products.get(add-1));
        System.out.println("Product added to cart successfully"+"\n");
        break;
        }

        catch(Exception E){
            System.out.println("Error input"+"\n");
            sc.nextLine();
            continue;
        }
        }
    }
    }
    
    //method to delete product from cart
    public void delete_from_cart(ArrayList<Product> cart, Scanner sc){

        //if cart is empty return no product in cart
        if(cart.size()==0){
             System.out.println("No products in cart."+"\n");
        }

        else{
        while (true) {
        //show cart list every loops
        System.out.println("Cart list: ");
        for(int i=0; i<cart.size(); i++){
            System.out.println((i+1) + ". " + cart.get(i).getName()+ " - RM " + cart.get(i).getPrice());
        }
        try{
        System.out.println("Select the product to delete from cart");
        int delete=sc.nextInt();
        sc.nextLine();
        
        if(delete<1 || delete>cart.size()){
            System.out.println("Unvailable product selected"+"\n");
            pause(sc);
            continue;
        }
        //remove selected product from cart array
        cart.remove(delete-1);
        System.out.println("Product removed from cart successfully"+"\n");
        break;
        }
        catch(Exception E){
            System.out.println("Error input"+"\n");
            sc.nextLine();
            continue;
        }
        }
    }
    }

    //method to print all products in cart along with total price
    public void view_Cart(ArrayList<Product> cart){

        //if cart is empty return no product in cart
        if(cart.size()==0){
             System.out.println("No products in cart."+"\n");
        }
        else{
        for(int i=0; i<cart.size(); i++){
            System.out.println((i+1) + ". " + cart.get(i).getName() + " - RM " + cart.get(i).getPrice());
        }
        double total_price = 0.0;
        for(int i=0; i<cart.size(); i++){
            total_price += cart.get(i).getPrice();
        }
        System.out.println("Total price: RM "+ total_price+"\n");
    }
}
}

//main class MarketSystem
public class MarketSystem {
    public static void main(String[] args) throws Exception {
       Scanner sc =new Scanner(System.in);
       ArrayList<Product> products = new ArrayList<>();
       ArrayList<Product> cart = new ArrayList<>();
    
    int select=0;
    boolean running = true;

    while (running) {
        System.out.println("******************************************************");
        System.out.println("************** Welcome to Market System **************");
        System.out.println("**************    Enter 1 for admin     **************");
        System.out.println("**************    Enter 2 for customer  **************");
        System.out.println("**************    Enter 0 to quit       **************");
        System.out.println("******************************************************");
       
        //if user input data besides integer return error reason
        try{
        select = sc.nextInt();
        sc.nextLine();
       }
       catch(Exception e){
        System.out.println("Unavailable input,please enter a proper number."+"\n");
        sc.nextLine();
        continue;
       }
       
       //if user insert num besides 0 to 4 print error message
       if(select <0 || select >2 ){
        System.out.println("Invalid section, pls insert again."+"\n");
        continue;
       }
       else{
            switch (select) {
            //case for admin
            case 1:

            //check admin password to log in
              System.out.println("Pls enter the admin password:");
              String passcode = sc.nextLine();

              if(passcode.equals("Admin123")==false){
                System.out.println("Wrong passwod,You are not the admin "+"\n");
                System.out.println("Returning to Main Menu..."+"\n");
                System.out.println("Press Enter to continue..."+"\n");
                sc.nextLine();
                continue;
              }
              else{
              System.out.println("Pls enter your name:");
              String adminName = sc.nextLine();
                
              //keep asking for name until user enter a valid name
              while (adminName.isEmpty()) {
              System.out.println("Name cannot be empty. Please try again." + "\n");
              System.out.println("Pls enter your name:");
              adminName = sc.nextLine();
              }

              System.out.println("Pls enter your admin ID:");
              String adminId = sc.nextLine();

              //keep asking for id until user enter a valid id
              while (adminId.isEmpty()) {
              System.out.println("ID cannot be empty. Please try again." + "\n");
              System.out.println("Pls enter your name:");
              adminId = sc.nextLine();
              }

              Admin admin = new Admin(adminName, adminId); 

              System.out.println("\n");
              System.out.println("Welcome Admin " + admin.getName()+ " with ID: " +admin.getId() );
              System.out.println("\n");

              // Admin menu loop
              boolean adminRunning = true;
                while (adminRunning) {
                    int adminChoice = -1;

                    System.out.println("************** Admin Menu **************");
                    System.out.println("1. View Products");
                    System.out.println("2. Add Product");
                    System.out.println("3. Remove Product");
                    System.out.println("4. Edit Product");
                    System.out.println("0. Return to Main Menu");
                    System.out.println("***************************************");
                    
                    //if user input data besides integer return reason
                    try{
                    adminChoice = sc.nextInt();
                    sc.nextLine();
                    }

                    catch(Exception e){
                        System.out.println("Unavailable input,please enter a proper number."+"\n");
                        sc.nextLine();
                        continue;
                       }

                    //stop wrong selection
                    if(adminChoice <0 || adminChoice >4 ){
                    System.out.println("Invalid section, pls insert again."+"\n");
                    continue;
                    }
                    else{
                        switch (adminChoice) {
                        case 1:
                            // call view products method
                            admin.view_products(products);
                            admin.pause(sc);
                            break;
                        case 2:
                            // call add item method
                            admin.add_item(products, sc);
                            admin.pause(sc);
                            break;
                        case 3:
                            // call delete item method
                            admin.delete_item(products, sc);
                            admin.pause(sc);
                            break;
                        case 4:
                            // call manage item method
                            admin.manage_item(products, sc);
                            admin.pause(sc);
                            break;
                        case 0:
                            //while user enter 0 condition of while(adminRunning) turns to false and break the loop for admin menu
                            System.out.println("Returning to Main menu!"+"\n");
                            admin.pause(sc);
                            adminRunning = false;
                            break;
                        }

                    }
                }
            }
            //break of admin case ( Case 1 )
            break;
               
            //case for customer
            case 2:
              System.out.println("Pls enter your name:");
              String customerName = sc.nextLine();

              //keep asking for name until user enter a valid name
              while(customerName.isEmpty()){
              System.out.println("Name cannot be empty. Please try again." + "\n");
              System.out.println("Pls enter your name:");
              customerName = sc.nextLine();
              }

              System.out.println("Pls enter your customer ID:");
              String customerId = sc.nextLine();

              //keep asking for id until user enter a valid id
              while(customerId.isEmpty()){
              System.out.println("ID cannot be empty. Please try again." + "\n");
              System.out.println("Pls enter your customer ID:");
              customerId = sc.nextLine();
              }

              Customer customer = new Customer(customerName, customerId);

              System.out.println("\n");
              System.out.println("Welcome Customer " + customer.getName()+ " with ID: " +customer.getId() );
              System.out.println("\n");

              //customer menu loop
              boolean customerRunning = true;

                while (customerRunning) {
                    int customerChoice = -1;

                    System.out.println("************** Customer Menu **************");
                    System.out.println("1. View Products");
                    System.out.println("2. Add Product to Cart");
                    System.out.println("3. Delete Product from Cart");
                    System.out.println("4. Check Cart");
                    System.out.println("0. Return to Main Menu");
                    System.out.println("******************************************");
                    
                    //if user input data besides integer return error reason
                    try{
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
                            customer.view_products(products);
                            customer.pause(sc);
                            break;
                        case 2:
                        //call add to cart method
                            customer.add_to_cart(products, cart, sc);
                            customer.pause(sc);
                            break;
                        case 3:
                        //call delete from cart method
                            customer.delete_from_cart( cart, sc);
                            customer.pause(sc);
                            break;
                        case 4:
                        //call view cart method
                            customer.view_Cart(cart);
                            customer.pause(sc);
                            break;
                        case 0:
                        //while user enter 0, condition of while(customerRunning) turns to false and break the loop for customer menu
                        System.out.println("Returning to Main Menu..."+"\n");
                        customer.pause(sc);
                        customerRunning = false;
                        break;
                    }
                }
                }
                //break of customer case ( Case 2 )
                break;

            case 0:
                //while user enter 0,condition of while(running) turns to false and break the loop of the system and quit
                System.out.println("Thanks for Using Market System. Goodbye!");
                running = false;
                break;
        }
    }
    }
    //close scanner
    sc.close();
    }
}

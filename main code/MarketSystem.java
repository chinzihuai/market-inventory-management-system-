import java.util.Scanner;
import java.util.ArrayList;
//code for a market system
//class Product
class Product{
    public String Product_name;
    public double Product_price;

    public Product(String name, double price){
        this.Product_name = name;
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
        for(int i=0; i<products.size(); i++){
            System.out.println((i+1) + ". " + products.get(i).Product_name + " - RM" + products.get(i).Product_price);
        }
    }
    }
}
//class Admin extends subclass of User
class Admin extends User{
    public Admin(String name, String id){
        super(name, id);
    }

    //method to let admin add item into array
    public void add_item(ArrayList<Product> products,Scanner sc){
    System.out.println("Enter the name of the product :");
    String Pname= sc.nextLine();
    System.out.println("Enter the price of the product :");
    Double Pprice= sc.nextDouble();

    products.add(new Product(Pname, Pprice));
    sc.nextLine();
    }
}
//class Customer extends subclass of User
class Customer extends User{
    public Customer(String name, String id){
        super(name, id);
    }
}
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
       
        //if user input data besides integer return reason
        try{
        select = sc.nextInt();
        sc.nextLine();
       }
       catch(Exception e){
        System.out.println("Invalid input, please enter a number.");
        sc.nextLine();
        continue;
       }
       
       //stop wrong selection
       if(select !=1 && select !=2 && select !=0 ){
        System.out.println("Invalid selection, please try again."+"\n");
        continue;
       }
       else{
            switch (select) {
            //case for admin
            case 1:
              System.out.println("Pls enter your name:");
              String adminName = sc.nextLine();

              System.out.println("Pls enter your admin ID:");
              String adminId = sc.nextLine();

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
                        System.out.println("Invalid input, please enter a number."+"\n");
                        continue;
                       }

                    //stop wrong selection
                    if(adminChoice !=1 && adminChoice !=2 && adminChoice !=0 && adminChoice !=3 && adminChoice !=4 ){
                    System.out.println("Invalid selection, please try again."+"\n");
                    continue;
                    }
                    else{
                        switch (adminChoice) {
                        case 1:
                            // call view products method
                            admin.view_products(products);
                            System.out.println("Press Enter to continue..."+"\n");
                            sc.nextLine();
                            break;
                        case 2:
                            admin.add_item(products, sc);
                            System.out.println("Press Enter to continue..."+"\n");
                            sc.nextLine();
                            break;
                        case 3:
                            // Remove product logic
                            break;
                        case 4:
                            // Edit product logic
                            break;
                        case 0:
                        System.out.println("Returning to main menu!");
                        System.out.println("Press Enter to continue..."+"\n");
                        sc.nextLine();
                        adminRunning = false;
                        break;
                        }

                    }
                }
                //exit admin case
                break;
               
            //case for customer
            case 2:
              System.out.println("Pls enter your name:");
              String customerName = sc.nextLine();

              System.out.println("Pls enter your customer ID:");
              String customerId = sc.nextLine();

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
                    
                    try{
                    customerChoice = sc.nextInt();
                    sc.nextLine();
                    }
                    catch(Exception e){
                        System.out.println("Invalid input, please enter a number."+"\n");
                        continue;
                       }
                    if(customerChoice !=1 && customerChoice !=2 && customerChoice  !=0 && customerChoice  !=3 && customerChoice  !=4 ){
                    System.out.println("Invalid selection, please try again."+"\n");
                    continue;
                    }
                    else{
                    switch (customerChoice) {
                        case 1:
                        //call view products method
                            customer.view_products(products);
                            System.out.println("Press Enter to continue..."+"\n");
                            sc.nextLine();
                            break;
                        case 2:
                            // Purchase product logic
                            break;
                        case 3:
                            // Remove product from cart logic
                            break;
                        case 4:
                            // Check cart logic
                            break;
                        case 0:
                        System.out.println("Returning to Main Menu..."+"\n");
                        System.out.println("Press Enter to continue..."+"\n");
                        sc.nextLine();
                        customerRunning = false;
                        break;
                    }
                }
                }
                break;

            case 0:
                System.out.println("Exiting the Market System. Goodbye!");
                running = false;
                break;
        }
    }
    }
    sc.close();
}
}
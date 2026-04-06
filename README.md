# Market Inventory Management System

This is a small, console-based inventory management system designed for a market. It provides distinct interfaces for administrators and customers to efficiently manage and interact with product inventories.

## Key Features & Benefits

### Key Features

*   **Dual User Interfaces:** Dedicated interfaces for `Admin` and `Customer` roles.
*   **Administrator Capabilities:**
    *   Add new products to the inventory with details like name, price, and quantity.
    *   Delete existing products from the inventory.
    *   Edit product details (e.g., update price, quantity, or name).
    *   View the complete product list currently in stock.
*   **Customer Capabilities:**
    *   View the available product list with current stock information.
    *   Add products to their shopping cart with specified quantities.
    *   Remove products from their shopping cart.
    *   View the current contents of their shopping cart.

### Benefits

*   **Streamlined Inventory Control:** Helps market owners keep track of their stock levels, additions, and removals efficiently.
*   **Improved Customer Experience:** Provides a clear and simple way for customers to browse products and manage their potential purchases.
*   **Role-Based Access:** Ensures secure and appropriate access to system functionalities, differentiating between administrative tasks and customer interactions.
*   **Ease of Use:** Designed for simplicity, making it straightforward for both administrators and customers to navigate.

## Prerequisites

Before you begin, ensure you have the following installed on your system:

*   **Java Development Kit (JDK):** Version 8 or higher. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-downloads.html) or use OpenJDK distributions like [Adoptium Temurin](https://adoptium.net/).

## Installation & Setup Instructions

Follow these steps to get the Market Inventory Management System up and running on your local machine:

1.  **Clone the Repository:**
    Start by cloning the project repository to your local machine using Git:

    ```bash
    git clone https://github.com/chinzihuai/market-inventory-management-system-.git
    cd market-inventory-management-system-
    ```

2.  **Run the Application:**
    The `bin/` directory contains the pre-compiled `.class` files required to run the application. You can execute the main application directly from there:

    ```bash
    java -cp bin InventoryManageSystem
    ```
    This command tells the Java Virtual Machine (JVM) to look for class files in the `bin` directory and execute the `main` method within `InventoryManageSystem.class`.

    *Note: The project structure indicates that `main code/InventoryManageSystem.java` is the primary source file, while `Admin.java`, `Customer.java`, `Product.java`, and `Users.java` are not provided as source files in the project structure but exist as compiled `.class` files in `bin/`. If you intend to modify `InventoryManageSystem.java` and recompile, you may need to ensure all dependent `.java` files are available in the classpath or compile `InventoryManageSystem.java` into the `bin/` directory alongside the existing `.class` files.*
    
    To compile `InventoryManageSystem.java` if you make changes (from the project root):
    ```bash
    javac -d bin main\ code/InventoryManageSystem.java
    ```

## Usage Examples

Once the application is running, you will interact with it via the command line (console).

1.  **Start the System:**
    Execute the command as shown in the Installation section:
    ```bash
    java -cp bin InventoryManageSystem
    ```

2.  **User Selection/Login:**
    The system will typically present an initial prompt to choose between an `Admin` or `Customer` interface. Follow the on-screen instructions to proceed.

3.  **Admin Interface Interactions:**
    If you choose the Admin role, you will be presented with options such as:
    *   **Add Product:** Enter product details (name, price, stock quantity).
    *   **Delete Product:** Input the ID or name of the product to remove.
    *   **Edit Product:** Select a product and modify its attributes (e.g., update price, change quantity).
    *   **View Products:** Display a list of all products currently in the inventory.

4.  **Customer Interface Interactions:**
    If you choose the Customer role, you will be able to:
    *   **View Products:** Browse the list of available items and their prices.
    *   **Add to Cart:** Select a product and the desired quantity to add it to your shopping cart.
    *   **Remove from Cart:** Specify an item in your cart to remove it.
    *   **View Cart:** See the current contents of your shopping cart and the total cost.

## Configuration Options

This project currently does not include explicit external configuration files (e.g., `.properties`, `.json`) or environment variables for dynamic settings. All system parameters, such as initial product data or user credentials, are likely hard-coded within the Java source files.

**Future Enhancements for Configuration:**
*   Consider implementing external configuration files to allow for easier modification of system parameters without recompiling the source code. This would be beneficial for managing data persistence, user accounts, or other changeable settings.

## Contributing Guidelines

We welcome contributions to enhance the Market Inventory Management System! If you'd like to contribute, please follow these guidelines:

1.  **Fork the Repository:** Start by forking this repository to your own GitHub account.
2.  **Create a New Branch:** Create a new branch for your feature, bug fix, or improvement:
    ```bash
    git checkout -b feature/your-feature-name
    # or
    git checkout -b bugfix/issue-description
    ```
3.  **Make Your Changes:** Implement your changes and ensure they adhere to the project's coding style (if one is established).
4.  **Commit Your Changes:** Commit your changes with clear, concise, and descriptive commit messages.
    ```bash
    git commit -m "feat: Add new product search functionality"
    ```
5.  **Push to Your Branch:** Push your local branch to your forked repository on GitHub:
    ```bash
    git push origin feature/your-feature-name
    ```
6.  **Open a Pull Request (PR):** Navigate to the original repository on GitHub and open a Pull Request from your new branch to the `main` branch. Provide a detailed description of your changes and why they are valuable.

## License Information

This project currently does **not have an explicit license specified**.

By default, without a specified license, all rights are reserved by the copyright holder (`chinzihuai`). This means others cannot legally use, distribute, or modify this software without explicit permission.

It is highly recommended that a license (such as MIT, Apache 2.0, or GPL) be added to clarify the terms under which this software can be used, shared, and contributed to.

## Acknowledgments

*   **chinzihuai:** For initiating and owning the `market-inventory-management-system-` project.

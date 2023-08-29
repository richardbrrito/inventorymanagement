package prog;
import javax.swing.*;

public class ProductManagerDriver {

    private ProductManager productManager;

    public ProductManagerDriver() {
        productManager = new ProductManager();
        mainMenu();
    }

    public static void main(String[] args) {
        new ProductManagerDriver();
    }

    private void mainMenu() {
        while (true) {
            String[] options = {"Add Product", "Find Product", "Remove Product", "Display Inventory", "Display Deleted Products", "Exit"};
            int selection = JOptionPane.showOptionDialog(null, "Select an action:",
                    "Product Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (selection) {
                case 0:
                    addProduct(productManager);
                    break;
                case 1:
                    findProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    productManager.displayInventoryReport();
                    break;
                case 4:
                    productManager.displayDeletedProducts();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void addProduct(ProductManager manager) {
        String manufacturerName = JOptionPane.showInputDialog("Enter manufacturer's name:");

        String street = JOptionPane.showInputDialog("Enter manufacturer's street address:");
        String city = JOptionPane.showInputDialog("Enter manufacturer's city:");
        String state = JOptionPane.showInputDialog("Enter manufacturer's state:");
        String zipCode = JOptionPane.showInputDialog("Enter manufacturer's zip code:");

        Address manufacturerAddress = new Address(street, city, state, zipCode);
        Manufacturer manufacturer = new Manufacturer(manufacturerName, manufacturerAddress);

        String name = JOptionPane.showInputDialog("Enter product name:");
        int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter product quantity:"));
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter product price:"));
        String purchaseDate = JOptionPane.showInputDialog("Enter purchase date (e.g., MM/DD/YYYY):");

        Product product = new Product(manufacturer, name, quantity, price, purchaseDate);
        manager.addProduct(product);

        JOptionPane.showMessageDialog(null, "Product added successfully!");
    }


    private void findProduct() {
        String name = getInput("Enter product name to search:");
        Product product = productManager.findProductByName(name);
        if (product != null) {
            JOptionPane.showMessageDialog(null, product, "Product Found", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Product not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void removeProduct() {
        String name = getInput("Enter product name to remove:");
        Product product = productManager.findProductByName(name);
        if (product != null) {
            productManager.removeProduct(product);
            JOptionPane.showMessageDialog(null, "Product removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Product not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getInput(String message) {
        return JOptionPane.showInputDialog(message);
    }
}

package prog;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.util.ArrayList;

public class ProductManager {

    private ArrayList<Product> products;
    private ArrayList<Product> deletedProducts;

    public ProductManager() {
        products = new ArrayList<>();
        deletedProducts = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public void removeProduct(Product product) {
        deletedProducts.add(product);
        products.remove(product);
    }

    public void displayInventoryReport() {
        StringBuilder report = new StringBuilder();
        report.append(String.format("%-10s %-15s %-10s %-10s %-15s %-10s\n",
                "Product", "Purchase Date", "Quantity", "Price", "Manufacturer", "State"));

        for (Product product : products) {
            report.append(String.format("%6s %13s %17d $%5.2f %15s %15s\n",
                    product.getName(),
                    product.getPurchaseDate(),
                    product.getQuantity(),
                    product.getPrice(),
                    product.getManufacturer().manufacturerName(),
                    product.getManufacturer().manufacturerState()));
        }
        displayInScrollablePane(report.toString(), "Inventory Report");
    }


    public void displayDeletedProducts() {
        StringBuilder report = new StringBuilder();
        report.append(String.format("%-15s %-15s %-15s\n",
                "Product", "Date", "Manufacturer"));

        for (Product product : deletedProducts) {
            report.append(String.format("%-15s %-15s %-15s\n",
                    product.getName(),
                    product.getPurchaseDate(),
                    product.getManufacturer().manufacturerName()));
        }
        displayInScrollablePane(report.toString(), "Deleted Products");
    }


    private void displayInScrollablePane(String text, String title) {
        JTextArea textArea = new JTextArea(20, 50);
        textArea.setText(text);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setCaretPosition(0);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
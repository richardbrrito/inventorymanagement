package prog;
import java.util.ArrayList;


// Utilizing singleton pattern for simplicity
public class Database {
    private static Database instance;

    private ArrayList<Product> products;
    private Product currentProduct;
    private int currentIndex;
    private boolean found;

    private Database() {
        this.products = new ArrayList<>();
        this.currentProduct = null;
        this.currentIndex = -1;
        this.found = false;
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // Method to search for a product by name
    public void search(String productName) {
        found = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equalsIgnoreCase(productName)) {
                currentProduct = products.get(i);
                currentIndex = i;
                found = true;
                break;
            }
        }
    }

    // Method to add a product to the list
    public void add(Product newProduct) {
        products.add(newProduct);
    }

    // Method to delete a product from the list
    public Product delete(int index) {
        if (index >= 0 && index < products.size()) {
            return products.remove(index);
        }
        return null;
    }

    // Getters
    public int getCurrentIndex() {
        return currentIndex;
    }

    public boolean isFound() {
        return found;
    }

    public Product getCurrentProduct() {
        return currentProduct;
    }

    public int getSize() {
        return products.size();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}

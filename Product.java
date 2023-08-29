package prog;

class Product {


    private String name;
    private String purchaseDate;
    private int quantity;
    private double price;
    private Manufacturer manufacturer;


    public Product(Manufacturer manufacturer, String name, int quantity, double price, String purchaseDate) {
        this.name = name;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.price = price;
        this.manufacturer = manufacturer;

    }
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    // Setters
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getTotalPrice() {
        return this.price * this.quantity;
    }

    @Override
    public String toString() {
        return String.format("Product Name: %s\nQuantity: %d\nPrice: %.2f\nPurchase Date: %s\nManufacturer: %s",
                name, quantity, price, purchaseDate, manufacturer.manufacturerName());
    }

}

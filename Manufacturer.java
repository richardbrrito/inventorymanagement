package prog;

class Manufacturer {
    private String manufacturerName;
    private Address manufacturerAddress;
    public String manufacturerState;

    public Manufacturer(String manufacturerName, Address manufacturerAddress) {
        this.manufacturerName = manufacturerName;
        this.manufacturerAddress = manufacturerAddress;
    }

    // getters

    public String manufacturerName() {
        return manufacturerName;
    }

    public Address manufacturerAddress() {
        return manufacturerAddress;
    }
    public String manufacturerState() {
        return manufacturerAddress.getState();
    }


}

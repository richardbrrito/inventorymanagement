package prog;

public class Address {

    private String street;
    private String city;
    private String state;
    private String zip_code;


    public Address(String street,String city,String state,String zip_code){
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;

    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zip_code;
    }
}

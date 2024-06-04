package model;

/**
 *
 * @QuangTung
 */

public class ServiceSupplier {
    private int id;
    private String type;
    private int price;
    private Service service;
    private Supplier supplier;

    public ServiceSupplier() {
    }

    public ServiceSupplier(int id, String type, int price, Service service, Supplier supplier) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.service = service;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    
}

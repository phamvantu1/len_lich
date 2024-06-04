package model;

/**
 *
 * @QuangTung
 */

public class ServiceSchedule {
    private int id;
    private int price;
    private int quantity;
    private ServiceSupplier serviceSupplier;

    public ServiceSchedule() {
    }

    public ServiceSchedule(int id, int price, int quantity, ServiceSupplier serviceSupplier) {
        this.id = id;
        this.price = price;
        this.quantity = quantity;
        this.serviceSupplier = serviceSupplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ServiceSupplier getServiceSupplier() {
        return serviceSupplier;
    }

    public void setServiceSupplier(ServiceSupplier serviceSupplier) {
        this.serviceSupplier = serviceSupplier;
    }
    
    
}

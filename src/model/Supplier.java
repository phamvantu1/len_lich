package model;

/**
 *
 * @QuangTung
 */

public class Supplier {
    private int id;
    private String name;
    private String email;
    private String tel;
    private String note;

    public Supplier() {
    }

    public Supplier(int id, String name, String email, String tel, String note) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
}

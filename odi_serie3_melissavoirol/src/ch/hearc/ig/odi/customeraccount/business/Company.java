package ch.hearc.ig.odi.customeraccount.business;

/**
 *
 * @author steven.habegger
 */
public class Company extends Customer {
    private String phone;
    private String fax;

    public Company(Integer number, String firstName, String lastName, String phone, String fax) {
        super(number, firstName, lastName);
        this.phone = phone;
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public String toString() {
        return "Company{" + "phone=" + phone + ", fax=" + fax + '}';
    }
    
    
    
    
}

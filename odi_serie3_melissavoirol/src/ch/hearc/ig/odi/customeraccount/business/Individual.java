package ch.hearc.ig.odi.customeraccount.business;

import java.util.Date;

/**
 *
 * @author Melissa Voirol <melissa.voirol@he-arc.ch>
 */
public class Individual extends Customer {

    private Date birthDate;
    private String email;

    public Individual(Integer number, String firstName, String lastName, Date birthDate, String email) {
        super(number, firstName, lastName);
        this.birthDate = birthDate;
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Individual{" + "birthDate=" + birthDate + ", email=" + email + '}';
    }

}

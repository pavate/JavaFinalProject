

package bookdatabase;

/**
 *
 * @author acer
 */
public class NewUser {
    private double ID;
    private String firstName;
    private String lastName;

    public NewUser(double ID, String firstName, String lastName, String email, int phoneNo, String city, String country) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.city = city;
        this.country = country;
    }
    private String email;
    private int phoneNo;
    private String city;
    private String country;

}

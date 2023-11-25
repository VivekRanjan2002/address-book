   public class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phoneNo;
    private String emailID;

    // constructor
    public Contact(String firstName, String lastName, String address, String city,
            String zip, String phoneNo, String emailID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phoneNo = phoneNo;
        this.emailID = emailID;

    }
 
      /*
      If we print any object,Java compiler  internally invokes the toString() method on the object.
       So overriding the toString() method, returns the desired output
     */
    // @Override
   
    public String toString() {
        String contactInfo = String.format("""

                FirstName:  %s
                LastName:  %s
                address:  %s
                city:  %s
                zip:  %s
                phoneNo:  %s
                emailID: %s

                                """, this.firstName, this.lastName, this.address, this.city, this.zip, this.phoneNo,
                this.emailID);

        return contactInfo;
    }
}

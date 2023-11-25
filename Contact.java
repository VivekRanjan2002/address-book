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
        this.firstName = firstName.replace(" ","").toUpperCase(); // store in uppercase and erase all whitespace 
        this.lastName = lastName.replace(" ","").toUpperCase(); 
        this.address = address;
        this.city = city.replace(" ","").toUpperCase();
        this.zip = zip.replace(" ","").toUpperCase();
        this.phoneNo = phoneNo.replace(" ","").toUpperCase();
        this.emailID = emailID.replace(" ","").toLowerCase();

    }
     // getter function
     public String getFirstName() {
         return this.firstName;
     }

     public String getLastName(){
        return this.lastName; 
     }

     public String getAddress() {
         return this.address;
     }

     public String getCity(){
        return this.city;
     }

     public String getZip()
     {
         return this.zip;
     }

     public String getPhoneNo(){
        return this.phoneNo;
     }

     public String getEmailId() {
         return this.emailID;
     }
 
      // setter function
     public void setFirstName(String firstName) {
          this.firstName=firstName.replace(" ","").toUpperCase();
     }

      public void setLastName(String lastName){
         this.lastName=lastName.replace(" ","").toUpperCase(); 
     }

     public void setAddress(String address) {
          this.address=address;
     }

     public void setCity(String city){
         this.city=city.replace(" ","").toUpperCase();
     }

     public void setZip(String zip)
     {
          this.zip=zip.replace(" ","").toUpperCase();
     }

     public void setPhoneNo(String phoneNo){
         this.phoneNo=phoneNo.replace(" ","").toUpperCase();
     }

     public void setEmailId(String emailID){
         this.emailID=emailID.replace(" ","").toLowerCase();
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

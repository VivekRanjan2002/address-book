import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        Scanner sc = new Scanner(System.in);
        HashMap<String, Contact> addressBook = new HashMap<>();
        boolean running = true;
        while (running) {
            System.out.println("Press 1 to add the New Contact: ");
            System.out.println("Press 2 to display the details by providing name: ");
            System.out.println("Press 3 to exit");
            System.out.println("Please Enter your Option: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    addNewContact(addressBook);
                    System.out.println("Contact is Successfully Created");

                    break;
                case 2:
                displayContact(addressBook);
                    break;
                case 3:
                    System.out.println("Program is Closing....");
                    running = false;
                default:
                    System.out.println("Invalid Input");
                    break;
            }

        }
    }

    public static void addNewContact(HashMap<String, Contact> addressBook) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.println("Please Enter Last Name: ");
        String lastName = sc.nextLine();
        System.out.println("Please Enter address: ");
        String address = sc.nextLine();
        System.out.println("Please Enter city: ");
        String city = sc.nextLine();
        System.out.println("Please Enter zip: ");
        String zip = sc.nextLine();
        System.out.println("Please Enter PhoneNo: ");
        String PhoneNo = sc.nextLine();
        System.out.println("Please Enter EmailID: ");
        String emailID = sc.nextLine();

        Contact C1 = new Contact(firstName, lastName, address, city, zip, PhoneNo, emailID);
        String fullName = firstName + lastName;
        addressBook.put(fullName, C1);
        System.out.println(addressBook.get(fullName));
        
        return;
    }
 
    public static void displayContact(HashMap<String,Contact> addressBook){
        Scanner sc= new Scanner(System.in);
        System.out.println("Please Enter First Name: ");
        String firstName = sc.nextLine();
        System.out.println("Please Enter Last Name : ");
        String lastName = sc.nextLine();
        String fullName = firstName + lastName; // to be searched in map;
        if (addressBook.containsKey(fullName)) { 
            System.out.println(addressBook.get(fullName));
        }
        else {
            System.out.println("OOPS! SORRY!! No such contact exist ! ");
        }
        return;
    }
}
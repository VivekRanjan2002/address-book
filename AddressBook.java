import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        Scanner sc = new Scanner(System.in);
        HashMap<String, Contact> addressBook = new HashMap<>();
        boolean running = true;
        while (running) {
            System.out.println("Press 1 to add the New Contact ");
            System.out.println("Press 2 to display the details by providing name ");
            System.out.println("Press 3 to edit contact details");
            System.out.println("Press 4 to remove Contact");
            System.out.println("Press 5 to exit");
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
                    editDetails(addressBook);
                    break;
                case 4:
                    removeContact(addressBook);
                    break;
                case 5:
                    System.out.println("Program is Closing....");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }

        }
    }

    // add new contact in addressbook
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
        String fullName = (firstName + lastName).replaceAll(" ", "");
        System.out.println(fullName);

        addressBook.put(fullName.toUpperCase(), C1);
        System.out.println(addressBook.get(fullName.toUpperCase()));

        return;
    }

    // display contact info from address by fullname as key
    public static void displayContact(HashMap<String, Contact> addressBook) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Full Name: ");
        String fullName = sc.nextLine();

        if (addressBook.containsKey(fullName.replaceAll(" ", "").toUpperCase())) {
            System.out.println(addressBook.get(fullName.toUpperCase()));
        } else {
            System.out.println("OOPS! SORRY!! No such contact exist ! ");
        }
        return;
    }

    // edit contact details for particular fullname user
    public static void editDetails(HashMap<String, Contact> addressBook) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Full Name: ");
        String fullName = sc.nextLine();
        String searchKey = fullName.replaceAll(" ", "").toUpperCase();
        if (addressBook.containsKey(searchKey)) {
            Contact contact = addressBook.get(searchKey);
            addressBook.remove(searchKey);
            boolean running = true;
            while (running) {
                System.out.println("Press 1 to edit First Name");
                System.out.println("Press 2 to edit Last Name");
                System.out.println("Press 3 to edit Address");
                System.out.println("Press 4 to edit City");
                System.out.println("Press 5 to edit Zip");
                System.out.println("Press 6 to edit Phone No.");
                System.out.println("Press 7 to edit Email ID");
                System.out.println("Press 8 to confirm ");
                System.out.println("Press your Option: ");

                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Please Enter Your New First Name");
                        sc.nextLine();
                        String firstName = sc.nextLine();
                        contact.setFirstName(firstName);
                        break;
                    case 2:
                        System.out.println("Please Enter Your New Last Name");
                        sc.nextLine();
                        String lastName = sc.nextLine();
                        contact.setLastName(lastName);
                        break;
                    case 3:
                        System.out.println("Please Enter Your New Address");
                        sc.nextLine();
                        String address = sc.nextLine();
                        contact.setAddress(address);

                        break;
                    case 4:
                        System.out.println("Please Enter Your New City");
                        sc.nextLine();
                        String city = sc.nextLine();
                        contact.setCity(city);
                        break;
                    case 5:
                        System.out.println("Please Enter Your New Zip");
                        sc.nextLine();
                        String zip = sc.nextLine();
                        contact.setZip(zip);
                        break;
                    case 6:
                        System.out.println("Please Enter Your New Phone No.");
                        sc.nextLine();
                        String phoneNo = sc.nextLine();
                        contact.setPhoneNo(phoneNo);
                        break;
                    case 7:
                        System.out.println("Please Enter Your New EmailID");
                        sc.nextLine();
                        String emailID = sc.nextLine();
                        contact.setEmailId(emailID);
                        break;
                    case 8:
                        String key = contact.getFirstName() + contact.getLastName();
                        System.out.println(key);
                        addressBook.put(key, contact);
                        System.out.println("Contact updated Successfully");
                        running = false;

                    default:
                        System.out.println("Please Enter Valid Option");
                        break;
                }
            }
        } else {
            System.out.println("No such contact exist ");
        }
    }

    // remove contact from addressBook
    public static void removeContact(HashMap<String, Contact> addressBook) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Full Name to be Removed: ");
        String fullname = sc.nextLine().replaceAll(" ", "").toUpperCase();
        if (addressBook.containsKey(fullname)) {
            addressBook.remove(fullname);
            System.out.println("Contact Removed Successfully");
        }
        else {
            System.out.println("No Such Contact Exist");
        }
    }
}
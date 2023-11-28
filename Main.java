import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");

        HashMap<String, AddressBook> AddressBookSaver = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Press 1 to add contacts in new address book");
            System.out.println("Press 2 to add contacts in existing address book");
            System.out.println("Press 3 to print the address book");
            System.out.println("Press 4 to exit program");
            System.out.println("Press your Option: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    addNewAddressBook(AddressBookSaver);
                    break;
                case 2:
                    existAddressBook(AddressBookSaver);
                    break;
                case 3:
                    logAddressBook(AddressBookSaver);
                    break;
                   case 4:
                   running=false;
                   break;
                default:
                    System.out.println("Invalid Option");

            }
        }

    }
 
    public static void addNewAddressBook(HashMap<String, AddressBook> AddressBookSaver) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new address book");
        String addressBookName = sc.nextLine();
        HashMap<String, Contact> ContactSaver = new HashMap<>();
        AddressBook Adb = new AddressBook(addressBookName,ContactSaver);
        Adb.OptionLogger();
        AddressBookSaver.put(addressBookName, Adb);
        

    }
    
    public static void existAddressBook(HashMap<String, AddressBook> AddressBook) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Existing AddressBook name in which u want to add contacts");
        String addressBookName = sc.nextLine();
        if (AddressBook.containsKey(addressBookName)) {
            AddressBook.get(addressBookName).OptionLogger();
            AddressBook.put(addressBookName, AddressBook.get(addressBookName));
        
        }
        else {
            System.out.println("No such Address Book exist . Please Type correct AddressBook Name ");
        }
        
    }

    public static void logAddressBook(HashMap<String, AddressBook> AddressBook) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter Existing AddressBook name  which u want to print ");
        String addressBookName = sc.nextLine();
        if (AddressBook.containsKey(addressBookName)) {
           AddressBook.get(addressBookName).logger();
        }
        else {
            System.out.println("No such Address Book exist . Please Type correct AddressBook Name ");
        }
    }

}

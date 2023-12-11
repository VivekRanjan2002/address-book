import java.util.*;

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
            System.out.println("Press 4 to search for particular person in city");
            System.out.println("Press 5 to print contacts in entire address books on the basis of city");
            System.out.println("Press 6 to print no. of contacts in entire address books on city basis");
            System.out.println("Press 7 to print entire AddressBooks sorted according to person name");
            System.out.println("Press 8 to exit program");
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
                    searchContactCityBasis(AddressBookSaver);
                    break;
                case 5:
                    ArrayList<Contact> arr=logContactCityBasis(AddressBookSaver);
                    if(arr.size()>0){
                        System.out.println("Here are the list of contacts in this city: ");
                        System.out.println(arr);
                    }
                    else{
                        System.out.println("No any contact exist in this city");
                    }
                    break;
                case 6:
                    System.out.println("Total no. of contacts in this city is: " +
                            logContactCityBasis(AddressBookSaver).size());
                    break;
                case 7:
                    System.out.println("Printing entire AddressBooks sorted with Person name .....");
                    printSortedContact(AddressBookSaver);
                    break;
                   case 8:
                   running=false;
                   break;
                default:
                    System.out.println("Invalid Option");

            }
        }

    }


 // add new addressbook in hashmap addressbooksaver
    public static void addNewAddressBook(HashMap<String, AddressBook> AddressBookSaver) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the new address book");
        String addressBookName = sc.nextLine();
        HashMap<String, Contact> ContactSaver = new HashMap<>();
        AddressBook Adb = new AddressBook(addressBookName,ContactSaver);
        Adb.OptionLogger();
        AddressBookSaver.put(addressBookName, Adb);
        

    }
    // check for certain addressbook in hashmap addressbooksaver
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
    // log current addressbook
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
    // search for particular person in particular city
    public static void searchContactCityBasis(HashMap<String, AddressBook> AddressBookSaver){
        Scanner sc= new Scanner(System.in);
        ArrayList<Contact> contactsCity= logContactCityBasis(AddressBookSaver);
        if(contactsCity.size()==0){
            System.out.println("No any contact exist in this city");
            return;
        }
        System.out.println("Please Enter Contact first name you want to search: ");
        String input= sc.nextLine();
        String firstName= input.replaceAll(" ","").toUpperCase();
        boolean found=false;
       for(Contact c: contactsCity){

           if(c.getFirstName().equals(firstName)) {
               System.out.println(c);
               found=true;
           }
       }
       if(!found) System.out.println("sorry! no such contact exist in this city");


    }
// log contacts across all addressbook of particular city
    public  static ArrayList<Contact> logContactCityBasis(HashMap<String, AddressBook> AddressBookSaver){
        Scanner sc= new Scanner(System.in);
        System.out.println("Please Enter city Name: ");
        String input= sc.nextLine();
        String city=input.replace(" ","").toUpperCase();
        ArrayList<Contact> arr= new ArrayList<>();
        AddressBookSaver.forEach((key,value)->{
            AddressBook adb= value;
            adb.contactSaver.forEach((k,v)->{
                Contact c= v;
                if(c.getCity().equals(city)) {

                    arr.add(c);
                }

            });
        });
       return arr;
    }
    /*
    @desc: sort the entire hashmap AddressBookSaver according to Person name using java streams
           and then print it
     */
    public static void printSortedContact(HashMap<String,AddressBook> AddressBookSaver){
        // Sorting each contactSaver map in the AddressBookSaver by person's name using Java.stream()
        AddressBookSaver.forEach((AddressBookName,AddressBook)->{
            HashMap<String,Contact> sortedContact= AddressBook.getContactSaver().entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .collect(LinkedHashMap::new,(map,entry)->map.put(entry.getKey(),entry.getValue()),Map::putAll);
            AddressBook.getContactSaver().clear();
            AddressBook.getContactSaver().putAll(sortedContact);
        });

        //Printing the addressBook sorted according to Person
        AddressBookSaver.forEach((addressBookName, addressBook) -> {
            System.out.println("AddressBook: " + addressBookName);
            addressBook.getContactSaver().forEach((personName, contact) ->
                    System.out.println("Person: " + personName + ", Contact: " + contact.toString()));
        });
        return;
    }


}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cruiseship{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String customerName;
        int cabinNum = 0;
        String[] CabinStatus = new String[12];

        initialise(CabinStatus);

        while (true) {
            System.out.println(" ");
            System.out.println("        Welcome to our Cruise Ship Boarding   ");
            System.out.println("                     Main Menu                  ");
            System.out.println("Choose from the following letters: ");
            System.out.println(" ");
            System.out.println("V: View all Cabins");
            System.out.println("A:Adds customer to cabin");
            System.out.println("-------------------- Additional options --------------- ");
            System.out.println("E: Display Empty cabins");
            System.out.println("D: Delete customer from cabin");
            System.out.println("F: Find cabin from customer name ");
            System.out.println("S: Store program data into file  ");
            System.out.println("L: Load program data from file ");
            System.out.println("O: View passengersOrdered alphabetically by name ");

            System.out.println(" Q: Exit the Program");

            System.out.println(" ");
            System.out.print("Enter letter of your choice:  ");
            System.out.println(" ");
            String choice = input.next();

            switch (choice) {
                case "A":
                    System.out.println("Enter Cabin Number: ");
                    cabinNum = input.nextInt();
                    if (CabinStatus[cabinNum].equals("e")) {
                        System.out.println("Enter Passenger Name: ");
                        customerName = input.next();
                        AddCustomerToCabin(CabinStatus, cabinNum, customerName);
                    } else {
                        System.out.println("This cabin is already booked.");
                    }
                    break;
                case "V":
                    //Display all cabins status
                    ViewsAllCabins(CabinStatus);
                    break;
                case "E":
                    //Display empty cabins
                    DisplayEmptyCabins(CabinStatus);
                    break;
                case "D":
                    System.out.println("Enter Room Number: ");
                    cabinNum = input.nextInt();
                    DeleteCustomerFromCabin(CabinStatus, cabinNum);
                    break;
                case "F":
                    System.out.println("Enter Customer Name: ");
                    customerName = input.next();
                    //Find cabin from customer name
                    FindCabinFromCustomerName(CabinStatus, customerName);
                    break;
                case "S":
                    //Store program data into file
                    StoreProgramDataIntoFile(CabinStatus);
                    break;
                case "L":
                    //Load program data from file
                    LoadProgramDataFromFile(CabinStatus);
                    break;
                case "O":
                    AlphabeticallyByName(CabinStatus);
                    break;

                case"Q":
                    System.out.println("Thanks for Visiting the Cruise Ship Boarding ");

                    return;
                default:
                    System.out.println("Invalid input\n\n");
                    break;
            }
        }
    }

    //Initializing
    private static void initialise(String[] CabinStatus) {
        for (int i = 0; i < 12; i++) {
            CabinStatus[i] = "e";
        }
    }

    //Display all cabins status
    private static void ViewsAllCabins(String[] CabinStatus) {
        for (int x = 0; x < 12; x++) {
            if (CabinStatus[x].equals("e")) {
                System.out.println("Cabin "+x +" Is Empty.");
            } else {
                System.out.println("Cabin "+x  +" occupied by "+CabinStatus[x]);
            }
        }
    }

    //Book the cabin with the customer name
    public static void AddCustomerToCabin(String[] CabinStatus, int cabin_number, String customer_name) {
        CabinStatus[cabin_number] = customer_name;
    }

    //Display empty cabins
    private static void DisplayEmptyCabins(String[] CabinStatus) {
        for (int x = 0; x < 12; x++) {
            if (CabinStatus[x].equals("e")) {
                System.out.println("Cabin "+ x +" Is Empty.");
            }
        }
    }

    //Delete customer from cabin
    private static void DeleteCustomerFromCabin(String[] CabinStatus, int cabin_number) {

        CabinStatus[cabin_number] = "e";
    }

    //Find cabin from customer name
    private static void FindCabinFromCustomerName(String[] CabinStatus, String customer_name) {
        for (int x = 0; x < 12; x++) {
            if (CabinStatus[x].equals(customer_name)) {
                System.out.println("Cabin "+x+" occupied by "+CabinStatus[x]);
            }
        }
    }

    //Store program data into file
    private static void StoreProgramDataIntoFile(String[] CabinStatus ) {
        try {
            FileWriter inputData = new FileWriter("C:\\Users\\3C Tech\\Desktop\\w1867684- JAVA CW\\w1867684_arrays_only\\output1.txt");
            for (int y = 1; y < 12; y++) {
                if (CabinStatus[y].equals("e")) {
                    inputData.write("Cabin "+y+" Is Empty.\n");
                } else {
                    inputData.write("Cabin "+y+" occupied by "+CabinStatus[y]+"\n");
                }
            }
            inputData.close();
        } catch (IOException e) {
            System.out.println("An Error Occurred.");
        }
    }

    //Load program data from file
    private static void LoadProgramDataFromFile(String[] CabinStatus) {
        try {
            int line_count = 0;
            File inputFile = new File("C:\\Users\\3C Tech\\Desktop\\w1867684- JAVA CW\\w1867684_arrays_only\\output1.txt");
            Scanner outputData = new Scanner(inputFile);
            String file_line;
            while (outputData.hasNext()) {
                file_line = outputData.nextLine();
                System.out.println(file_line);
                line_count++;
            }
            outputData.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    //View passengersOrdered alphabetically oder
    private static void AlphabeticallyByName(String[] CabinStatus) {
        // Copying elements of shipCabin[] to cabin[]
        String cabin[] = CabinStatus.clone();

        int count = 0;
        for (int x = 0; x < cabin.length; x++) {
            if (cabin[x].equals("e")) {
                continue;
            } else {
                count++;
            }
        }

        String sort_array[] = new String[count];

        // Copying elements of shipCabin[] to sort_array[]
        for (int l =0; l < count; l++) {
            for (int m = 0; m < cabin.length; m++) {
                if (cabin[m].equals("e")) {
                    continue;
                } else {
                    sort_array[l] = cabin[m];
                    cabin[m] = "e";
                    break;
                }
            }
        }

        String temp;
        for (int i = 0; i < sort_array.length; i++) {
            for (int j = i + 1; j < sort_array.length; j++) {

                // compare one string with other strings
                if (sort_array[i].compareTo(sort_array[j]) > 0) {
                    temp = sort_array[i];
                    sort_array[i] = sort_array[j];
                    sort_array[j] = temp;
                }
            }
        }

        // print output array
        System.out.println(
                "The names in alphabetical order are: ");
        for (int n = 0; n < sort_array.length; n++) {
            System.out.println(sort_array[n]);
        }
    }
}

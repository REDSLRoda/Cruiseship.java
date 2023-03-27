
import java.io.*;
import java.util.*;

public class Cruiseship {
    Cabin[] cabins;

    static String[] currentCabinStatus = new String[12];

    Passenger[] passengers;
    Passenger2[] passengers2;
    Passenger3[] passengers3;


    String[] customers = new String[36];


    public Cruiseship() {
        this.cabins = new Cabin[12];
        this.passengers = new Passenger[1];
        this.passengers2 = new Passenger2[1];
        this.passengers3 = new Passenger3[1];





        initialize(this.cabins);
        initialize2(this.passengers);
        initialize3(this.passengers2);
        initialize4(this.passengers3);


    }


    private void initialize(Cabin[] cabins) {
        for (int i = 0; i < cabins.length; i++) {
            cabins[i] = new Cabin(i);
        }


    }

    private void initialize2(Passenger[] passengers) {
        for (int i = 0; i < passengers.length; i++) {
            String firstName = "-";
            String lastName = " ";
            int expenses = 0;
            passengers[i] = new Passenger(firstName, lastName, expenses);

        }

    }
    private void initialize3(Passenger2[] passengers2) {
        for (int i = 0; i < passengers2.length; i++) {
            String firstName2 = "-";
            String lastName2 = " ";
            int expenses2 = 0;
            passengers2[i] = new Passenger2(firstName2, lastName2, expenses2);

        }

    }
    private void initialize4(Passenger3[] passengers3) {
        for (int i = 0; i < passengers3.length; i++) {
            String firstName3 = "-";
            String lastName3 = " ";
            int expenses3 = 0;
            passengers3[i] = new Passenger3(firstName3, lastName3, expenses3);

        }

    }


    public void addPassenger01Details(String firstName, String lastName, int expenses ) {
        for (Passenger passenger : passengers) {
            passenger.setFirstName(firstName);
            passenger.setLastName(lastName);
            passenger.setExpenses(expenses);
        }

    }

    public void addPassenger02Details(String firstName2, String lastName2, int expenses2 ) {
        for (Passenger2 passenger2 : passengers2) {
            passenger2.setFirstName2(firstName2);
            passenger2.setLastName2(lastName2);
            passenger2.setExpenses2(expenses2);
        }


    }

    public void addPassenger03Details(String firstName3, String lastName3, int expenses3 ) {
        for (Passenger3 passenger3 : passengers3) {
            passenger3.setFirstName3(firstName3);
            passenger3.setLastName3(lastName3);
            passenger3.setExpenses3(expenses3);
        }

    }


    public void viewAdditionalDetails() {

        for (Passenger passenger : passengers) {


            System.out.println("First Name: " + passenger.getFirstName());
            System.out.println("Last Name: " + passenger.getLastName());
            System.out.println("Expenses: " + passenger.getExpenses());

            break;

        }
        for (Passenger2 passenger2 : passengers2) {


            System.out.println("First Name: " + passenger2.getFirstName2());
            System.out.println("Last Name: " + passenger2.getLastName2());
            System.out.println("Expenses: " + passenger2.getExpenses2());

            break;

        }
        for (Passenger3 passenger3 : passengers3) {


            System.out.println("First Name: " + passenger3.getFirstName3());
            System.out.println("Last Name: " + passenger3.getLastName3());
            System.out.println("Expenses: " + passenger3.getExpenses3());

            break;

        }
        System.out.println("Total Expenses for cabin are:  ");
        for (Passenger passenger : passengers)
            for (Passenger2 passenger2 : passengers2)
                for (Passenger3 passenger3 : passengers3)

                    System.out.println(passenger.getExpenses()+passenger2.getExpenses2()+ passenger3.getExpenses3());


    }
    public void displayCruiserCabins() {

        for (Cabin cabin : cabins) {


            System.out.println("Cabin Number " + cabin.getCabinNumber());
            System.out.println("Empty : " + cabin.isEmpty());
            System.out.println(" ");


        }
        for (int i = 0; i < currentCabinStatus.length; i++) {
            if (currentCabinStatus[i] == null) {


            } else {
                System.out.println("Passenger in Cabin "  + ": " + currentCabinStatus[i]);
            }

        }
    }



    public void displayEmptyCabins() {
        System.out.println("--------Empty Cabins--------");


        for (Cabin cabin : cabins) {
            if (cabin.isEmpty()) {

                System.out.println("Cabin Number " + cabin.getCabinNumber());
            }

        }

    }
    public static void FindCabinFromCustomerName(String[] currentCabinStatus, String customerName) {
        for (int x = 0; x < 12; x++) {
            if (currentCabinStatus[x].equals(customerName)) {
                System.out.println("Cabin "+(x+1)+" occupied by "+currentCabinStatus[x]);
            }
        }
    }

    public void addPassenger(int cabinNumber, String customerName) {
        cabins[cabinNumber].setEmpty(false);

        customers(customerName);


        currentCabinStatus(cabinNumber, customerName);



    }

    private void currentCabinStatus(int cabinNumber, String customerName) {
    }

    private void customers(String customerName) {
    }


    public void removePassenger(int cabinNumber){
        cabins[cabinNumber-1].setEmpty(true);
        {
            Cabin.remove(cabinNumber-1);
        }



    }

    public void FindCabinFromCustomer(String[] cabinNum, String customerName) {
        for (int x = 0; x < 12; x++) {
            if (cabinNum[x].equals(customerName)) {
                System.out.println("Cabin " + x + " occupied by " + cabinNum[x]);
            }
        }
    }

    public void sortPassengers() {

        System.out.println(customers);
    }

    public void storeDetails() {
        try {
            FileWriter inputData = new FileWriter("C:\\Users\\3C Tech\\Desktop\\w1867684- JAVA CW\\w1867684_classes\\output2.txt");
            for (int y = 1; y < 12; y++) {
                if (currentCabinStatus[y].equals("e")) {
                    inputData.write("Cabin "+y+" Is Empty.\n");
                } else {
                    inputData.write("Cabin "+y+" occupied by "+currentCabinStatus[y]+"\n");
                }
            }
            inputData.close();
        } catch (IOException e) {
            System.out.println("An Error Occurred.");
        }
    }
    public void loadData() {
        try {
            int line_count = 0;
            File inputFile = new File("C:\\Users\\3C Tech\\Desktop\\w1867684- JAVA CW\\w1867684_classes\\output2.txt");
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
    public static void main(String[] args) {


        Cruiseship cruiseShip = new Cruiseship();
        Scanner input = new Scanner(System.in);


        while (true) {
            System.out.println(" ");
            System.out.println("        Welcome to our Cruise Ship Boarding   ");
            System.out.println("                     Main Menu                  ");
            System.out.println("Choose from the following letters: ");
            System.out.println(" ");
            System.out.println("V: View all Cabins");
            System.out.println("A:Adds customer to cabin");
            System.out.println("T:Total expenses of cabin");
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
            String press = input.next();


            switch (press) {
                //to check the current cabin status
                case "V":
                    cruiseShip.displayCruiserCabins();
                    break;


                case "E": //viewing all empty cabins
                    cruiseShip.displayEmptyCabins();
                    break;


                case "A":
                    //adding a passenger

                    System.out.println(" Types ");
                    System.out.println("Type 1 for cabin 1");
                    System.out.println("Type 2 for cabin 2");
                    System.out.println("Type 3 for cabin 3");
                    System.out.println("Type 3 for cabin 4");
                    System.out.println("Type 3 for cabin 5");
                    System.out.println("Type 3 for cabin 6");
                    System.out.println("Type 3 for cabin 7");
                    System.out.println("Type 3 for cabin 8");
                    System.out.println("Type 3 for cabin 9");
                    System.out.println("Type 3 for cabin 10");
                    System.out.println("Type 3 for cabin 11");
                    System.out.println("Type 3 for cabin 12");
                    System.out.println("You can only add 3 passengers to single cabin");
                    System.out.print("Enter the Number:  ");
                    System.out.println(" ");
                    int number = input.nextInt();

                    switch (number) {
                        case 1:
                            if (currentCabinStatus[0] == null) {

                                System.out.println("You are assigned to cabin 1");
                                System.out.println("Enter First Name: ");
                                String firstName = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses = input.nextInt();


                                cruiseShip.addPassenger(0, firstName);
                                cruiseShip.addPassenger01Details(firstName, lastName, expenses);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName2 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName2 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses2 = input.nextInt();


                                cruiseShip.addPassenger(0, firstName2);
                                cruiseShip.addPassenger02Details(firstName2, lastName2, expenses2);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName3 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName3 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses3 = input.nextInt();


                                cruiseShip.addPassenger(0, firstName3);
                                cruiseShip.addPassenger03Details(firstName3, lastName3, expenses3);


                            }

                            break;

                        case 2:
                            if (currentCabinStatus[1] == null) {

                                System.out.println("You are assigned to cabin 2");
                                System.out.println("Enter First Name: ");
                                String firstName = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses = input.nextInt();


                                cruiseShip.addPassenger(1, firstName);
                                cruiseShip.addPassenger01Details(firstName, lastName, expenses);

                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName2 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName2 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses2 = input.nextInt();


                                cruiseShip.addPassenger(1, firstName2);
                                cruiseShip.addPassenger02Details(firstName2, lastName2, expenses2);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName3 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName3 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses3 = input.nextInt();


                                cruiseShip.addPassenger(1, firstName3);
                                cruiseShip.addPassenger03Details(firstName3, lastName3, expenses3);
                            }

                            break;

                        case 3:
                            if (currentCabinStatus[2] == null) {


                                System.out.println("Enter First Name: ");
                                String firstName = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses = input.nextInt();


                                cruiseShip.addPassenger(2, firstName);
                                cruiseShip.addPassenger01Details(firstName, lastName, expenses);

                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName2 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName2 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses2 = input.nextInt();


                                cruiseShip.addPassenger(2, firstName2);
                                cruiseShip.addPassenger02Details(firstName2, lastName2, expenses2);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName3 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName3 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses3 = input.nextInt();


                                cruiseShip.addPassenger(2, firstName3);
                                cruiseShip.addPassenger03Details(firstName3, lastName3, expenses3);
                            }
                            break;

                        case 4:
                            if (currentCabinStatus[3] == null) {


                                System.out.println("Enter First Name: ");
                                String firstName = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses = input.nextInt();


                                cruiseShip.addPassenger(3, firstName);
                                cruiseShip.addPassenger01Details(firstName, lastName, expenses);

                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName2 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName2 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses2 = input.nextInt();


                                cruiseShip.addPassenger(3, firstName2);
                                cruiseShip.addPassenger02Details(firstName2, lastName2, expenses2);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName3 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName3 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses3 = input.nextInt();


                                cruiseShip.addPassenger(3, firstName3);
                                cruiseShip.addPassenger03Details(firstName3, lastName3, expenses3);
                            }
                            break;

                        case 5:
                            if (currentCabinStatus[4] == null) {


                                System.out.println("Enter First Name: ");
                                String firstName = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses = input.nextInt();


                                cruiseShip.addPassenger(4, firstName);
                                cruiseShip.addPassenger01Details(firstName, lastName, expenses);

                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName2 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName2 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses2 = input.nextInt();


                                cruiseShip.addPassenger(4, firstName2);
                                cruiseShip.addPassenger02Details(firstName2, lastName2, expenses2);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName3 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName3 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses3 = input.nextInt();


                                cruiseShip.addPassenger(4, firstName3);
                                cruiseShip.addPassenger03Details(firstName3, lastName3, expenses3);
                            }
                            break;

                        case 6:
                            if (currentCabinStatus[5] == null) {


                                System.out.println("Enter First Name: ");
                                String firstName = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses = input.nextInt();


                                cruiseShip.addPassenger(5, firstName);
                                cruiseShip.addPassenger01Details(firstName, lastName, expenses);

                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName2 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName2 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses2 = input.nextInt();


                                cruiseShip.addPassenger(5, firstName2);
                                cruiseShip.addPassenger02Details(firstName2, lastName2, expenses2);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName3 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName3 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses3 = input.nextInt();


                                cruiseShip.addPassenger(5, firstName3);
                                cruiseShip.addPassenger03Details(firstName3, lastName3, expenses3);
                            }
                            break;

                        case 7:
                            if (currentCabinStatus[6] == null) {


                                System.out.println("Enter First Name: ");
                                String firstName = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses= input.nextInt();


                                cruiseShip.addPassenger(6, firstName);
                                cruiseShip.addPassenger01Details(firstName, lastName, expenses);

                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName2 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName2 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses2 = input.nextInt();


                                cruiseShip.addPassenger(6, firstName2);
                                cruiseShip.addPassenger02Details(firstName2, lastName2, expenses2);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName3 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName3 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses3 = input.nextInt();


                                cruiseShip.addPassenger(6, firstName3);
                                cruiseShip.addPassenger03Details(firstName3, lastName3, expenses3);
                            }
                            break;

                        case 8:
                            if (currentCabinStatus[7]== null) {


                                System.out.println("Enter First Name: ");
                                String firstName = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses = input.nextInt();


                                cruiseShip.addPassenger(7, firstName);
                                cruiseShip.addPassenger01Details(firstName, lastName, expenses);

                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName2 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName2 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses2 = input.nextInt();


                                cruiseShip.addPassenger(7, firstName2);
                                cruiseShip.addPassenger02Details(firstName2, lastName2, expenses2);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName3 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName3 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses3 = input.nextInt();


                                cruiseShip.addPassenger(7, firstName3);
                                cruiseShip.addPassenger03Details(firstName3, lastName3, expenses3);
                            }
                            break;

                        case 9:
                            if (currentCabinStatus[8] == null) {


                                System.out.println("Enter First Name: ");
                                String firstName = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses = input.nextInt();


                                cruiseShip.addPassenger(8, firstName);
                                cruiseShip.addPassenger01Details(firstName, lastName, expenses);

                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName2 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName2 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses2 = input.nextInt();


                                cruiseShip.addPassenger(8, firstName2);
                                cruiseShip.addPassenger02Details(firstName2, lastName2, expenses2);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName3 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName3 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses3 = input.nextInt();


                                cruiseShip.addPassenger(8, firstName3);
                                cruiseShip.addPassenger03Details(firstName3, lastName3, expenses3);
                            }
                            break;

                        case 10:
                            if (currentCabinStatus[9] == null) {


                                System.out.println("Enter First Name: ");
                                String firstName = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses = input.nextInt();


                                cruiseShip.addPassenger(9, firstName);
                                cruiseShip.addPassenger01Details(firstName, lastName, expenses);

                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName2 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName2 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses2 = input.nextInt();


                                cruiseShip.addPassenger(9, firstName2);
                                cruiseShip.addPassenger02Details(firstName2, lastName2, expenses2);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName3 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName3 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses3 = input.nextInt();


                                cruiseShip.addPassenger(9, firstName3);
                                cruiseShip.addPassenger03Details(firstName3, lastName3, expenses3);
                            }
                            break;

                        case 11:
                            if (currentCabinStatus[10] == null) {


                                System.out.println("Enter First Name: ");
                                String firstName = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses = input.nextInt();


                                cruiseShip.addPassenger(10, firstName);
                                cruiseShip.addPassenger01Details(firstName, lastName, expenses);

                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName2 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName2 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses2 = input.nextInt();


                                cruiseShip.addPassenger(10, firstName2);
                                cruiseShip.addPassenger02Details(firstName2, lastName2, expenses2);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName3 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName3 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses3 = input.nextInt();


                                cruiseShip.addPassenger(10, firstName3);
                                cruiseShip.addPassenger03Details(firstName3, lastName3, expenses3);
                            }
                            break;

                        case 12:
                            if (currentCabinStatus[11] == null) {


                                System.out.println("Enter First Name: ");
                                String firstName = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses = input.nextInt();


                                cruiseShip.addPassenger(11, firstName);
                                cruiseShip.addPassenger01Details(firstName, lastName, expenses);

                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName2 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName2 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses2 = input.nextInt();


                                cruiseShip.addPassenger(11, firstName2);
                                cruiseShip.addPassenger02Details(firstName2, lastName2, expenses2);


                                System.out.println("Next passenger ");

                                System.out.println("Enter First Name: ");
                                String firstName3 = input.next();

                                System.out.println("Enter Last Name: ");

                                String lastName3 = input.next();

                                System.out.println("Enter Expenses: ");

                                int expenses3 = input.nextInt();


                                cruiseShip.addPassenger(11, firstName3);
                                cruiseShip.addPassenger03Details(firstName3, lastName3, expenses3);
                            }
                            break;


                    }
                    break;
                case "T":
                    cruiseShip.viewAdditionalDetails();

                    break;

                case "D"://remove a person

                    int cabinNumber = input.nextInt();
                    System.out.println("Enter Cabin number (1-12) to remove : ");
                    cabinNumber = input.nextInt();
                    cruiseShip.removePassenger(cabinNumber);
                    System.out.println("The Passenger successfully removed");


                    break;

                case "F":
                    System.out.println("Enter Customer Name: ");
                    String customerName = input.next();
                    //Find cabin from customer name


                    FindCabinFromCustomerName(currentCabinStatus, customerName);

                case "O":
                    cruiseShip.sortPassengers();


                    break;

                case "S":
                    cruiseShip.storeDetails();


                    break;

                case "L":
                    cruiseShip.loadData();

                    break;


                case "Q":
                    System.out.println("Thank You for visiting our Cruise Ship");

                    return;
                default:
                    System.out.println("You have entered a Wrong Value");

            }


        }


    }




}




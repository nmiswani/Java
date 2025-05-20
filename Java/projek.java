import java.io.*;
import java.util.*;

class projek {
    public static void main(String[] args) throws IOException {
        int choice = 0;
        double Total = 0;
        int user;
        double Payment;
        double price;

        Scanner a = new Scanner(System.in);  // solved problems

        try {
            BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
            String username;
            String password;
            String cont;
            String Username = "PROJEKOOP";
            String Password = "12345";

            System.out.println("************************************");
            System.out.println("\t     WELCOME    \t");
            System.out.println("************************************");

            System.out.println("\nPlease enter your information");

            for (int i = 0; i == i; i++) {
                System.out.print("Enter Username : ");
                username = obj.readLine();

                if (username.equals(Username)) {
                    break;
                } else {
                    System.out.println("==Your Username is INVALID ... \n");

                    if (i == 2) {
                        System.out.println("\nToo Many Attempts... Please Wait...\n");
                        Timer t = new Timer();
                        t.run();
                        i = i - 3;
                        System.out.println("Your Username -> " + Username);
                        continue;
                    } else {
                        System.out.println("Continue?... 1 - YES  \n\t     2 - No\n");
                        cont = obj.readLine();
                        int CONT = Integer.parseInt(cont);
                        if (CONT == 2) {
                            System.exit(0);
                        } else {
                            continue;
                        }
                    }
                }
            }

            for (int i = 0; i == i; i++) {
                System.out.print("Enter Password : ");
                password = obj.readLine();

                if (password.equals(Password)) {
                    break;
                } else {
                    System.out.println("==Your Password is INVALID ... \n");

                    if (i == 2) {
                        System.out.println("\nToo Many Attempts... Please Wait...\n");
                        Timer t = new Timer();
                        t.run();
                        i = i - 3;
                        System.out.println("Your Username -> " + Username);
                        System.out.println("Your Password -> " + Password);
                        continue;
                    } else {
                        System.out.println("Continue?... 1 - YES  \n\t     2 - No\n");
                        cont = obj.readLine();
                        int CONT = Integer.parseInt(cont);
                        if (CONT == 2) {
                            System.exit(0);
                        } else {
                            continue;
                        }
                    }
                }
            }

            System.out.println("\nLog In Successful!!!");
            System.out.println("\nWELCOME TO KEPCI RESTAURANT");
            System.out.println("\n     FOOD LIST   \n");
            System.out.println(" 1 - BURGER AYAM   - RM 4.00     4 - BURGER DAGING       - RM 4.50");
            System.out.println(" 2 - BURGER ARNAB  - RM 12.00    5 - BURGER IKAN SIAKAP  - RM 6.00");
            System.out.println(" 3 - WAFFLE CREAMS - RM 5.50     6 - FRIES MUNCHY        - RM 3.00");
            System.out.println(" *****              PRESS 0 TO PROCEED TO PAYMENT           ***** ");

            do {
                System.out.println("\nEnter the code of the food you want: ");
                choice = a.nextInt();

                if (choice == 0) break;

                System.out.println("Please Enter the quantity of the food: ");
                int quantity = a.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("BURGER AYAM");
                        price = 4.00;
                        break;
                    case 2:
                        System.out.println("BURGER ARNAB");
                        price = 12.00;
                        break;
                    case 3:
                        System.out.println("WAFFLE CREAMS");
                        price = 5.50;
                        break;
                    case 4:
                        System.out.println("BURGER DAGING");
                        price = 4.50;
                        break;
                    case 5:
                        System.out.println("BURGER IKAN SIAKAP");
                        price = 6.00;
                        break;
                    case 6:
                        System.out.println("FRIES MUNCHY");
                        price = 3.00;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        price = 0;
                        break;
                }

                double itemTotal = quantity * price;
                Total += itemTotal;
                System.out.println("Item total: RM " + itemTotal);

            } while (choice != 0);

            System.out.println("\nPLEASE CHOOSE BELOW ORDER. DO YOU WANT TO DINE IN OR DELIVERY?");
            System.out.println("PRESS 1 - DINE IN OR 2 - DELIVERY");
            int option = a.nextInt();

            if (option == 1) {
                Payment = Total;
                System.out.println("The actual payment: RM " + Payment);
            } else {
                Payment = (Total * 0.1) + Total;
                System.out.println("The actual payment with delivery: RM " + Payment);
            }

        } catch (InputMismatchException ob) {
            System.out.println("\nYou Entered A Letter. Please Enter Numbers Only.");
        }
    }
}

class Timer extends Thread {
    public void run() {
        try {
            Thread thread = new Thread();
            System.out.println("Please wait for 10 sec... Processing...");
            for (int i = 10; i >= 1; i--) {
                thread.sleep(650);
                System.out.println(i);
            }
        } catch (InterruptedException ie) {
        }
    }
}

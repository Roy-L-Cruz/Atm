package atm;

import java.util.Scanner;

public class Atm {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int num = 10;
        int ind = 0;
        //array
        String em[] = new String[num];
        String pass[] = new String[num];
       
        do {
           
            System.out.println("[1] Register\n[2] Login");
            System.out.print("Enter choice: ");
            int choice = inp.nextInt();
            inp.nextLine();
            String eCheck = "";
            int att=1;
           
           
            Main:
            switch (choice){
                case 1:
                    do {
                        System.out.println("Register");
                        System.out.print("Enter Email: ");
                        String rEmail = inp.nextLine();
                        System.out.print("Enter Password: ");
                        String rPass = inp.nextLine();
                       
                        boolean check = rPass.matches(".*[A-Z].*") && rPass.matches(".*[!-@].*");
                       if (rEmail.contains("@") && rEmail.contains(".") && (rPass.length())>=8 && check ) {
                            System.out.println("REGISTRATION SUCCESS");
                            em[ind] = rEmail;
                            pass[ind] = rPass;
                            eCheck += rEmail;
                            ind++;
                            att=1;
                            break Main;
                        }else{
                            if (rEmail.contains("@")) {
                                System.out.println("Password at least 8 characters,\n1 small letter and capital letter");
                            }else{
                           
                            System.out.println("INVALID ");
                            System.out.println("Email must have @ symbol and . \nEmail must be unique\nPassword at least 8 characters,\n1 small letter and capital letter");
                            att++;
                            }
                        }
                    } while (att!=3);
                    break;
                case 2:
                    System.out.println("Login");
                   
                    do {
                        System.out.println("Enter Account Number: ");
                        int no = inp.nextInt();
                        inp.nextLine();
                        System.out.println("Enter Email: ");
                        String lEmail = inp.nextLine();
                        System.out.println("Enter Password: ");
                        String lPass = inp.nextLine();
                       
                       
                        if (lEmail.contains(em[no]) && lPass.contains(pass[no])) {
                            System.out.println("LOGIN SUCCESS");
                            att=1;
                            break Main;
                        }else{
                            System.out.println("INVALID CREDENTIALS");
                            att++;
                        }
                   
                    } while (att!=3);
                    break;
            }
        } while (true);
    
    }
}
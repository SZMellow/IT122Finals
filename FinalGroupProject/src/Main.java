import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        CsvReader Bsit = new CsvReader("src\\BSIT.csv");
        Scanner userInput = new Scanner(System.in);
        int choice = 0;
        while(true){
            System.out.print("My Checklist Monitoring Application\n" +
                    "<1> Show subjects for each school term\n" +
                    "<2> Show subjects with grades for each term\n" +
                    "<3> Enter grades for subjects recently finished\n" +
                    "<4> Edit a course\n" +
                    "<5> Print entire spreadsheet\n" +
                    "<6> Quit\n" +
                    "\nEnter choice:");
            try {
                while (choice < 1 || choice > 6){
                    choice = Integer.parseInt(userInput.nextLine());
                    if (choice < 1 || choice > 6){
                        System.out.println("Invalid input. Number must be a value from 1-6");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number");
            switch(choice) {
                case 1:

                case 2:

                case 3:

                case 4:

                case 5:
                    Bsit.printSpreadsheet();
                case 6:
                    break;
                default:
                    System.out.println("error. input or code error");
            }
        }
    }
}
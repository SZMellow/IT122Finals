import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
  CsvReader Bsit = new CsvReader("src/BSIT.csv");
        Scanner userInput = new Scanner(System.in);
        int choice, cont;
        do {
            choice = 0;
            System.out.print("My Checklist Monitoring Application\n" +
                    "<1> Show subjects for each school term\n" +
                    "<2> Show subjects with grades for each term\n" +
                    "<3> Enter grades for subjects recently finished\n" +
                    "<4> Edit a course\n" +
                    "<5> Print entire spreadsheet\n" +
                    "<6> Quit\n");
            while (choice < 1 || choice > 6) {
                try {
                    System.out.print("Enter choice: ");
                    choice = Integer.parseInt(userInput.nextLine());
                    if (choice < 1 || choice > 6) {
                        System.out.println("Invalid input. Number must be a value from 1-6");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number");
                }
            }
                switch (choice) {
                    case 1:
                   Bsit.showSubjectsByTerm();
                    case 2:
                        Bsit.showSubjectsWithGrades();
                    case 3:
                        AddCourse courseAdder =	new	AddCourse();
                        courseAdder.addExtraCourse(userInput, "/src/BSIT.csv");
                    case 4:
 System.out.print("Enter course code: ");
    String targetCourse = userInput.nextLine();

    System.out.print("Enter new title: ");
    String newTitle = userInput.nextLine();

    new editCourse().editingCourse(
            "/src/BSIT.csv",
            targetCourse,
            newTitle
    );

                    case 5:
                        Bsit.printSpreadsheet();
                    case 6:
                        break;
                    default:
                        System.out.println("error. input or code error");
                }
            System.out.println("Press Enter to Continue");
            userInput.nextLine();
            } while (choice !=6);
        }
    }

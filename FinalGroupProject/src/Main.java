import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        CsvReader Bsit = new CsvReader("src\\BSIT.csv");
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
                 System.out.println(" --- Displaying Subjects Grouped by School Term --- ");
                 try {
                     reader = new BufferedReader(new FileReader(csv_file));

                     String currentYear = "";
                     boolean isShortTerm = false;

                     while ((line = reader.readLine()) != null) {

                         String[] columns = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                         // Skip empty rows
                         if (columns.length < 3) continue;

                         // 1. Detect Year
                         if (columns.length > 1 && columns[1].toUpperCase().contains("YEAR")) {
                             currentYear = columns[1].trim();
                             System.out.println("" + "=".repeat(40));
                             System.out.println("         " + currentYear);
                             System.out.println("=".repeat(40));
                             isShortTerm = false;
                             continue;
                         }


                         if (columns.length > 2 && columns[2].equalsIgnoreCase("Short Term")) {
                             isShortTerm = true;
                             System.out.println("\n[ SHORT TERM ]");
                             continue;
                         }


                         if (columns.length > 2 && columns[2].equalsIgnoreCase("1st Semester")) {
                             System.out.println("\n[ 1ST SEMESTER ]");
                             continue;
                         }

                         // 4. Get Subjects
                         String code1 = columns[2].trim();
                         String title1 = (columns.length > 3) ? columns[3].trim() : "";


                         boolean isValid1 = !code1.isEmpty() && !code1.equalsIgnoreCase("Course No.") && !code1.equalsIgnoreCase("TOTAL UNITS");

                         if (isValid1) {
                             System.out.printf("%-10s | %-50s\n", code1, title1);
                         }

                         if (!isShortTerm && columns.length > 8) {
                             String code2 = columns[7].trim();
                             String title2 = columns[8].trim();

                             boolean isValid2 = !code2.isEmpty() && !code2.equalsIgnoreCase("Course No.") && !code2.equalsIgnoreCase("2nd Semester") && !code2.equalsIgnoreCase("TOTAL UNITS");

                             if (isValid2) {

                                 System.out.printf("   (2nd Sem) %-10s | %s\n", code2, title2);
                             }
                         }
                     }
                 } catch (Exception e) {
                     System.out.println("Error reading the file: " + e.getMessage());
                 }
                 break;

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
            System.out.println("Press Enter to Continue");
            userInput.nextLine();
            } while (choice !=6);
        }
    }

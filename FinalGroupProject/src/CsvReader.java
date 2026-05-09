//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CsvReader {
    private int year, term;
    private Scanner fileReader;
    private String line;
    private String cells[];
    private File spreadsheet;
    //private JFrame frame;


    public CsvReader(String filePath) throws FileNotFoundException {
        this.year = 1;
        this.term = 1;
        this.spreadsheet = new File(filePath);
        this.fileReader = new Scanner(spreadsheet);
        this.line = null;
    }
    public CsvReader(String filePath, int year, int term) throws FileNotFoundException {
        this.year = year;
        this.term = term;
        this.spreadsheet = new File(filePath);
        this.fileReader = new Scanner(spreadsheet);
        this.line = null;
    }
    public String getFilepath(){
        return this.spreadsheet.getPath();
    }
    public void printSpreadsheet(){
        //prints the whole csv file with a format
        while(fileReader.hasNext()){
            line = fileReader.nextLine();
            cells = line.split(",");
            for(int i = 0 ; i < cells.length ; i++){
                System.out.printf("%-75s",cells[i]);
            }
            System.out.println();
        }
    }
    public void showSubjects(){
        //TBD
        System.out.printf("%-20s%s\n%-10s%-30s%s", "Year = "+year, "Term = "+term, "Course No.", "Descriptive title", "Units");
        switch (year){
            case 1:

            case 2:

            case 3:

            case 4:

        }
    }
    public void showSubjectsWithGrades() throws FileNotFoundException {
        fileReader = new Scanner(spreadsheet);
        Scanner scn = new Scanner(System.in);
        String currentYearHeader = "FIRST YEAR";

        while (fileReader.hasNextLine()) {
            line = fileReader.nextLine();
            // splits this with -1
            cells = line.split(",", -1);

            // if line is empty then continue
            if (cells.length < 5) continue;

            // Update the Year (Checks Column 1)
            if (!cells[1].isEmpty() && cells[1].contains("YEAR")) {
                currentYearHeader = cells[1];
            }

            // Detect Term Headers and Pause
            if (line.contains("1st Semester")) {
                printTermHeader(currentYearHeader, "1st Semester");
            } else if (line.contains("2nd Semester")) {
                System.out.println("\nPress Enter to see 2nd Semester...");
                scn.nextLine();
                printTermHeader(currentYearHeader, "2nd Semester");
            } else if (line.contains("Short Term")) {
                System.out.println("\nPress Enter to see Short Term...");
                scn.nextLine();
                printTermHeader(currentYearHeader, "Short Term");
            }


            // We check cells.length > 4 to safely access cells[2], [3], and [4]
            if (cells.length >= 5) {
                String courseNo = cells[2].trim();
                String title = cells[3].trim();
                String units = cells[4].trim();

                // Only print if it's an actual course (not empty, not a header, not total)
                if (!courseNo.isEmpty() && !courseNo.equalsIgnoreCase("Course No.") && !title.contains("TOTAL UNITS")) {
                    displayRow(courseNo, title, units);
                }
            }


            //if 2nd Sem row, you need to check the higher indices:
            if (cells.length >= 10) {
                String courseNo2 = cells[7].trim();
                String title2 = cells[8].trim();
                String units2 = cells[9].trim();

                if (!courseNo2.isEmpty() && !courseNo2.equalsIgnoreCase("Course No.") && !title2.contains("TOTAL UNITS")) {
                    displayRow(courseNo2, title2, units2);
                }
            }
        }
    }
    public void showSubjectsByTerm() {
        try {
            fileReader = new Scanner(spreadsheet);
            String currentYearHeader = "FIRST YEAR";

            while (fileReader.hasNextLine()) {
                line = fileReader.nextLine();
                cells = line.split(",", -1);

                if (cells.length < 5) continue;

                if (!cells[1].isEmpty() && cells[1].contains("YEAR")) {
                    currentYearHeader = cells[1];
                }

                if (line.contains("1st Semester")) {
                    printTermHeader(currentYearHeader, "1st Semester");
                } else if (line.contains("2nd Semester")) {
                    printTermHeader(currentYearHeader, "2nd Semester");
                } else if (line.contains("Short Term")) {
                    printTermHeader(currentYearHeader, "Short Term");
                }

                if (cells.length >= 5) {
                    String courseNo = cells[2].trim();
                    String title = cells[3].trim();
                    String units = cells[4].trim();

                    if (!courseNo.isEmpty() && !courseNo.equalsIgnoreCase("Course No.") && !title.contains("TOTAL UNITS")) {
                        displayRow(courseNo, title, units);
                    }
                }

                if (cells.length >= 10) {
                    String courseNo2 = cells[7].trim();
                    String title2 = cells[8].trim();
                    String units2 = cells[9].trim();

                    if (!courseNo2.isEmpty() && !courseNo2.equalsIgnoreCase("Course No.") && !title2.contains("TOTAL UNITS")) {
                        displayRow(courseNo2, title2, units2);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    private void printTermHeader(String year, String term) {
        System.out.println("==============================================================");
        System.out.println(year + " - " + term);
        System.out.println("==============================================================");
        System.out.printf("%-14s %-43s %s\n",
                "Course No.", "Descriptive Title", "Units");
        System.out.println("--------------------------------------------------------------");
    }

    private void displayRow(String code, String title, String units) {
        System.out.printf("%-15s %-45s %s\n",
                code, title, units);
    }
    /*public void makeSpreadsheet() {
        JFrame frame = new JFrame("Simple Spreadsheet");

        // Column headers
        String[] columns = {"A", "B", "C", "D"};
        // Initial empty data (10 rows)
        Object[][] tableSize = new Object[100][4];

        DefaultTableModel model = new DefaultTableModel(tableSize, columns);
        JTable table = new JTable(model);

        // Wrap table in scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }*/
}

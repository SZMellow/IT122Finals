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

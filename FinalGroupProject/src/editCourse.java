import java.io.*;
import java.util.Scanner;

public class editCourse{

    public void editingCourse(String file, String targetCourse, String newTitle){
        File originalFile = new File(file);
        File tempFile = new File("src\\\\BSIT_temporary.csv");

                try (Scanner courseChanger = new Scanner(originalFile);
                    PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {

                        while (courseChanger.hasNextLine()) {
                            String line = courseChanger.nextLine();

                            String[] columns = line.split(",", -1);
                            if (columns.length > 3 && columns[2].trim().equalsIgnoreCase(targetCourse)) {
                                columns[3] = newTitle; // The edit happens here
                                line = String.join(",", columns); // Reconstruct the line
                            }
                            writer.println(line);
                        }
                } catch (IOException e) {
                    System.out.println("Error: " + e.getMessage());
                    return;
                }

        if (originalFile.delete()) {
            tempFile.renameTo(originalFile);
            System.out.println("Course [" + targetCourse + "] updated successfully.");
        } else {
            System.out.println("Error: File is currently in use. Close the CSV file first.");
        }
    }
}

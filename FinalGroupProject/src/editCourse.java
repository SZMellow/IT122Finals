import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class editCourse {

    public void editingCourse(String file, String targetCourse, String newTitle) {
        File originalFile = new File(file);
        File tempFile = new File(originalFile.getParent(), "BSIT_temporary.csv");

        boolean found = false;

        try (
            Scanner courseChanger = new Scanner(originalFile);
            PrintWriter writer = new PrintWriter(new FileWriter(tempFile))
        ) {
            while (courseChanger.hasNextLine()) {
                String line = courseChanger.nextLine();
                String[] columns = line.split(",", -1);

                if (columns.length > 3 && columns[2].trim().equalsIgnoreCase(targetCourse.trim())) {
                    columns[3] = newTitle;
                    line = String.join(",", columns);
                    found = true;
                }

                writer.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        if (!found) {
            tempFile.delete();
            System.out.println("Course [" + targetCourse + "] not found.");
            return;
        }

        if (originalFile.delete()) {
            if (tempFile.renameTo(originalFile)) {
                System.out.println("Course [" + targetCourse + "] updated successfully.");
            } else {
                System.out.println("Error: Could not rename temporary file.");
            }
        } else {
            System.out.println("Error: File is currently in use. Close the CSV file first.");
        }
    }
}

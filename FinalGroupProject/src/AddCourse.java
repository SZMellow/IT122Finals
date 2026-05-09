import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AddCourse {

	public void addExtraCourse(Scanner input, String filePath) {
		System.out.print("Enter Course No: ");
		String courseNo = input.nextLine();

		System.out.print("Enter Descriptive Title: ");
		String descTitle = input.nextLine();

		System.out.print("Enter Units: ");
		String units = input.nextLine();

		System.out.print("Enter Pre-requisite: ");
		String prerequisite = input.nextLine();

		// format course data into csv file's format
		String newCourse = ",," + courseNo + "," + descTitle + "," + units + "," + prerequisite + ",,,,,,,,,,,";

		// append new course to csv file
		try (FileWriter fw = new FileWriter(filePath, true);
			 PrintWriter pw = new PrintWriter(fw)) {
			pw.println(newCourse);
			System.out.println("Course added successfully!");
		} catch (IOException e) {
			System.out.println("An error occurred while adding the course: " + e.getMessage());
		}
	}
}

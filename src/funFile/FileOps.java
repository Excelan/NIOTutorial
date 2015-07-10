package funFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

import funPath.PathOps;


/***
 * 
 * @author Excel
 * demonstrates some of features of Files (PLURAL)
 * with STATIC methods
 *
 */
public class FileOps {
	public static void run() {
		
		Path file = Paths.get("../NIOTutorial/fakeDir/IamFile.txt").toAbsolutePath().normalize();
		
		PathOps.printPathInfo(file, "Some random hardcoded file");
		
		// check if file exists
		try {
			file = file.toRealPath();
			System.out.format("file %s exists%n", file.toString());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			try {
				System.out.format("Trying to create %s%n", file.toString());
				createSomeFile(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.exit(1);
			}
		}

		try {
			Files.copy(file, file.getParent().resolve("bkp_1"));
			deleteSomeFile(file);
		} catch (Exception e2) {
			System.out.println(e2.getStackTrace());
		}

		
		
		
		// try to create if not exists
		// exit if couldn't create
		// delete if file exists
		
		
		
		
		
	}
	
	public static boolean deleteSomeFile(Path file) throws IOException {
		System.out.format("deleting %s ...%n", file);
		return Files.deleteIfExists(file);
		// return Files.delete(file);
	}

	private static void createSomeFile(Path file) throws IOException {
		System.out.println("Creating file and writing ABC");
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file.toString())))) {
			out.println("ABC");
		}
	}
	
	
	
}

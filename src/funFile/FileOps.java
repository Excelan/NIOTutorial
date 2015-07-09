package funFile;

import java.nio.file.Path;
import java.nio.file.Paths;

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
		Path file = Paths.get("../NIOTutorial/IamFile.txt").toAbsolutePath().normalize();
		PathOps.printPathInfo(file, "Some random hardcoded file");
		
		
	}
}

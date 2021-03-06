package funPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclFileAttributeView;

public class PathOps {
	
	
	// None of these methods requires that the file corresponding
	// to the Path exists.
	// Microsoft Windows syntax
	

	// Solaris syntax
	// Path path = Paths.get("/home/joe/foo");

	public static void run() {
		printPathInfo(Paths.get("C:\\home\\joe\\foo"), "Absolute Path example:");
		printPathInfo(Paths.get("sally\\bar"), "Relative Path example:");
		
		//some real path
		Path path = Paths.get("..//NIOTutorial//src//funPath//package-info.java");
		printPathInfo(path, "Real, redundant path example:");
		printPathAcl(path);		
		funRealPath(path);
	}
	
	public static void printPathAcl(Path file) {
		System.out.format("*** ACL for %s%n", file);
		AclFileAttributeView aclFileAttributes = Files.getFileAttributeView(
		    file, AclFileAttributeView.class);

		try {
			for (AclEntry aclEntry : aclFileAttributes.getAcl()) {
			    System.out.println(aclEntry.principal() + ":");
			    System.out.println(aclEntry.permissions() + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printPathInfo(Path path, String comment) {
		System.out.println(comment);
		System.out.format("toString: %s%n", path.toString());
		System.out.format("getFileName: %s%n", path.getFileName());
		System.out.format("getName(0): %s%n", path.getName(0));
		System.out.format("getNameCount: %d%n", path.getNameCount());
		System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
		System.out.format("getParent: %s%n", path.getParent());
		System.out.format("getRoot: %s%n", path.getRoot());
		System.out.format(" Conversions:%n");
		
		System.out.format("path.toUri(): %s%n", path.toUri());
		System.out.format("path.toAbsolutePath(): %s%n", path.toAbsolutePath());
		
		System.out.println(" Path is iterable:");
		for (Path name: path.toAbsolutePath()) {
		    System.out.println(name);
		}
		System.out.println();
		//combining / join
		System.out.format("%s%n", path.resolve("bar-is-joined-by-resolve"));
		// Passing an absolute path to the resolve method returns the passed-in path:
		System.out.format("%s%n", path.resolve("c://absolute-bar-is-joined-by-resolve"));
		
		System.out.println();
	}
	
	public static void funRealPath(Path path) {
		try {
			/*
			 * The toRealPath method returns the real path of an existing file. This method performs several operations in one:
			 * If true is passed to this method and the file system supports symbolic links, this method resolves any symbolic links in the path.
			 * If the Path is relative, it returns an absolute path.
			 * If the Path contains any redundant elements, it returns a path with those elements removed.
			 */
			
		    Path fp = path.toRealPath();
		    printPathInfo(fp, "After path.toRealPath():");
		    
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", path);
		    // Logic for case when file doesn't exist.
		} catch (IOException x) {
		    System.err.format("%s%n", x);
		    // Logic for other sort of file error.
		}
	}
	
}

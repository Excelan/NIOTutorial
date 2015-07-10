package funTree;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TreeOps {
	public static void run() {
		TreeVisitorOver treeWalker = new TreeVisitorOver();
		try {
			Files.walkFileTree(Paths.get("."), treeWalker);
		} catch (Exception e) {
			System.out.format("Что-то пошло не так");
		}
		
	}

}

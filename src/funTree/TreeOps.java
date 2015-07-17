package funTree;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TreeOps implements Runnable {
	public TreeOps() {
		Thread t = new Thread(this, "TreeOps thread");
		t.start();
		}
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
		TreeVisitorOver treeWalker = new TreeVisitorOver();
		try {
			Files.walkFileTree(Paths.get("."), treeWalker);
		} catch (Exception e) {
			System.out.format("Что-то пошло не так");
		}
		
	}

}

import funFile.FileOps;
import funPath.PathOps;
import funTree.TreeOps;

public class Run {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int example = 0;
		try {
			example = Integer.parseInt(args[0]);
			runExample(example);
		} catch (NumberFormatException e) {
			System.out.println("Integer argument is required");
			
			

			/*
			int choice = 0;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			do {
				System.out.format("1. Path example");
				System.out.format("2. File example");
				System.out.format("3. Tree example");
				System.out.format("0. EXIT");
				
				 try{
					 choice = Integer.parseInt(br.readLine());
			        } catch(NumberFormatException nfe) {
			            System.err.println("Invalid Format!");
			        }
				
			} while (choice!=0);
			*/
			
			
			
		}
	}

	private static void runExample(int example) {
		System.out.format("EXAMPLE %s%n", example);
		switch (example) {
		case 1: PathOps.run(); break;
		case 2: FileOps.run(); break;
		case 3: TreeOps.run(); break;
		default:
			break;
		}
	}
}
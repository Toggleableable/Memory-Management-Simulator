import java.util.ArrayList;
import java.util.List;

// The main class, containing the main function and the input to give to the program
public class Driver {
	
	// The input to be given to the program
	private static String input =
			  "1, [30;0;12], 40, 23\n"
			+ "1, 0, -20\n"
			+ "2, 40, 161, 80 \n"
			+ "3, 50, 25, 13\n"
			+ "4, 16, 59, 30\n"
			+ "5, 50, 120, 32, 12\n"
			;
	
	public static void main(String[] args) {
		
		List<Process> processes = new ArrayList<Process>();
		List<Integer>[] parsedInput;
		
		// Parse each line and add to processes
		for (String line : input.split("\n")) {
			parsedInput = Parse.parseInput(line);
			
			processes.add(new Process(parsedInput));
			
		}
		
		// Instantiate MemoryManager and call allocateMemory
		MemoryManager manager = new MemoryManager(processes);
		
		System.out.println("Start A.1");
		manager.allocateMemory();
		System.out.println("End A.1");

	}

}

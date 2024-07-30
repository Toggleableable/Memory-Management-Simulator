import java.util.ArrayList;
import java.util.List;

// Defines the memory management procedure
public class MemoryManager {

	// The processes that need to be run
	private List<Process> processes;
	
	// The total number of bytes available in memory
	public static final int TOTAL_BYTES = 1024;
	
	/**
	 * @param processes The list of processes to be run
	 */
	public MemoryManager(List<Process> processes) {
		super();
		this.processes = processes;
	}
	
	/**
	 * Uses the list of processes and the Memory class to process them
	 */
	public void allocateMemory() {
		
		// Initialises the memory
		Memory memory = new Memory();
		int base;
		List<Integer> activeProcesses = new ArrayList<Integer>();
		
		// Iterates over each process in the list
		for (Process process : processes) {
			
			// Checks if the current processes reference number matches that of an active process
			if (!activeProcesses.contains(process.getRefNum())) {
				
				// Iterates through the segments in the process and inserts them into memory and the SegmentTable
				for (Segment segment : process.getSegments()) {
					base = memory.insert(segment);
					process.addToTable(segment, base);
				}
				// Adds the process to the list of currently active processes
				activeProcesses.add(process.getRefNum());
			}
			
			else {
				// Iterates through the processes to find the one with the matching reference number
				for (Process matchingProcess : processes) {
					if (matchingProcess.getRefNum() == process.getRefNum()) {
						
						// Updates the process with the same reference number with the relevant info
						matchingProcess.updateSegments(process.getSegments());
						
						TableItem item;
						Block block;
						
						// Iterates through the segments in the process
						for (Segment segment : matchingProcess.getSegments()) {
							
							// Gets the previous data from the segment
							item = matchingProcess.getTable().getTableItem(segment.getNum());
							block = memory.getBlock(item.getBase());
							
							// Updates the data for the segment
							block.updateSize();
							process.addToTable(segment, block.getStart());
						}
						
						break;
					}
				}
			}
			
		}
		
		
		memory.outputMemory();
	}
	
}

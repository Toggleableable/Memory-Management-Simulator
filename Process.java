import java.util.ArrayList;
import java.util.List;

// Defines processes
public class Process {

	// The reference number of the process
	private int refNum;
	
	// The list of segments associated with the process
	private List<Segment> segments;
	
	// The SegmentTable linking the segments to their location in memory
	private SegmentTable table;
	
	/**
	 * @param input The parsed input to define the process
	 */
	public Process(List<Integer>[] input) {
		super();
		
		// Gets the reference number from the input
		this.refNum = input[0].get(0);
		
		// Uses the rest of the input to create a list of segments associated with the process
		this.segments = new ArrayList<Segment>();
		for (int i = 1; i < input.length; i++) {
			this.segments.add(new Segment(i - 1, input[i]));
		}
		
		this.table = new SegmentTable();
		
	}
	
	/**
	 * @return the segments associated with this process
	 */
	public List<Segment> getSegments() {
		return this.segments;
	}
	
	/**
	 * Links the segment to the location in memory via the SegmentTable
	 * @param segment The segment to be added to the table
	 * @param base The start location of the segment in memory
	 */
	public void addToTable(Segment segment, int base) {
		this.table.addItem(segment.getNum(), new TableItem(base, segment.getSize()));
	}

	/**
	 * @return the reference number of the process
	 */
	public int getRefNum() {
		return this.refNum;
	}
	
	/**
	 * @return the SegmentTable
	 */
	public SegmentTable getTable() {
		return this.table;
	}
	
	/**
	 * Updates the segments in the process if the input contains multiple processes with the same reference number
	 * @param updatedSegments The list of updated segments
	 */
	public void updateSegments(List<Segment> updatedSegments) {
		
		// Iterates through the updated segments and updates the segments
		for (int i = 0; i < updatedSegments.size(); i++) {
			if (updatedSegments.get(i).getSize() != 0) {
				this.segments.get(i).changeSize(updatedSegments.get(i));				
			}
		}
	}
	
}

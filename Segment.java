import java.util.List;

// Defines a segment, the parts that make up processes
public class Segment {

	// The number to refer to this segment as
	private int num;
	
	// The size of the segment
	private int size;
	
	// Indicator of whether the segment requires write permission
	private int write;
	
	// A list of the segments that this segment shares memory with
	private List<Integer> sharingWith;
	
	/**
	 * @param num The number to refer to this segment as
	 * @param info The info parsed by the parser and with the irrelevant information removed
	 */
	public Segment(int num, List<Integer> info) {
		super();
		
		this.num = num;
		
		// Gets the size of the segment from the info list
		this.size = info.get(0);
		
		// Checks the rest of the info list and writes the relevant values to the write and sharingWith variables
		if (info.size() > 1) {
			info.remove(0);
			this.write = info.get(0);
			if (info.size() > 1) {
				info.remove(0);
				this.sharingWith = info;
			}
		}
		
		else this.write = 1;
	}

	/**
	 * @return the reference number of the segment
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @return the size of the segment
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Updates the size of the current segment using the updated segment from the updated process
	 * @param updatedSegment The segment to update the size of this segment with
	 */
	public void changeSize(Segment updatedSegment) {
		
		// Checks that the size of the segment does not go below zero and updates the size
		if (this.size + updatedSegment.getSize() >= 0) {
			this.size += updatedSegment.getSize();
		}
	}
	
	
	
}

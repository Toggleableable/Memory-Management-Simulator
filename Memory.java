// Defines memory that is being used to store blocks (and hence segments) in the program
public class Memory {

	// The first and last blocks in memory
	private Block start;
	private Block end;
	
	/**
	 * Initially creates one empty block to the size of memory given by TOTAL_BYTES
	 */
	public Memory() {
		super();
		this.start = new Block(0, MemoryManager.TOTAL_BYTES - 1);
		this.end = this.start;
	}
	
	/**
	 * Inserts the segment given into the next available space in memory
	 * @param segment The segment to put in memory
	 * @return the start location of the block
	 */
	public int insert(Segment segment) {
		
		// Loops through the blocks in memory to find an empty one of suitable size
		Block next = this.start;
		while (next.hasSegment() || next.getSize() < segment.getSize()) {
			next = next.getNext();
		}
		
		// Allocates the segment to the first suitable block found and returns the start location of it
		next.allocate(segment);
		return next.getStart();
	}
	
	/**
	 * @param location The location in memory of the block wanted to get
	 * @return the block at the given location in memory
	 */
	public Block getBlock(int location) {
		
		// Iterate through the blocks in memory to find the one at the specified location
		Block next = this.start;
		while (next.getStart() < location) {
			next = next.getNext();
		}
		
		// If the block is found, return it
		if (next.getStart() == location) {
			return next;
		}
		return null;
		
		
	}
	
	/**
	 * Outputs the information in the memory in a human readable format
	 */
	public void outputMemory() {
		Block next = this.start;
		
		while (next != null) {
			if (next.hasSegment()) {
				System.out.println("Size: " + next.getSize() + " Location: " + next.getStart() + "-" + next.getEnd());
			}
			else System.out.println("Empty: " + next.getStart() + "-" + next.getEnd());
			next = next.getNext();
		}
	}
	
}

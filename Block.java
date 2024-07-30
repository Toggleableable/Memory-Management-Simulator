//Define blocks, the containers for segments in memory
public class Block {

	// The segment associated with the current block
	private Segment segment;
	
	// The start location of the block in memory
	private int start;
	
	// The end location of the block in memory
	private int end;
	
	// The next block in memory
	private Block next;
	
	// The previous block in memory
	private Block previous;
	
	/**
	 * @param start The start location of the block in memory
	 * @param end The end location of the block in memory
	 */
	public Block(int start, int end) {
		super();
		this.segment = null;
		this.start = start;
		this.end = end;
		this.next = null;
		this.previous = null;
	}
	
	/**
	 * @param start The start location of the block
	 * @param end The end location of the block
	 * @param next The next block in memory
	 * @param previous The previous block in memory
	 */
	public Block(int start, int end, Block next, Block previous) {
		super();
		this.segment = null;
		this.start = start;
		this.end = end;
		this.next = next;
		this.previous = previous;
	}
	
	/**
	 * Allocates the segment given to the block if possible
	 * @param segment The segment to allocate to this block
	 */
	public void allocate(Segment segment) {
		
		// Check if block already has a segment allocated
		if (this.segment != null) {
			System.out.println("Block already in use.");
			return;
		}
		
		// Check if block has enough memory for the segment
		if (segment.getSize() > this.getSize()) {
			System.out.println("Not enough memory in block");
			return;
		}
		
		// Set the segment var to the segment given and call fillSpace
		this.segment = segment;
		fillSpace();
		
	}
	
	/**
	 * Correct the size of the block, based on the segment associated with it
	 */
	private void fillSpace() {
		if (this.segment.getSize() < this.getSize()) {
			this.next = new Block(this.start + this.segment.getSize(), this.end, this.next, this);
			this.end = this.start + this.segment.getSize() - 1;
		}
	}
	
	/**
	 * @return the next block in memory
	 */
	public Block getNext() {
		return this.next;
	}
	
	/**
	 * @param next The next block in memory
	 */
	private void setNext(Block next) {
		this.next = next;
	}
	
	/**
	 * @return the segment associated with this block
	 */
	public Segment getSegment() {
		return this.segment;
	}

	/**
	 * @return the start location of this block
	 */
	public int getStart() {
		return this.start;
	}

	/**
	 * @return the end location of this block
	 */
	public int getEnd() {
		return this.end;
	}
	
	/**
	 * @return the size of this block
	 */
	public int getSize() {
		return this.end - this.start + 1;
	}
	
	/**
	 * @return true if the block has a segment associated with it, or otherwise return false
	 */
	public boolean hasSegment() {
		if (this.segment == null) return false;
		return true;
	}
	
	/**
	 * Make sure that the size of the block is consistent with the size of the segment
	 */
	public void updateSize() {
		
		// Check if the size of the block is different to the size of the segment
		if (this.getSize() != this.segment.getSize()) {
			// Check if the segment fits in the block and if so, call fillSpace
			if (this.start + this.segment.getSize() <= this.end) {
				fillSpace();
			}
			// If segment doesn't fit, print message
			else System.out.println("Not enough space to add to block");
		}
		
		// Check if the size of the block is zero and if so, remove it
		if (this.getSize() == 0) {
			this.previous.setNext(next);
		}
	}
	
	
	
}

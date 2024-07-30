// Defines the items to be associated with a segment in the SegmentTable
public class TableItem {
	
	// The start value of the segment in memory
	private int base;
	
	// The limit of the segment in memory
	private int limit;
	
	/**
	 * @param base The start value of the segment in memory
	 * @param limit The limit of the segment in memory
	 */
	public TableItem(int base, int limit) {
		super();
		this.base = base;
		this.limit = limit;
	}

	/**
	 * @return the start value of the segment in memory
	 */
	public int getBase() {
		return base;
	}

	/**
	 * @return the limit of the segment in memory
	 */
	public int getLimit() {
		return limit;
	}
	
}

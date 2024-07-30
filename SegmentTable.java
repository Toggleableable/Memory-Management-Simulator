import java.util.HashMap;
import java.util.Map;

// Defines the table associating the reference number of segments with TableItems and therefore segments with their location in memory
public class SegmentTable {

	// The map of the segment reference number to the TableItem associated with it
	private Map<Integer, TableItem> items;
	
	public SegmentTable() {
		super();
		this.items = new HashMap<Integer, TableItem>();
	}
	
	/**
	 * Adds the given segment reference number and TableItem to the items map
	 * @param segmentNum The reference number of the segment
	 * @param item The TableItem to be associated with the segment
	 */
	public void addItem(Integer segmentNum, TableItem item) {
		this.items.put(segmentNum, item);
	}
	
	/**
	 * @param segmentNum The reference number of the segment
	 * @return the TableItem associated with the segment number
	 */
	public TableItem getTableItem(int segmentNum) {
		return this.items.get(segmentNum);
	}
	
}

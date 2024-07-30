import java.util.ArrayList;

public class Parse {
	
	private Parse() {}

	public static ArrayList<Integer>[] parseInput (String example){
		
		int size = example.split(",").length;
		
		//process id, followed by segments
		ArrayList<Integer>[] comp = new ArrayList[size];
		
		//init all
		for (int i =0; i<size; i++){
			comp[i] = new ArrayList<Integer>();
		}
		
	
		int index = 0;
		
		//split into pieces 
		for (String part:example.split(",")) {
			//remove space
			part = part.replace(" ", "");	
			
			
			//see if options are declared by looking at [ and ]
			if (part.contains("[") && part.contains("]")){
				part = part.replace(" ", "").replace("[", "").replace("]", "");
				
				//split into options: size, read-write bit, shared list
				for (String split:part.split(";")) {
					comp[index].add(Integer.parseInt(split));
				}
			}else {
				//no options presented
				comp[index].add(Integer.parseInt(part));
			}
			index++;
		}
		
		/*
		for (int i =0; i<size; i++){
			System.out.println(comp[i].toString());
		}
		*/
		
		return comp;
	}
	
}

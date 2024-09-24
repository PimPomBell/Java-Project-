import java.util.*;

public class Pattern {
	ArrayList<Work> num = new ArrayList<>();
	Scanner s = new Scanner(System.in);
	
	public Pattern() {
		
	}
	
	public void sort() {
		for(int i = 0; i<num.size(); i++) {
			for(int j = 0; j<num.size(); j++ ) {
				if(num.get(j).getAge()<num.get(j+1).getAge()) {
					
				}
			}
		}
	}
	public static void main(String[] args) {
		new Pattern();

	}

}

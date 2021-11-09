import java.util.ArrayList;

public class ArrayStack implements IStackable{
	private ArrayList<Integer> s2 = new ArrayList<Integer>();
	
	int sz2 = 0;
	int v2;
	public void push(int v2) {
		s2.add(v2);
    		sz2++;
	}

	
	public int pop() {
		sz2--;
		return s2.remove(s2.size()-1);
    		
	}
  
  
	public int size() {
		return sz2;
	}

}

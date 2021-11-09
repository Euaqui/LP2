import java.util.ArrayList;

public class ArrayStack implements IStackable{
	private ArrayList<Integer> s2 = new ArrayList<Integer>();
	
	int sz2 = 0;
	
	public void push(int v2) {
		s2.add(v2);
    		sz2++;
	}

	
	public int pop() {
		s2.remove(v2);
    		sz2--;
	}
  
  
	public int size() {
		return sz;
	}

}

import java.util.LinkedList;

public class LinkedStack implements IStackable{
  	private LinkedList<Integer> s1 = new LinkedList<Integer>();
	
  	int sz1 = 0;
  	int v1;

	public void push(int v1) {
		s1.addFirst(v1);
    		sz1++;
	}

	
	public int pop() {
		sz1--;
		return s1.removeFirst();	
	}
  
 	public int size() {
		return sz1;
	}

}

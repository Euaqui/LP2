import java.util.LinkedList;

public class LinkedStack implements IStackable{
  private LinkedList<Integer> s1 = new LinkedList<Integer>();
	
  int sz1 = 0;
  
	public void push(int v1) {
		s1.addFirst(v);
    		sz1++;
	}

	
	public int pop() {
		s1.removeFirst();
    		sz1--;
	}
  
  public int size() {
		return sz1;
	}

}

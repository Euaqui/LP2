import java.util.ArrayList;

public class ArrayStack implements IStackable{
	private ArrayList<Integer> s2 = new ArrayList<Integer>();
	
	@Override
	public void push(int v2) {
		s2.add(v2);
    sz2++;
	}

	@Override
	public int pop() {
		s2.remove(v2);
    
	}
  
  @Override
	public int size() {
		return ;
	}


}

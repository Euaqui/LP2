public interface IPayable{
	public void Pay(float value);
	public void Date(int day, int month);
}

public abstract class Bill implements IPayable{
	public int day, month;
	public float value;
	
	public class Bill( float value, int day, int month){
		this.day = day;
        	this.month = month;
        	this.value = value;
	}

	public void Pay(float value){
	//
	}

	public void Date(int day, int month){
	//
	}

	public boolean Process(boolean paid){
	//
	}
	
}

public class Card_Payment extends Bill{
	public void Pay(float value){
	//
	}

	public void Date(int day, int month){
	//
	}

	public boolean Process(boolean paid){
	//
	}
}

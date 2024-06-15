package encapsulation;

public class DataHidding {

	private int customerBalance = 50000;

	public void getBalance (int pin)
	{
		if(pin==1234)
		{
			System.out.println(customerBalance);
		}
		else
		{
			System.out.println("Enter pin is incorrect please try again later");
		}
	}
	public void setBalance(int pin, int amount)
	{
		if(pin==1234)
		{
			if(amount<customerBalance)
			{
				customerBalance = customerBalance - amount;
				System.out.println("Available balance is = "+customerBalance);
			}
			else
			{
				System.out.println("Incorret pin please try again later");
			}
		}
	}
	
	
}

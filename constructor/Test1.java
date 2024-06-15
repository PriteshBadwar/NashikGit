package constructor;

public class Test1 {
	
	public Test1 ()
	{
		System.out.println("Constructor is execuating");
	}
	
	public Test1(String a)
	{
		this();
		System.out.println("one argument constructor is execuating");
		System.out.println("value of one argument is "+a);
	}
	
	public Test1(int i,boolean b)
	{
		this("World");
		System.out.println("Two argument constructor is execuating");
		System.out.println("Value of two argument is "+i+" and "+b);
	}
	
public static void main(String[]args)
{
	Test1 u = new Test1();
	Test1 v = new Test1("Hello");
	Test1 t =new Test1(20, true);
	
	
}
}

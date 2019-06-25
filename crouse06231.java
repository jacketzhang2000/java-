class Base{
	{
	System.out.println("Base 的构造代码块1");
	}
	Base(){
		System.out.println("Base 的构造方法");
	}
	static {
		System.out.println("Base 的静态代码块1");
	}
	{
		System.out.println("Base 的构造代码块2");
	}
	static {
		System.out.println("Base 的静态代码块2");
	}
}
class Derived extends Base{
	
	{
	System.out.println("Derived 的构造代码块1");
	}
	Derived(){
		this(10);
		System.out.println("Derived 的无参构造方法");
	}
	Derived(int n){
		super();
		System.out.println("Derived 的有参构造方法");
	}
	static {
		System.out.println("Derived 的静态代码块1");
	}
	{
		System.out.println("Derived 的构造代码块2");
	}
	static {
		System.out.println("Derived 的静态代码块2");
	}
}
public class crouse06231{
	public static void main (String[] args){
		System.out.println("开始");
		new Derived();
		new Derived();
		System.out.println("结束");
	}
}










class Base{
	void method(){
		System.out.println("Base的method方法");
	}
	 static void staticMethod(){
		 System.out.println("Base的staticMethod方法");
	 }
}
class D1 extends Base{
	@Override
	void method(){
		System.out.println("D1的method方法");
	}
	 static void staticMethod(){
		 System.out.println("D1的staticMethod方法");
	 }
}
public class Poly {
	public static void main (String[] args){
		D1 d1=new D1();
		D1 d12=new D1();
		Base base = d12;
		//普通方法看后面的类型决定执行哪个方法
		
		base.method();           //D1.method()
		d1.method();             //D1.method()
		//静态方法看前面的类型
		base.staticMethod();      //base.staticMethod
		d1.staticMethod();        //D1.staticMethod

	}
}
/*
		D1的method方法
D1的method方法
Base的staticMethod方法
D1的staticMethod方法
*/
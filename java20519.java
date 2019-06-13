
	class Group {
	String name ;
	int num;
	Group (String n,int m){
		name=n;
		num=m;
	}
    void print(String welcom ){
	System.out.printf("%s %s 的%d 位同学们 %n",
	welcom,       //形参
	name,          //属性
	num
	);           //属性
	}
	}
	class B{
		int sum;
		B(int a,int b,int c){
			System.out.println(a+b+c);
			sum = a+b+c;
		}
		void print() {
			System.out.println(sum);
		}
	}
public class java20519 {//一个文件中只允许有一个public修饰类，这个类与文件名同名
	
	
	public static void main (String[] args){
	Group group =new Group("computer10",50);
	group.print("欢迎来到中国,");
	B b=new B(1,2,3);
	b.print();
}
}

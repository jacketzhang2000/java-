//父类：线性表
class List{
	//不能直接写成private,否则子类没有访问权限
	//protected 子类有权限，其他类没有权限
	protected int size;
	public int getSize(){
		return size;
	}
}

//顺序表，继承自线性表
class ArrayList extends List{
	private int[] array=new int[100];
	private int size;
	
	public void pushBack(int val){
		array[size++]=val;
	}
	public void setSize(int size){
		System.out.println(size);  //形参/局部变量  
		System.out.println(this.size);  //本身属性
		System.out.println(super.size);  //父类属性
	}
}
//链表，继承自线性表
class LinkedList extends List{
}
public class crouseTnherit{
	static void testcopyNode() {
		 new ArrayList().setSize(5);
	}
	public static void main (String[] args){
		ArrayList arraylist=new ArrayList();
		arraylist.pushBack(1);
		arraylist.pushBack(2);
		arraylist.pushBack(3);
		arraylist.pushBack(4);
	
	System.out.println(arraylist.getSize());
	testcopyNode();
	}
}
	
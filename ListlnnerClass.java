/**
通过内部类实现迭代
*/
interface lterator{
	//返回当前迭代器是否还有后续数据
	boolean hasNext();
	//1.返回当前数值，2.让游标后移一步
	int next();
}


//自带abstart
interface List{
	//插入
	void pushFront(int val);
	void pushBack(int val);
	void insert(int index,int val);
	/*
	//删除
	void popFront();
	void popBack();
	void erase(int index);
	
	//返回数据个数
	int size();
	
	//根据下表访问或修改
	int get (int index);
	void set(int index,int val);
	*/
	//遍历相当于display
	Iterator iterator();
}
interface RandomAccess {
}

abstract class AbstractList implements List{
	protected int size;
	
	@Override
	public void pushFront(int val){
		insertInternal(0,val);
	}
	
	@Override
	public void pushBack(int val){
		insertInternal(size,val);
	}
	
	@Override
	public void insert(int index,int val){
		if(index<0||index>size){
			System.out.println("下标错误");
			return ;
		}
		insertInternal(index,val);
	}
	abstract void insertInternal(int index,int val);
	
	public int size() {
		return size;
	}
}
//顺序表
class ArrayList extends AbstractList implements List{
	private class ArrayListIterator implements Iterator{
		private int currentIndex;
		//隐含着绑定着一个外部类的对象 ArrayList.this 
		
		ArrayListIterator(){
			currentIndex = 0;
		}
		
		@Override
		public boolean hasNext(){
			return currentIndex<size();
		}
		
			@Override
			public int next(){
				int val=array[currentIndex];
				currentIndex++;
				return val;
			}
	}
	
	private int[] array = new int[100];
	
	//顺序表的其他表现
	
	@Override 
	public Iterator iterator(){
		return new ArrayListIterator();
	}
	
	@Override 
	public void insertInternal(int index,int val){
		for(int i=size;i>index;i--){
			array[i]=array[i-1];
		}
		array[index]=val;
		size++;
	}

}

//链表
class LinkesList extends AbstractList implements List{
	private static class Node{
			private int val;
			private Node next=null;
			
			Node (int val,Node next){
				this.val=val;
				this.next=next;
			}
			Node (int val){
				this.val=val;
			}
		}	
		
	private Node head=null;
	
	@Override 
	protected void insertInternal(int index,int val){
		if (index==0){
			head=new Node(val,head);
		}else{
			Node cur=head;
			for (int i=0;i<index;i++){
				cur=cur.next;
			}
			cur.next=new Node(val,cur.next);
		}
		size++;
	}
	private class LinkedListIterator implements Iterator{
		private Node cur=head;
		
		@Override 
		public boolean hasNext(){
			return cur!=null;
		}
		 
		 @Override 
		 public int next(){
			 int val=cur.val;
			 cur=cur.next;
			 return val;
		 }
	}
	
	@Override 
	public Iterator iterator(){
		return new LinkedListIterator();
	}
}

public class ListlnnerClass {
	private static void testList(List list){
		list.pushBack(3);
		list.pushBack(2);
		list.pushFront(1);
		list.insert(2,20);
		//1，2，20，3
		
		Iterator it1=list.iterator();
		Iterator it2=list.iterator();
		
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
	}
	public static void main(String[] args){
		testList(new ArrayList ());
		System.out.println("================");
		testList(new LinkedList());
		
	}
}
















	
	
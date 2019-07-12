class Node {
	int val;
	Node next;
	Node (int val){
		this.val=val;
	}
}

class LinkedList{
	private int size;
	private Node head;
	public int size(){
		return size;
	}
	public void pushFront(int val){
		Node node =new Node(val);
		node.next=head;
		head=node;
		
		
		size++;
	}
	public void pushBack(int val){
		if(head==null){
			pushFront(val);
		}else{
		Node cur=head;
		while(cur.next!=null){
			cur=cur.next;
		}
		cur.next=new Node(val);
		
		size++;
		}
	}
	public void popFront(){
		if(head==null){
			System.out.println("异常处理");
		}else{
		head=head.next;
		size--;
		}
	}
	public void popBack(){
		if(head==null){
			System.out.println("异常处理");
		}
		else if (head.next==null){
			head=null;
			size=0;
		}
		else{
			Node lasttwo=null;
			while(lasttwo.next.next!=null){
				lasttwo=lasttwo.next;
			}
			lasttwo.next=null;
			
			size--;
		}
			
	}
}

class ArrayList{
	private int[] array;
	private int size;
	public ArrayList(){
		this(10);
	}
	public ArrayList(int capacity){
		array=new int[capacity];
	}
	public int size(){
		return size;
	}
	
	
	public void pushBack(int val){
		array[size++]=val;
		
	}
	public void pushFront(int val){
		for(int i=size;i>0;i--){
			array[i]=array[i-1];
		}
		array[0]=val;
		size++;
	}
	public void popBack(){
		if(size==0){
			System.out.println("异常处理");
		}
		else{
			size--;
	}
	}
	public void popFront(){
		if(size==0){
			System.out.println("异常处理");
		}
		else{
			for(int i=0;i<size-1;i++){
				array[i]=array[i+1];
			}
			size--;
	}
	}
}
	
public class list616{
	public static void main (String[] arg){ 
	    //链表
	    LinkedList linkedList=new LinkedList();
		linkedList.pushBack(1);
		linkedList.pushBack(2);
		linkedList.pushBack(3);
		linkedList.pushBack(4);
		//顺序表
		ArrayList arrayList =new ArrayList();
		arrayList.pushBack(1);
		arrayList.pushBack(2);
		arrayList.pushBack(3);
		arrayList.pushBack(4);
		int size=arrayList.size();
		System.out.println(arrayList.size());
		arrayList.size();
	}
}
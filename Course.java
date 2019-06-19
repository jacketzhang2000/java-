class Node {
	int val;	// 保存结点中的数据
	Node next;	// 指向下一个结点的引用
						// 特殊值 nul1
	Node(int val) {					
		this.val = val;
		this.next = null;
	}
}

class LinkedList {
	//逆置
	public Node reverseList(Node head){
		if (head==null){
		return null;
		}
		Node newNode = null;
	    Node cur=head;
		while (cur!=null){
			Node next=cur.next;
			cur.next=newNode;
			newNode=cur;
			cur=next;
		}
	return newNode;
	}
	//头插
	public Node pushFront(Node head,int val){
		Node newNode = new Node(val);
		newNode.next=head;
		head=newNode;
		return head;
	}
	public static Node popFront(Node head){
		if(head==null){
			System.out.println("删除异常");
			return null;
		}
		return head.next;
	}
	//尾删
	public static Node popBack(Node head){
		if(head==null){
			return null;
		}
		
		Node cur=head;
		if(cur.next==null){
			return null;
		}
		while(cur.next.next!=null){
			cur=cur.next;
		//找到倒数第二个节点
		}
	//倒数第二个节点的next指向null
	    cur.next=null;
		return head;
	}

}
public class Course {
		static void testreverseList(){
		//1.构建链表
		//2.调用函数
		//3.打印
		Node n1 =new Node(4);
		Node n2 =new Node(4);
		Node n3 =new Node(8);
		Node n4 =new Node(1);
		Node n5 =new Node(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		Node result=new LinkedList().reverseList(n1);
		for(Node cur=result;cur!=null;cur=cur.next){
			System.out.printf("%d——>",cur.val);
		}
		System.out.println();//起空格作用
		//random，cur打印出来的为地址形式
		
	}
	public static void display(Node head){
	for(Node cur=head;cur!=null;cur=cur.next){
		System.out.printf("%d-->",cur.val);
	}
	System.out.println("null");
	}
		public static void main (String[] args){
			Node head=null;
			head=new LinkedList().pushFront(head,3);
			head=new LinkedList().pushFront(head,4);
			head=new LinkedList().pushFront(head,8);
			head=new LinkedList().popBack(head);
			display(head);
			testreverseList();
			
		}
	}





























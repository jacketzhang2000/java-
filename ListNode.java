class Node{
	public int value;
	public Node next;
	
	
	public Node (int value ){
	this.value=value;
	this.next=null;
	}
}
public class ListNode{ 
	public static Node createLinkedList() {
		Node n1 = new Node(1);	// 首结点（头结点）
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(5);
		Node n5 = new Node(8);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		return n1;
	}
	public static Node createLinkedList2() {
		Node n1 = new Node(3);	// 首结点（头结点）
		Node n2 = new Node(6);
		Node n3 = new Node(8);
		Node n4 = new Node(9);
		Node n5 = new Node(10);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		return n1;
	}
	//头插
public static Node pushFront(Node head,int val){
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
	Node cur=head;
	if(head.next==null){
		return popFront(head);
		//找到倒数第二个节点
	}while(cur.next.next!=null){
		cur=cur.next;
		
	}
	//倒数第二个节点的next指向null
	cur.next=null;
	return head;
}
public static void display(Node head){
	for(Node cur=head;cur!=null;cur=cur.next){
		System.out.printf("%d-->",cur.value);
	}
	System.out.println("null");
}
public static Node FindkthToTail(Node head,int k){
	Node cur=head;
	int i=0;
	int j=0;
	while (cur.next!=null){
		i++;
		cur=cur.next;
	}
	if(i<k){
		return null;
	}
	else{
		cur=head;
		j=(i-k+1);
		while(j!=0){
			cur=cur.next;
			j--;
		}
		return cur;
	}
}
public static Node FindkthToTail2(Node head,int k){
	Node front=head;
	Node back=head;
	for(int i=0;i<k;i++){
		if(front==null){
			return null;
		}
		front=front.next;
	}
	while(front!=null){
		front=front.next;
		back=back.next;
	}
	return back;
}
public static Node getLast(Node head){
	Node  last=head;
	while(last.next!=null){
		last=last.next;
	}
	return last;
	}
//尾插
public static Node pushBack(Node head , int value ){
	if(head==null){
		return pushFront(head,value);
	}
	else{
		//申请新节点
		Node newNode =new Node (value);
		//找到最后一个节点
		Node last=getLast(head);
		last.next=newNode;
		
		return head;
	}
	}
//合并有序链表
public static Node mergeTowLists(Node L1,Node L2){
	Node cur1=L1;
	Node cur2=L2;
	Node result=null;
	while(cur1!=null&&cur2!=null){
		if(cur1.value<=cur2.value){
			pushBack(result,cur1.value);
		}
		else{
			pushBack(result,cur2.value);
		}
	}
	if(cur1==null){
		Node c2=cur2;
		while(c2!=null){
			Node next=c2.next;
			pushBack(result,cur2.value);
			c2=next;
		}
	}
	if(cur2==null){
		Node c1=cur1;
		while(c1!=null){
			Node next=c1.next;
			pushBack(result,cur1.value);
			c1=next;
		}
	}
	return result;
		
}
public static Node middleNode1(Node head){
	Node front=head;
	Node back=head;
	while(front!=null){
		front=front.next;
		if(front==null){
			break;
		}
		back=back.next;
		front=front.next;
	}
	return back;
}
public static Node middleNode(Node head){
	int length=0;
	Node cur=head;
	for(cur=head;cur!=null;cur=cur.next){
		length++;
	}
	cur=head;
	for(int i=0;i<length/2;i++){
		cur=cur.next;
	}
	return cur;
}
	
public static Node mergeTowLists1(Node L1,Node L2){
	if(L1==null){
		return L2;
	}
	if (L2==null){
		return L1;
	}
	Node c1=L1;
	Node c2=L2;
	Node result=null;
	Node last=null;
	
	while(c1!=null&&c2!=null){
		
		if (c1.value<=c2.value){
			Node next=c1.next;
		if(result==null){
			c1.next=result;
			result=c1;
		}else{
			c1.next=null;
			last.next=c1;
		}
		last=c1;
		c1=next;
		}else{
			Node next=c2.next;
			if(result==null){
			c2.next=result;
			result=c2;
		}else{
			c2.next=null;
			last.next=c2;
		}
		last=c2;
		c2=next;
		}
	}
	if(c1!=null){
		last.next=c1;
	}else{
		last.next=c2;
	}
	return result;
}
	
			

public static void main (String[] args){
		Node head=null;
		head= pushFront(head,1);
		head= pushFront(head,2);
		head= pushFront(head,3);
		display(head);
		Node h=middleNode(head);
		System.out.printf("%d%n",h.value);
		head= FindkthToTail(head,2);
		display(head);
		head= FindkthToTail2(head,2);
		display(head);
		Node L1=createLinkedList();
		Node L2=createLinkedList2();
		head= mergeTowLists1(L1,L2);
		display(head);
		
}
}
			
		
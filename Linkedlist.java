class Node{
	public int value;
	public Node next;
	
	
	public Node (int value ){
	this.value=value;
	this.next=null;
	}
}
public class Linkedlist{
	
	public static Node pushFront(Node head ,int value){
	//申请新节点
	Node newNode = new Node (value);
	//更新next
	newNode.next = head;
	//更新head
	return newNode;
	}
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
	public static Node getLast(Node head){
	Node  last=head;
	while(last.next!=null){
		last=last.next;
	}
	return last;
	}
	public static Node getLastLast(Node head){
		Node node=head;
		while(node.next.next!=null){
			node=node.next;
		}
		return node;
	}
	//头删
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
			System.out.println("删除异常");
			return null;
			
		}if (head.next==null){
			return null;
		}else{
			//1.找倒数第二个节点
			Node lastLast=getLastLast(head);
			//2.让倒数第二个节点的next指向null
			lastLast.next=null;
			//3.释放最后一个节点
			//不用做
			return head;
		}
	}
		
//打印 

public static void display(Node head){
	for(Node cur=head;cur!=null;cur=cur.next){
		System.out.printf("%d-->",cur.value);
	}
	System.out.println("null");
}
//反转字符串
public static Node reverseList1(Node head){
	Node cur=head;
	Node newNode=null;
	while(cur!=null){
		Node next=cur.next;
		cur.next=newNode;
		newNode=cur;
		cur=next;
	}
	return newNode;
}


public static Node reverseList(Node head){
	if(head==null){
		return null;
	}	
	Node n1=null;
	Node n2=head;
	
	while(n2!=null){
		Node n3=n2.next;
		n2.next=n1;
		n1=n2;
		n2=n3;
		if(n3!=null){
		n3=n3.next;
		}
	}
	return n1;
}
//移除链表元素
public static Node removeElments1(Node head,int val){
	if(head==null){
		return null;
	}
	Node cur=head.next;//?
	Node prev=head;
	while (cur!=null){
		if(cur.value==val){
			prev.next=cur.next;
		}else{//？
			prev=cur;
		}
		cur=cur.next;
	}
	if(head.value==val){
         head=head.next;
	}
	return head;
}
public static Node removeElments(Node head,int val){
	
	//if(head==null){
		//return null;
	//}
	Node newLIst= null;
	Node cur=head;
	Node last=null;
	while (cur!=null){
		Node next=cur.next;
		if(cur.value!=val){
			if(newLIst==null){
				cur.next=newLIst;
				newLIst=cur;
			}else{
				last.next=cur;
				}
			last=cur;
			}
		cur=next;	
	}
	if(last!=null){
		last.next=null;
	}
	return newLIst;
}					
	public static void main (String[] args){
		/*Node n1 = new Node (1);
		Node n2 = new Node (2);
		Node n3 = new Node (3);
		Node n4 = new Node (4);
		Node n5 = new Node (5);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n4.next=null;
		
		Node head = createLinkedlist;
		displayLinkedlist(n1);
		head=pushFront(head,100); 
		*/
		Node head=null;
		head= pushBack(head,1);
		head= pushBack(head,2);
		head= pushBack(head,3);
		display(head);
		head=pushFront(head,10);
		head=pushFront(head,20);
		head=pushFront(head,30);
		
		display(head);//[30,20,10,1,2,3);
		head=reverseList(head);
		display(head);//[3,2,1,10,20,30]
		head=removeElments(head,20);
		display(head);//[3,2,1,10,30]
		head=popFront(head);
		head=popFront(head);
		head=popFront(head);
		display(head);//[10,30]
		head=popBack(head);
		display(head);//[10]
	}
}
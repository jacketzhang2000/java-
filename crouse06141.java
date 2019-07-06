class Node {
	public int val;	// 保存结点中的数据
	public Node next;	// 指向下一个结点的引用
	public Node random;					// 特殊值 null
						
	public Node(int value) {
		this.val = val;
		this.next = null;
	}
}
class Solution {
	
	public Node removeValue(Node head,int value) {
		if(head==null){
			return null;
		}
		Node cur=head;
		Node newhead=null;
		Node last=null;
		while(cur!=null){
			Node next=cur.next;
			if(cur.val!=value){
				if(newhead==null){
					cur.next=newhead;
					newhead=cur;
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
	return newhead;
	}
	//2.逆置单链表
	public Node reverseList(Node head){
		if(head=null){
			return null;
		}
		Node newNode=null;
		Node cur=head;
		while(cur!=null){
			Node next=cur.next;
			cur.next=newhead;
			newhead=cur;
			cur=next;
		}
		return newNode;
		
	}
	//3.合并两个有序链表
	public Node merge(Node head1,Node head2){
		if(head1==null){
			return head2;
		}
		if(head2==null){
			return head1;
		}
		
		Node c1=head1;
		Node c2=head2;
		Node newNode = null;
		node last=null;
		while(c1!=null&&c2!=null){
			if(c1.val<=c2.val){
				Node next=c1.next;
				if(newhead==null){
					c1.next=newNode;
					newNode = c1;
				}
				else{
					c1.next=null;
					last.next=c1;
				}
				last=c1;
				c1=next;
			}
			else{
				Node next=c2.next;
				if(newhead==null){
					c2.next=newNode;
					newNode = c2;
				}
				else{
					c2.next=null;
					last.next=c2;
				}
				last=c2;
				c2=next;
			}
			if(c1!=null){
				last.next=c1;
			}
			else{
				last.next=c2;
			}
		}
			return newNode;
				
	}
	//4.删除有序链表中所有重复的结点
	public Node deleteDupLicate(Node head){
		if(head==null){
			return null;
		}
		Node prev=null;
		Node p1=head;
		Node p2=head.next;
		while(p2！=null){
			if(p1.val!=p2.val){
				prev=p1;
				p1=p2;
				p2=p2.next;
			}else{
				while(p2!=null&&p2.val==p1.val){
					p2=p2.next;
				}if(prev==null){
					head=p2;
				}else{
				prev.next=p2;
				}
				if(p2!=null){
					p1=p2;
					p2=p2.next;
				}
			}
		}
		return head;
	}
					
			
	
	
}

public class crouse06141{
}
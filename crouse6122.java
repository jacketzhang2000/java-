class ListNode {
	int val;
	ListNode next;
	
	ListNode(int val) {
		this.val = val;
	}
}
class Solution {
	//删除有序链表所有重复的结点
	public ListNode deleteDuplication (ListNode head){
		if(head==null){
			return null;
		}
		ListNode prev=null;
		ListNode c1=head;
		ListNode c2=head.next;
		while(c2!=null){
			if(c1.val!=c2.val){
				prev=c1;
				c1=c2;
				c2=c2.next;
			}
			else{
				while(c2!=null&&c2.val==c1.val){
				c2=c2.next;
				}
				if(prev==null){
					head=c2;
				}else{
				
				prev.next=c2;
				}
				if(c2!=null){
					c1=c2;
					c2=c2.next;
				}
				
			}
	
		}
			return head;
		
		
	}
	//判断链表是否为回文
	//求长度函数
	
	//逆置的函数
	public ListNode reverse (ListNode head){
		ListNode result=null;
		ListNode cur=head;
		while(cur!=null){
			ListNode next=cur.next;
			cur.next=result;
			result=cur;
			cur=next;
		}
	return result;
	}
	public ListNode getMid(ListNode head){
		//遍历链表的一半
		//遍历-头插
		//一半需要的长度
		ListNode fast=head;
		ListNode slow=head;
		while(fast!=null){
			fast=fast.next;
			if(fast==null){
				break;
			}
		fast=fast.next;
		slow=slow.next;
		}
		return slow;
	}
	public boolean chkPalindrome(ListNode A){
		ListNode mid=getMid(A);
		ListNode h2=reverse(mid);
		ListNode n1=A;
		ListNode n2=h2;
		while(n1!=null&&n2!=null){
		if(n1.val!=n2.val){
			return false;
		}
		n1=n1.next;
		n2=n2.next;
		}
		return true;
	}
	//找两交叉链表的第一个公共结点
		public int getLength(ListNode head){
		int length=0;
		for(ListNode cur=head;cur!=null;cur=cur.next){
			length++;
		}
		return length;
	}
	public ListNode getIntersectionNode(ListNode headA,ListNode headB){
		int len1=getLength(headA);
		int len2=getLength(headB);
		
		ListNode longList=headA;
		ListNode shortList=headB;
		int diff=len1-len2;
		if(len1<len2){
			longList=headB;
			shortList=headA;
			diff=len2-len1;
		}
		
		for(int i=0;i<diff;i++){
				longList=longList.next;
		}
		while(longList!=shortList){
			longList=longList.next;
			shortList=shortList.next;
		}
		return longList;
	}
	
		//带环链表入口点	
	public ListNode detectCycle(ListNode head){
	if(head==null){
		return null;
	}
	ListNode fast=head;
	ListNode slow=head;
	do{
		fast=fast.next;
		if(fast!=null){
			fast=fast.next;
			slow=slow.next;
		}
	}while(fast!=null&&fast!=slow);
	
	if(fast==null){
		return null;
	}
	ListNode p1=head;
	ListNode p2=slow;
	while(p1!=p2){
		p1=p2.next;
		p2=p2.next;
	}
	return p1;
	}
}
	public class crouse6122 {
	}
class ListNode {
	int val;
	ListNode next;
	
	ListNode(int val) {
		this.val = val;
	}
}
class Solution {
		
	//将链表分为小于x的和大于x的，小于x的插入大于或等于之前
	public ListNode partition1(ListNode head, int x){
		//定义一个大于x的，一个于x的，合并链表
		
		if(head==null){
			return null;
		}
		ListNode small = null;
		ListNode big=null;
		ListNode smallLast=null;
		ListNode bigLast=null;
		for(ListNode cur=head;cur!=null;cur=cur.next){
			if(cur.val<x){
				if(small==null){
					small=cur;
				}
				else{
					smallLast.next=cur;
				}
				smallLast=cur;
			}
			else{
				if(big==null){
					big=cur;
				}
				else{
					bigLast.next=cur;
				}
				bigLast=cur;
			}
		}
		if(small==null){
			return big;
		}
		else{
			smallLast.next=big;
			if(bigLast.next!=null){
				bigLast.next=null;
			}
			
		}
		return small;
	}
}
	public class crouse612 {
		static void testpartition(){
		//1.构建链表
		//2.调用函数
		//3.打印
		ListNode n1 =new ListNode (4);
		ListNode n2 =new ListNode (4);
		ListNode n3 =new ListNode (8);
		ListNode n4 =new ListNode (1);
		ListNode n5 =new ListNode (5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		ListNode result=new Solution().partition1(n1,4);
		for(ListNode cur=result;cur!=null;cur=cur.next){
			System.out.printf("%d——>",cur.val);
		}
		System.out.println();//起空格作用
		//random，cur打印出来的为地址形式
		
	}
		public static void main (String[] args){
			testpartition();
		}
	}
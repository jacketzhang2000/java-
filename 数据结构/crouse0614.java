class Node {
	public int val;	// 保存结点中的数据
	public Node next;	// 指向下一个结点的引用
	public Node random;					// 特殊值 null
						
	public Node(int val) {
		this.val = val;
		this.next = null;
	}
}
class Solution {
		
	public Node copyNode(Node head) {
		if(head==null){
			return null;
		}
		//1.复制每个节点，插入到老结点后面
		Node cur=head;
		while(cur!=null){
			Node node =new Node(cur.val);
			node.next=cur.next;
			cur.next=node;
			
			cur=node.next;
		}
		//2.进行random的复制
		cur=head;
		while(cur!=null){
			if(cur.random!=null){
				cur.next.random=cur.random.next;
			}
			cur=cur.next.next;
		}
		//3.拆分新旧链表
		cur=head;
		Node newhead=head.next;
		while(cur!=null){
			Node node=cur.next;
			cur.next=node.next;
			if(node.next!=null){
			node.next=node.next.next;
			}
			cur=cur.next;
		}
		return newhead;
		
	}
	
}
	public class crouse0614 {
		static void testcopyNode() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);

		n1.next = n2; n2.next = n3; n3.next = n4;n4.next=null;
		n1.random = n2; n2.random = n1; n3.random = n3;

		Node result = new Solution().copyNode(n1);
		for (Node cur = n1; cur != null; cur = cur.next) {
			System.out.printf("Node(%s, %d, %s) --> %n",
				cur, cur.val, cur.random);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();


		for (Node cur = result; cur != null; cur = cur.next) {
			System.out.printf("Node(%s, %d, %s) --> %n",
				cur, cur.val, cur.random);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		//testReverseList();
		testcopyNode();
	}
}
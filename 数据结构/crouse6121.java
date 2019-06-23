class ListNode {
	int val;
	ListNode next;
	
	ListNode(int val) {
		this.val = val;
	}
}
class Solution {
	
	public ListNode partition(ListNode pHead, int x) {
        // small 是小于 x 的链表
		// big 是大于等于 x 的链表
		ListNode small = null;
		ListNode smallLast = null;
		
		ListNode big = null;
		ListNode bigLast = null;
		
		// cur = cur.next 的目的是让 cur 指向 cur 原来的下一个结点
		for (ListNode cur = pHead; cur != null; cur = cur.next) {
			if (cur.val < x) {
				if (small == null) {
					small = cur;
				} else {
					smallLast.next = cur;
				}
				smallLast = cur;
			} else {
				if (big == null) {
					big = cur;
				} else {
					bigLast.next = cur;
				}
				bigLast = cur;
			}
		}
		
		// 容易忘的点：需要保证链表的最后一个结点的 next == null
		
		if (small == null) {
			return big;
		} else {
			smallLast.next = big;
			if (bigLast != null) {
				bigLast.next = null;
			}
			return small;
		}
    }
	
	
	public ListNode deleteDuplication(ListNode pHead)
    {
		if (pHead == null) {
			return null;
		}
		
		ListNode prev = new ListNode(0);
		prev.next = pHead;
		ListNode fake = prev;
		ListNode p1 = pHead;
		ListNode p2 = pHead.next;
		
		while (p2 != null) {
			if (p1.val != p2.val) {
				prev = p1;
				p1 = p1.next;
				p2 = p2.next;
			} else {
				// 或者 p2 为空、或者 p2.val != p1.val
				while (p2 != null && p2.val == p1.val) {
					p2 = p2.next;
				}
				
				// 删除从 [p1, p2) 的所有结点
				prev.next = p2;
				// 这里 p2 可能是 null
				p1 = p2;
				if (p2 != null) {
					p2 = p2.next;
				}
			}
		}
		
		return fake.next;
    }
	
	
	
	public ListNode deleteDuplication1(ListNode pHead){
		if (pHead == null) {
			return null;
		}
		
		ListNode prev = null;
		ListNode p1 = pHead;
		ListNode p2 = pHead.next;
		
		while (p2 != null) {
			if (p1.val != p2.val) {
				prev = p1;
				p1 = p1.next;
				p2 = p2.next;
			} else {
				// 或者 p2 为空、或者 p2.val != p1.val
				while (p2 != null && p2.val == p1.val) {
					p2 = p2.next;
				}
				
				// 删除从 [p1, p2) 的所有结点
				if (prev == null) {
					pHead = p2;
				} else {
					prev.next = p2;
				}
				// 这里 p2 可能是 null
				p1 = p2;
				if (p2 != null) {
					p2 = p2.next;
				}
			}
		}
		
		return pHead;
    }
	
	
	    public ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            
            cur.next = result;
            result = cur;
            
            cur = next;
        }
        
        return result;
    }
    // 理解为什么不能把整个链表逆置（全部逆置后，就没有原来的链表了）
    public boolean chkPalindrome(ListNode A) {
        ListNode mid = getMid(A);		// 找中间结点
        ListNode h2 = reverse(mid);		// 反转单链表
        ListNode n1 = A;
        ListNode n2 = h2;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            
            n1 = n1.next;
            n2 = n2.next;
        }
        
        return true;
    }
	
	    public int getLength(ListNode head) {
        int n = 0;
        for (ListNode c = head; c != null; c = c.next) {
            n++;
        }
        
        return n;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        ListNode longList = headA;
        ListNode shortList = headB;
        int diff = lenA - lenB;
        if (lenA < lenB) {
            longList = headB;
            shortList = headA;
            diff = lenB - lenA;
        }
        
        
        // 让长的先走 diff 步
        for (int i = 0; i < diff; i++) {
            longList = longList.next;
        }
        
        // 同时前进，直到 longList == shortList
        // 可能 都 == null，表示没有交叉
        while (longList != shortList) {
            longList = longList.next;
            shortList = shortList.next;
        }
        
        return longList;
    }
	
	    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        do {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        } while (fast != null && fast != slow);
        
        if (fast == null) {
            return null;
        }
        
        ListNode p1 = head; // p1 从起点出发
        ListNode p2 = slow; // p2 从相遇点出发
        while (p1 != p2) {  // 只要 p1 == p2 了，一定是入口点，证明过程略 
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p1;
    }
}

public class crouse6121{
		static void testpartition(){
		//1.构建链表
		//2.调用函数
		//3.打印
		ListNode n1 =new ListNode (4);
		ListNode n2 =new ListNode (4);
		ListNode n3 =new ListNode (3);
		ListNode n4 =new ListNode (4);
		ListNode n5 =new ListNode (5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		ListNode result=new Solution().partition(n1,4);
		for(ListNode cur=result;cur!=null;cur=cur.next){
			System.out.printf("%d——>",cur.val);
		}
		System.out.println();//起空格作用
		//random，cur打印出来的为地址形式
		
	}
	static void testdeleteDuplication1(){
		//1.构建链表
		//2.调用函数
		//3.打印
		ListNode n1 =new ListNode (4);
		ListNode n2 =new ListNode (4);
		ListNode n3 =new ListNode (3);
		ListNode n4 =new ListNode (4);
		ListNode n5 =new ListNode (5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		ListNode result=new Solution().deleteDuplication1(n1);
		for(ListNode cur=result;cur!=null;cur=cur.next){
			System.out.printf("%d——>",cur.val);
		}
		System.out.println();//起空格作用
		//random，cur打印出来的为地址形式
		
	}
	static void testdeleteDuplication(){
		//1.构建链表
		//2.调用函数
		//3.打印
		ListNode n1 =new ListNode (4);
		ListNode n2 =new ListNode (4);
		ListNode n3 =new ListNode (3);
		ListNode n4 =new ListNode (4);
		ListNode n5 =new ListNode (5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		ListNode result=new Solution().deleteDuplication(n1);
		for(ListNode cur=result;cur!=null;cur=cur.next){
			System.out.printf("%d——>",cur.val);
		}
		System.out.println();//起空格作用
		//random，cur打印出来的为地址形式
		
	}
	static void testchkPalindrome(){	
		ListNode n1 =new ListNode (4);
		ListNode n2 =new ListNode (1);
		ListNode n3 =new ListNode (3);
		ListNode n4 =new ListNode (1);
		ListNode n5 =new ListNode (4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		System.out.println(	new Solution().chkPalindrome(n1));
	}
	
		static void testgetIntersectionNode(){
		//1.构建链表
		//2.调用函数
		//3.打印
		ListNode n1 =new ListNode (4);
		ListNode n2 =new ListNode (4);
		ListNode n3 =new ListNode (3);
		ListNode n4 =new ListNode (4);
		ListNode n5 =new ListNode (5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		ListNode b2 =new ListNode (5);
		ListNode b3 =new ListNode (7);
		b2.next = b3;
		b3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		ListNode result=new Solution().getIntersectionNode(n1,b2);
		for(ListNode cur=result;cur!=null;cur=cur.next){
			System.out.printf("%d——>",cur.val);
		}
		System.out.println();//起空格作用
		//random，cur打印出来的为地址形式
		
	}
		public static void main (String[] args){
			testpartition();
			testdeleteDuplication1();
			testdeleteDuplication();
		    testchkPalindrome();
			testgetIntersectionNode();
			ListNode head =new ListNode (8);
		ListNode n2 =new ListNode (4);
		ListNode n3 =new ListNode (3);
		ListNode n4 =new ListNode (4);
		ListNode n5 =new ListNode (5);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n3;
			System.out.println(new Solution().detectCycle(head).val);
		}
	}
package 链表;
class ListNode{
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int value){
        this.val=value;
    }
}
/*
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 
限制：
0 <= 节点个数 <= 5000

思路：脑补那张图解  定义一个pre为null，定义一个cur=head，定义一个temp=cur.next
     然后去迭代链表 temp=cur.next    cur.next=pre   pre=cur    cur=temp
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        ListNode temp;
        while(cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

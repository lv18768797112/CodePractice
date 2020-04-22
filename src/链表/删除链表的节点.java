package 链表;
/*
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
返回删除后的链表的头节点。

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

思路：定义一个假节点，假节点的next指向head，然后去操作链表完成链表的节点删除，最后返回假节点的next即可
       链表的题画图有助于理清思路
 */
public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=null) {
            ListNode temp = cur.next;
            if (cur.val == val) {
                pre.next = temp;
                cur = temp;
            } else {
                pre = cur;
                cur = temp;
            }
        }
        return dummy.next;
    }
}

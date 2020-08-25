package 链表;
/*
 * 输入两个链表，找出它们的第一个公共节点。
注意：
如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

* 思路：想象一下两个链表相交的图  然后想到 a+c+b = b+c+a
 */
public class 两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode L1 = headA;
        ListNode L2 = headB;
        while(L1!=L2){
            L1 = L1==null?headB:L1.next;
            L2 = L2==null?headA:L2.next;
        }
        return L1;
    }
}

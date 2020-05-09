package 链表;

import java.util.HashSet;
/*
输入: 1->1->2
输出: 1->2

输入: 1->1->2->3->3
输出: 1->2->3

思路：因为链表是有序的，所以不用集合来记录不重复的元素
 */
class ListNode{
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int value){
        this.val=value;
    }
}
public class 删除有序链表中重复的节点 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            if(cur.val==cur.next.val){
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head;
    }
}
//下面这种解法适用于无序链表
//    ListNode cur = head;
//    ListNode pre = head;
//    HashSet<Integer> set= new HashSet<>();
//        while(cur!=null ){
//                if(!set.contains(cur.val)){
//                set.add(cur.val);
//                pre = cur;
//                cur = cur.next;
//                }
//                else {
//                cur = cur.next;
//                pre.next = cur;
//                }
//                }
//                return head;
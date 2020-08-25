package 链表;
/*
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

输入: dummy -> 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
      pre    cur  cur  cur  cur
输出: 1->2->5

输入: dummy -> 1 -> 1-> 1 -> 2 -> 3
      pre    cur
输出: 2->3
 */
public class 删除有序链表中重复的节点2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                ListNode temp = cur.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val ) {
                    temp = temp.next;
                }
                cur.next = temp.next;
            }
            else
                cur = cur.next;
        }
        return dummy.next;
//
//        作者：keithy
//        链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/java-ya-jie-dian-fei-di-gui-rong-yi-li-jie-yong-sh/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
}

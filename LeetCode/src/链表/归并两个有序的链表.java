package 链表;
/*
 *
输入：1->2->4,
	  1->3->4
输出：1->1->2->3->4->4
 */

//迭代法
//思路：定义一个-1节点，然后定义一个temp节点从-1节点开始去连接两个节点中小的那个节点
//     归并排序的思想很重要，可以模仿归并排序的结构。
public class 归并两个有序的链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                cur.next = l2;
                l2 =  l2.next;
            }
            else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = l1==null?l2:l1;
        return res.next;
    }
}

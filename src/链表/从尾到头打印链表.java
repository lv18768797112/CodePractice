package 链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

输入：head = [1,3,2]
输出：[2,3,1]
 
限制：
0 <= 链表长度 <= 10000

思路：1.遍历链表，将链表元素值存到ArrayList中，用Collections.reverse(list)将ArrayList中元素反转，最后存到一个int[] 中返回即可
     2.题意为从尾到头打印，这里应该联想到栈，即遍历链表，将元素值存到栈中，最后按出栈顺序存到int[]中返回
 */
public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }
        return ans;
    }
}
//用ArrayList ：
//    public int[] reversePrint(ListNode head) {
//        if(head==null)
//            return new int[0];
//        List<Integer> list = new ArrayList<>();
//        while(head!=null){
//            list.add(head.val);
//            head=head.next;
//        }
//        Collections.reverse(list);
//        int ans[] = new int[list.size()];
//        for(int i=0;i<ans.length;i++){
//            ans[i] = list.get(i);
//        }
//        return ans;
//    }
package 树;
import java.util.Stack;
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
//
//参考以下这颗二叉搜索树：
//
//     5
//    / \
//   2   6
//  / \
// 1   3
//示例 1：
//输入: [1,6,3,2,5]
//输出: false
//示例 2：
//输入: [1,3,2,6,5]
//输出: true
// 
//提示：
//数组长度 <= 1000

public class 二叉搜索树的后序遍历序列 {

    //	//递归
//	public boolean verifyPostorder(int[] postorder) {
//        if(postorder.length==0)
//            return true;
//        return isAns(postorder,0,postorder.length-1);
//    }
//    public boolean isAns(int[] postorder,int l,int r){
//        if(l>=r)
//            return true;
//        int m = l;
//        while(postorder[m]<postorder[r])
//            m++;
//        int n = m;
//        while(postorder[n]>postorder[r])
//            n++;
//        return n==r&&isAns(postorder,l,m-1)&&isAns(postorder,m,r-1);
//    }
    //单调栈
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }
}

package 树;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int value){
        this.val = value;
    }
}
/*
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回：
[3,9,20,15,7]
* 思路：
关于二叉树的遍历：
宽度优先遍历 对应层次遍历  用队列  用一个队列遍历，用一个list存储顺序 最后遍历list存到数组中返回
深度优先遍历  对应有三个：先序  中序  后序   用栈 注意进栈顺序  还有

 */
public class 从上到下打印二叉树一 {
    public static int[] levelOrder(TreeNode root) {
        if(root==null)
            return new int[0];  //这里不能反回null
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            //如果要统计每一层的一些性质，比如说每一层节点数之和，每一层节点数的平均数，每一层最左边或最右边的数
            //就需要要用一个循环去对每一层的节点做处理
            //int size = queue.size();
            //for(int i=0;i<size;i++){}
            TreeNode temp = queue.poll();
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
            list.add(temp.val);
        }
        int[] ans = new int[list.size()];
        for (int i = 0;i<ans.length;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(3);
        TreeNode three = new TreeNode(2);
        one.left = two;
        one.right = three;
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        two.left=four;
        two.right=five;
        int[] a = 从上到下打印二叉树一.levelOrder(one);
        for (int i:a) {
            System.out.print(i+" ");
        }
    }
}

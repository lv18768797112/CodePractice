package 树;
//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
//        第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
//
//        给定二叉树: [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//
//        返回其层次遍历结果：
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]
//         
//        提示：
//        节点总数 <= 1000

import java.util.*;

public class 从上到下打印二叉树三 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans =new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode node =queue.poll();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                list.add(node.val);
            }
            ans.add(list);
        }
        for (int i = 1; i < ans.size(); i+=2) {
            Collections.reverse(ans.get(i));
        }
        return ans;
    }
}

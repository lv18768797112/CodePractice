package 树;
//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
//        [9,20],
//        [15,7]
//        ]
//         
//        提示：
//        节点总数 <= 1000

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树二 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-->0){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            ans.add(list);
        }
        return ans;
    }
}

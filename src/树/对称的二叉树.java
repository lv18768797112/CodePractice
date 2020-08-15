package 树;
//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
//        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//            1
//           / \
//          2   2
//         / \ / \
//        3  4 4  3
//
//        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//            1
//           / \
//          2   2
//           \   \
//           3    3
//
//        示例 1：
//        输入：root = [1,2,2,3,4,4,3]
//        输出：true
//
//        示例 2：
//        输入：root = [1,2,2,null,3,null,3]
//        输出：false
//         
//        限制：
//        0 <= 节点个数 <= 1000

public class 对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isSymmetricTree(root.left,root.right);
    }
    public boolean isSymmetricTree(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null)
            return true;
        if(root1==null)
            return  false;
        if(root2==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return isSymmetricTree(root1.left,root2.right)&&isSymmetricTree(root1.right,root2.left);
    }
}

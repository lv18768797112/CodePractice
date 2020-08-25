package 搜索.回溯;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class 二叉树中所有的路径 {
//    java是值传递，当传递的参数是基本变量类型时，就直接传递他们的一个拷贝，当传递的参数是引用类型变量时，
//    传递的是他们引用（地址）的一个拷贝。
    //但是用String更快  为什么？
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList();
        String path = new String();
        dfs(root, path, paths);
        return paths;
    }
    public void dfs(TreeNode root, String path, List<String> paths) {
        if(root==null)
            return;
        path += Integer.toString(root.val);
        if ((root.left == null) && (root.right == null))  // 当前节点是叶子节点
            paths.add(path);  // 把路径加入到答案中
        else {
            path += "->";  // 当前节点不是叶子节点，继续递归遍历
            dfs(root.left, path, paths);
            dfs(root.right, path, paths);
        }
    }


//    SrtringBuilder
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> paths = new ArrayList<>();
//        if(root==null){
//            return paths;
//        }
//        StringBuilder path = new StringBuilder();
//        dfs(root,path,paths);
//        return paths;
//    }
//    public void dfs(TreeNode root,StringBuilder path,List<String> paths){
//        if(root==null){
//            return;
//        }
//        if(root.left==null&&root.right==null){
//            paths.add(path.toString()+root.val);
//            return;
//        }
//        int len = path.length();
//        path.append(root.val+"->");
//        len = path.length()-len;
//        dfs(root.left,path,paths);
//        dfs(root.right,path,paths);
//        path.delete(path.length()-len,path.length());
//    }
}

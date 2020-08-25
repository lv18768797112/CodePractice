package 搜索.回溯;
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//        示例:
//        输入: n = 4, k = 2
//        输出:
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 组合 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        dfs(1,n,k,stack,ans);
        return ans;
    }
    public void dfs(int begin,int n,int k,Stack<Integer> stack,List<List<Integer>> ans){
        if(stack.size()==k){
            ans.add(new ArrayList<>(stack));
            return;
        }
        //不剪枝：i<=n
        //不剪枝：i<=n - (k - stack.size()) + 1
        for(int i=begin;i<=n - (k - stack.size()) + 1;i++){
            stack.push(i);
            dfs(i+1,n,k,stack,ans);
            stack.pop();
        }
    }
}

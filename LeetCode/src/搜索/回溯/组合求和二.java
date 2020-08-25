package 搜索.回溯;
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//    candidates 中的每个数字在每个组合中只能使用一次。
//
//    所有数字（包括目标数）都是正整数。
//    解集不能包含重复的组合。 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 组合求和二 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(candidates==null)
            return  ans;
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(candidates);
        dfs(candidates,0,target,stack,ans);
        return ans;
    }
    public void dfs(int[] candidates,int begin,int target,Stack<Integer> stack,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(stack)); // 由于 stack 全局只使用一份，到叶子结点的时候需要做一个拷贝
            return;
        }
        for(int i=begin;i<candidates.length;i++){
            if(i>begin&&candidates[i]==candidates[i-1])
                continue;
            int tar = target-candidates[i];
            if(tar<0)
                break;
            stack.push(candidates[i]);
            dfs(candidates,i+1,tar,stack,ans);
            stack.pop();
        }
    }
}

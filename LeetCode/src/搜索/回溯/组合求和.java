package 搜索.回溯;
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//    candidates 中的数字可以无限制重复被选取。
//    说明：所有数字（包括 target）都是正整数。解集不能包含重复的组合。 
//
//    示例 1：
//    输入：candidates = [2,3,6,7], target = 7,
//    所求解集为：
//    [
//    [7],
//    [2,2,3]
//    ]
//
//    提示：
//    1 <= candidates.length <= 30
//    1 <= candidates[i] <= 200
//    candidate 中的每个元素都是独一无二的。
//    1 <= target <= 500

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 组合求和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if(i>0&&candidates[i]==candidates[i-1])
                continue;
            int tar = target-candidates[i];
            if(tar<0)
                break;
            stack.push(candidates[i]);
            dfs(candidates,i,tar,stack,ans);
            stack.pop();
        }
    }
}

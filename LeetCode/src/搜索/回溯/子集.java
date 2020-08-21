package 搜索.回溯;
//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//    说明：解集不能包含重复的子集。
//
//    示例:
//    输入: nums = [1,2,3]
//    输出:
//    [
//    [3],
//      [1],
//      [2],
//      [1,2,3],
//      [1,3],
//      [2,3],
//      [1,2],
//      []
//    ]

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null)
            return ans;
        ans.add(new ArrayList());
        Deque<Integer> deque = new LinkedList<>();
        dfs(nums,0,ans,deque);
        return ans;
    }
    public void dfs(int[] nums,int begin,List<List<Integer>> ans,Deque<Integer> deque){
        if(!deque.isEmpty()){
            ans.add(new ArrayList<>(deque));
        }
        for(int i=begin;i<nums.length;i++){
            deque.addLast(nums[i]);
            dfs(nums,i+1,ans,deque);
            deque.removeLast();
        }
    }
}

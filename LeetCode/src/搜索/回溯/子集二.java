package 搜索.回溯;
//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//        说明：解集不能包含重复的子集。
//        示例:
//        输入: [1,2,2]
//        输出:
//        [
//        [2],
//        [1],
//        [1,2,2],
//        [2,2],
//        [1,2],
//        []
//        ]

import java.util.*;

public class 子集二 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums==null)
            return ans;
        Deque<Integer> deque = new LinkedList<>();
        Arrays.sort(nums);
        dfs(nums,0,ans,deque);
        return ans;
    }
    public void dfs(int[] nums, int begin, List<List<Integer>> ans, Deque<Integer> deque){
        ans.add(new ArrayList(deque));
        for(int i=begin;i<nums.length;i++){
            if(i>begin&&nums[i]==nums[i-1])
                continue;
            deque.addLast(nums[i]);
            dfs(nums,i+1,ans,deque);
            deque.removeLast();
        }
    }
}

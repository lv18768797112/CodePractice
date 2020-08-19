package 搜索.回溯;
//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
//        输入: [1,1,2]
//        输出:
//        [
//        [1,1,2],
//        [1,2,1],
//        [2,1,1]
//        ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列二 {
    public List<List<Integer>> permuteUnique(int[] nums){
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        if(len==0||nums==null)
            return ans;
        boolean[] used = new boolean[len];
        Arrays.sort(nums);
        dfs(nums,ans,path,0,used);
        return ans;
    }
    public void dfs(int[] nums,List<List<Integer>> ans,List<Integer> path,int depth,boolean[] used) {
        int len = nums.length;
        if(depth==len) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i=0;i<len;i++) {
            if(used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;
            path.add(nums[i]);
            used[i] = true;
            dfs(nums,ans,path,depth+1,used);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}

package 搜索.回溯;
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    public List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        if(len==0||nums==null)
            return ans;
        boolean[] used = new boolean[len];
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
            if(!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,ans,path,depth+1,used);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}

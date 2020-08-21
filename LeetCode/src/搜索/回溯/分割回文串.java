package 搜索.回溯;
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//    返回 s 所有可能的分割方案。
//
//    示例:
//    输入: "aab"
//    输出:
//    [
//    ["aa","b"],
//    ["a","a","b"]
//    ]

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
//在上一步，验证回文串那里，每一次都得使用“两边夹”的方式验证子串是否是回文子串。于是“用空间换时间”，
//利用「力扣」第 5 题：最长回文子串 的思路，利用动态规划把结果先算出来，这样就可以以 O(1)O(1) 的时间复杂度直接得到一个子串是否是回文。作者：liweiwei1419

public class 分割回文串 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if(s==null||s.length()==0)
            return ans;
        Deque<String> deque = new ArrayDeque<>();
        dfs(s,ans,deque,0);
        return ans;
    }
    public void dfs(String s,List<List<String>> ans,Deque<String> deque,int begin){
        if(begin==s.length()){
            ans.add(new ArrayList(deque));
            return;
        }
        for(int i=begin;i<s.length();i++){
            String substr = s.substring(begin,i+1);
            if(isHw(s,begin,i)){
                deque.addLast(substr);
                dfs(s,ans,deque,i+1);
                deque.removeLast();
            }
        }
    }
    public boolean isHw(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

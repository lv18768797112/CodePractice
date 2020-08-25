package 滑动窗口;

import java.util.HashMap;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//        示例 1:
//
//        输入: "abcabcbb"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//        示例 2:
//
//        输入: "bbbbb"
//        输出: 1
//        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//        示例 3:
//
//        输入: "pwwkew"
//        输出: 3
//        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口
        if(s.length()==0)
            return 0;
        char[] str = s.toCharArray();
        int left=0;
        int maxLen=1;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length;i++){
            if(map.containsKey(str[i]))
                left = Math.max(left,map.get(str[i])+1); //为什么这里要这样写？ 为了拿到正确的left值
            map.put(str[i],i);
            maxLen = Math.max(maxLen,i-left+1);
        }
        return maxLen;
    }
    //暴力解法
    // if(s.length()==0)
    //     return 0;
    // char[] str = s.toCharArray();
    // int maxLen=1;
    // for(int i=0;i<str.length;i++){
    //     HashMap<Character,Integer> map = new HashMap<>();
    //     for(int j=i;j<str.length;j++){
    //         if(map.containsKey(str[j])){
    //             break;
    //         }
    //         map.put(str[j],1);
    //     }
    //     maxLen = Math.max(maxLen,map.size());
    // }
    // return maxLen;
}

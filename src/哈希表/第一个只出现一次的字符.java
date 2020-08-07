package 哈希表;
//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//        示例:
//        s = "abaccdeff"
//        返回 "b"
//
//        s = ""
//        返回 " "
//        限制：
//        0 <= s 的长度 <= 50000

import java.util.HashMap;
import java.util.Map;

public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        if(s==null)
            return ' ';
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i = 0;i<s.length();i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        char ans=' ';
        for(int i = 0;i<s.length();i++) {
            if(map.get(s.charAt(i))==1) {
                ans = s.charAt(i);
                break;
            }
        }
        return ans;
    }
}

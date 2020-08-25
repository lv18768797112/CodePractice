package 双指针;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//        示例 1:
//        输入: "hello"
//        输出: "holle"
//        示例 2:
//        输入: "leetcode"
//        输出: "leotcede"
//        说明:
//        元音字母不包含字母"y"。
public class 反转字符串中的元音字母 {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int l = 0;
        int r = str.length-1;
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        while(l<r){
            if(set.contains(str[l])&&set.contains(str[r])){
                char temp = str[r];
                str[r] = str[l];
                str[l] = temp;
                l++;
                r--;
            }
            if(!set.contains(str[l]))
                l++;
            if(!set.contains(str[r]))
                r--;
        }
        return new String(str);
    }
}

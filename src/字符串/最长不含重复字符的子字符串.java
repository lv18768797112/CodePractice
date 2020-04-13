package 字符串;

import java.util.HashMap;
import java.util.Map;

/*示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

思路：题目中要求答案必须是 子串 的长度，意味着子串内的字符在原字符串中一定是连续的。
    因此我们可以将答案看作原字符串的一个滑动窗口，并维护窗口内不能有重复字符，同时更新窗口的最大值。
解法1：定义指针L=R=0;双指针维护一个滑动窗口，遍历到的元素不重复， R++，重复了就L++
        时间复杂度：O(n^2) 空间复杂度O(1)
优化：用hashmap或hashset记录滑动窗口中的元素及其下标，当遍历到的元素重复了的时候，直接将L增加到滑动窗口中重复的元素的右侧
        时间复杂度O(n)  空间复杂度O(n) 使用了hashmap
*/
public class 最长不含重复字符的子字符串 {
	 public int lengthOfLongestSubstring(String s) {
         int maxLength=0;
         int L=0,R=0;
         HashMap<Character,Integer> map = new HashMap<>();
         while(R<s.length()){
             if(!map.containsKey(s.charAt(R))){
                 map.put(s.charAt(R),R);
                 R++;
                 maxLength = Math.max(maxLength,map.size());
             }
             else{
                 map.remove(s.charAt(L));
                 L++;
             }

         }
         return maxLength;
	 }
}
/*hashmap暴力解法：太暴力了
 * int maxLength=0,sum=0;
		 for (int i = 0; i < s.length(); i++) {
			Map<Character,Integer> map = new HashMap<>();
			map.put(s.charAt(i),i);
			sum=1;
			for (int j = i+1; j < s.length(); j++) {
				if(!map.containsKey(s.charAt(j))) {
					map.put(s.charAt(j),j);
					sum++;
				}
				else {
					break;
				}
			}
			maxLength =sum>maxLength?sum:maxLength;
		}

		return maxLength;
 *
 */



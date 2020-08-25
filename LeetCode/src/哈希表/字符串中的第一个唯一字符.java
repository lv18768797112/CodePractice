package 哈希表;
//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//    示例：
//    s = "leetcode"
//    返回 0
//    s = "loveleetcode"
//    返回 2
//    提示：你可以假定该字符串只包含小写字母。

public class 字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
//        当储存数据种类较多时，可以使用map或者set,但种类较少时，使用数组即可，可以极大缩短时间和空间
        // HashMap<Character,Integer> map = new HashMap<>();
        // for(int i=0;i<s.length();i++){
        //     char c = s.charAt(i);
        //     map.put(c,map.getOrDefault(c,0)+1);
        // }
        // for(int j=0;j<s.length();j++){
        //     if(map.get(s.charAt(j))==1)
        //         return j;
        // }
        // return -1;
        int len = s.length();
        int[] str = new int[26];
        for(int i=0;i<len;i++){
            str[s.charAt(i)-'a']++;
        }
        for(int j=0;j<len;j++){
            if(str[s.charAt(j)-'a']==1)
                return j;
        }
        return -1;
    }
}

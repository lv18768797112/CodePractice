package 二分;
//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
//        在比较时，字母是依序循环出现的。举个例子：
//        如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
//        示例：
//        输入:
//        letters = ["c", "f", "j"]
//        target = "a"
//        输出: "c"
//        提示：
//        letters长度范围在[2, 10000]区间内。
//        letters 仅由小写字母组成，最少包含两个不同的字母。
//        目标字母target 是一个小写字母。
public class 寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        if(target=='z')
            return letters[0];
        int L = 0;
        int R = letters.length-1;
        while(L<=R){
            int mid = L+(R-L)/2;
            if(letters[mid]<=target)
                L = mid+1;
            else
                R = mid-1;
        }
        if(L<letters.length)
            return letters[L];
        else
            return letters[0];
    }
}

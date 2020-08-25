package 双指针;
//
//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
//        示例1:
//        输入: 5
//        输出: True
//        解释: 1 * 1 + 2 * 2 = 5
//
//        示例2:
//        输入: 3
//        输出: False
public class 两数平方和 {
    public boolean judgeSquareSum(int c) {
        int l=0;
        int r= (int) Math.sqrt(c);
        while(l<r){
            int sum = l*l+r*r;
            if(sum==c)
                return true;
            else if(sum<c)
                l++;
            else
                r--;
        }
        return false;
    }
}

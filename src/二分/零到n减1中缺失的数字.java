package 二分;
//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内
//。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
//
//        示例 1:
//        输入: [0,1,3]
//        输出: 2
//        示例 2:
//        输入: [0,2,3,3,4,5,6,7,9]
//        输出: 8
//
//        限制：
//        1 <= 数组长度 <= 10000
public class 零到n减1中缺失的数字 {
    public int missingNumber(int[] nums) {
        int L = 0, R = nums.length - 1;
        while(L <= R) {
            int m = (L + R) / 2;
            if(nums[m] == m) L = m + 1;
            else R = m - 1;
        }
        return L;
    }
}

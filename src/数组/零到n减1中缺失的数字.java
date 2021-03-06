package 数组;
/*
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

输入: [0,1,3]
输出: 2
示例 2:

输入: [0,1,2,3,4,5,6,7,9]
输出: 8

限制：
1 <= 数组长度 <= 10000
思路：
1. 数字都唯一，且都在0~n-1范围内，那么nums[i]如果不等于i的话，i就是那个缺失的数字，这样要过一遍数组，时间复杂度为O(n)
2.有序数组直接使用二分查找，如果当前数字与当前位置相等，则说明前面的数字都没有缺失，直接继续对后面的数字进行二分查找。
直到无法二分查找的时候，我们判断low位置的数字是否等于low，等于则+1，不等则-1。 时间复杂度O(logN)
 */


public class 零到n减1中缺失的数字 {
    public int missingNumber(int[] nums) {
        int L=0,R=nums.length-1;
        while(L<R){
            int mid = L+(R-L)/2;
            if(mid!=nums[mid])
                L=mid+1;
            else
                R=mid-1;
        }
        return L==nums[L]?nums[L]+1:nums[L]-1;
    }
}

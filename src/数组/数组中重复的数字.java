package 数组;
/*
找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
示例 1：
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3

限制：2 <= n <= 100000

思路： 1.hashmap或hashset   map判断用containsKey  set用（!set.add()）  添加元素返回false说明集合中已存在
      2.因为数组长度为n，并且元素都在0-n-1范围内，所以可以遍历数组，将元素x与放在下标为x的位置上去，
        若元素x与下标为x的元素相等，则元素x就是数组中第一个重复的数字
 */
public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                if(nums[i]==nums[nums[i]])
                    return nums[i];
                else{
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        return 0;
    }
}

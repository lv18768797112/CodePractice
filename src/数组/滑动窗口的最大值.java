package 数组;

import java.util.ArrayList;
import java.util.List;

/*
 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */
//耗时1ms
public class 滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new int[0];
        int[] ans = new int[nums.length-k+1];        //定义结果数组
        int maxInd = -1,max = Integer.MIN_VALUE;     //maxInd记录每次最大值的下标，max记录最大值
        for(int i=0;i<ans.length;i++){
            if(maxInd >= i && maxInd < i+k){         //判断最大值下标是否在滑动窗口的范围内
                if(nums[i+k-1]>max){                 //存在就只需要比较最后面的值是否大于上一个窗口最大值
                    max = nums[i+k-1];
                    maxInd = i+k-1;                  //更新最大值下标
                }
            }
            else {                                  //如果不在就重新寻找当前窗口最大值
                max = nums[i];
                for(int j=i;i<j+k;j++){
                    if(nums[j]>max){
                        max = nums[j];
                        maxInd = j;
                    }
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}
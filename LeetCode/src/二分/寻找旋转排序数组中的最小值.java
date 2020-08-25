package 二分;
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//        ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//        请找出其中最小的元素。
//        你可以假设数组中不存在重复元素。
//        示例 1:
//        输入: [3,4,5,1,2]
//        输出: 1
//        示例 2:
//        输入: [4,5,6,7,0,1,2]
//        输出: 0
public class 寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int L=0;
        int R=nums.length-1;
        while(L<R){
            int mid = L+(R-L)/2;
            if(nums[mid]<nums[R])
                R = mid;
            else
                L = mid+1;
            //这里我想的是如果mid大于L也大于R，说明mid还位于左半边递增序列，但其实值需要判断mid是否小于R就可以了
            // if(nums[mid]>nums[mid+1])
            //     return nums[mid+1];
            // else if(nums[mid]>nums[L]&&nums[mid]>nums[R])
            //     L = mid+1;
            // else
            //     R = mid;
        }
        return nums[L];
    }
}

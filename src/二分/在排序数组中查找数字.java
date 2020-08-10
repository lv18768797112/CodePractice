package 二分;
//统计一个数字在排序数组中出现的次数。
//        示例 1:
//        输入: nums = [5,7,7,8,8,10], target = 8
//        输出: 2
//
//        示例 2:
//        输入: nums = [5,7,7,8,8,10], target = 6
//        输出: 0
//
//        限制：
//        0 <= 数组长度 <= 50000

public class 在排序数组中查找数字 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return 0;
        }

        int lastPosition = findLastPosition(nums, target);
        return lastPosition - firstPosition + 1;
    }

    private int findFirstPosition(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 注意这样写，可以从左边收缩待搜索区间的范围，进而找到第一次出现的位置
            if (nums[mid] < target) {
                // mid 以及 mid 左边都不是，下一轮搜索区间在 [mid + 1, right]
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            // 注意这样写，可以从右边收缩待搜索区间的范围，进而找到最后一次出现的位置
            if (nums[mid] > target) {
                // mid 以及 mid 右边都不是，下一轮搜索区间在 [left, mid - 1]
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}

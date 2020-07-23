package 栈和队列;

import java.util.Stack;
//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：
//要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//
//提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

public class 数组中元素与下一个比它大的元素之间的距离 {
    //单调栈
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] days = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<len;i++){
            while(!stack.isEmpty()&&T[i]>T[stack.peek()]){
                int index = stack.pop();
                days[index] = i-index;
            }
            stack.push(i);
        }
        return days;
    }
    //暴力遍历
//    public int[] dailyTemperatures(int[] T) {
//        int len = T.length;
//        int[] days = new int[len];
//        days[len-1] = 0;
//        for(int i=0;i<len-1;i++){
//            int j = i+1;
//            int s = 1;
//            while(j<len&&T[j]<=T[i]){
//                j++;
//                s++;
//            }
//            days[i] = j==len?0:s;
//        }
//        return days;
//    }
}

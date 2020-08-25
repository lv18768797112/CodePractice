package 数组;
/*输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

说明：
用返回一个整数列表来代替打印
n 为正整数
 */

//思路：考察Math.pow(a,b)方法    表示a的b次方
public class 打印从1到最大的n位数 {
    public int[] printNumbers(int n) {
        int max =(int) Math.pow(10, n);
        int[] ans = new int[max-1];
        for (int i = 0; i < max; i++) {
            ans[i]=i+1;
        }
        return ans;
    }
}

package 位运算;
/*一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度是O(n)，空间复杂度是O(1)。
 *

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]

限制：
2 <= nums <= 10000
//思路 ：将数组分为两组  其中那两个只出现一次的数分到不同的组内    用a=b=0分别在两组内全员异或  最后返回a和b即可

   提取出一个数a的二进制表示中最右侧的那个1，并返回这个数
  方法1： a^(~a+1)  a异或上a取反后加一就是所求
  方法2： h=1
  		 while((h&res)==0)
  		    h<<=1;   通过h取最低位为1，其他位为0去遍历 返回h为所求
 */
public class 数组中有两个数出现一次 {
    public int[] singleNumbers(int[] nums){
        int ans1 = 0, ans2=0;
        for (int number:nums) {
            ans1 = ans1^number;
        }
        int k = ans1&(~ans1+1);
        for (int number:nums) {
            if((number&k)==0)
                ans2=ans2^number;    //k就变成了那两个出现奇数次的数中某一个
        }
        return new int[]{ans2,ans1^ans2};
        // 假设所求数为a和b
        // ans1=a^b
        // ans2=a
        //ans1^ans2=b   异或的交换律
    }
}

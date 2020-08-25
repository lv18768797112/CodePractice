package 位运算;
/*给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？空间复杂度O(1)

示例 1:

输入: [2,2,1]
输出: 1

 */
//思路1：数学法：2∗(a+b+c)−(a+a+b+b+c)=c
//思路2：哈希表：将数组中所有的数作为K和它出现的次数作为value存入hashmap   最后取出value等于1的K
//思路3: 异或运算 ：两个数异或  相同位结果为0  不同位结果为1  因为异或运算满足交换律 所以用0去全员异或的结果为只出现一次的那个数

public class 数组中只有一个数出现一次 {
    public int singleNumber(int[] nums){
        int ans=0;
        for (int number:nums) {
            ans = ans ^ number;
        }
        return ans;
    }
}

package 位运算;
/*
写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
示例:
输入: a = 1, b = 1
输出: 2

提示：
a, b 均可能是负数或 0
结果不会溢出 32 位整数
*/
public class 不用加减乘除做加法 {
    public int add(int a, int b) {
        while (a != 0) {
            int temp = a ^ b;
            a = (a & b) << 1;
            b = temp;
        }
        return b;
    }
}

//例如 2+3
//2为: 0000 0000 0000 0000 0000 0000 0000 0010
//3为：0000 0000 0000 0000 0000 0000 0000 0011
//5为：0000 0000 0000 0000 0000 0000 0000 0101


//异或满足交换律和结合律   异或就是无进位相加


package 字符串;
/* 题目：
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
示例 1：
输入: "the sky is blue"
输出: "blue is sky the"

 */
//思路：1.将字符串用trim()去掉前后的空格
//		2.用split()以空格为分割将字符串转换到字符串数组中
//      3.最后用sb(StringBuffer)再从后遍历该字符串数组，遇到空格则跳过，不是空格则执行sb.spand(String[i])+" "
//      4.最后返回sb.toString()即可
public class 反转单词顺序 {
    public static String reverseWords(String s) {
        String string = s.trim();
        String[] strings = string.split(" ");
        int i;
        StringBuffer sb = new StringBuffer();
        for(i=strings.length - 1;i > 0;i--){
            if(strings[i].equals("")) continue;
            sb.append(strings[i] + " ");
        }
        sb.append(strings[i]);
        return sb.toString();

    }
    public static void main(String[] args) {
        String str = new String("  dh d ");
        System.out.println(str.length());
        str = reverseWords(str);
        System.out.println(str);
    }
}

package 字符串;
/*题目
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
输入：s = "We are happy."
输出："We%20are%20happy."

 */
//注意：   使用String 类型加法 耗时8ms    使用StringBuffer的append()方法耗时0ms
//       使用String在相加时底层会去调用append()方法
public class 替换空格 {
    public String replaceSpace(String s) {
        if(s==null)
            return null;
        StringBuffer res =  new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' ')
                res.append("%20");
            else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
/* if(s==null)
			 return null;
		 String res= new String();
		 for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==' ')
				res+="%20";
			else {
				res+=s.charAt(i);
			}
		}
		return res;
 */
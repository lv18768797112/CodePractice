package 搜索.回溯;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//        给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//        示例:
//        输入："23"
//        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//        说明:
//        尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
    private Map<Character,String> map = new HashMap<Character,String>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }
    };
    private List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans =new ArrayList<>();
        if(digits==null||digits.length()==0)
            return ans;
        char[] str = digits.toCharArray();
        // String path = new String("");
        dfs(str,0,"");
        return ans;
    }

    public void dfs(char[] str,int index,String path){
        if(index==str.length){
            ans.add(path);
            return;
        }
        char c = str[index];
        String cur = map.get(c);
        for(int i=0;i<cur.length();i++){
            // path+=cur.charAt(i);   //这里如果先将path+cur.charAt(i)再传的话 就会导致后面的
            dfs(str,index+1,path+cur.charAt(i));
        }
    }
}

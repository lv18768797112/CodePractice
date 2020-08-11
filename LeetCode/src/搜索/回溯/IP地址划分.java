package 搜索.回溯;
//给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//        有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
//
//        示例:
//        输入: "25525511135"
//        输出: ["255.255.11.135", "255.255.111.35"]

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IP地址划分 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if(s==null||s.length()<4||s.length()>12)
            return list;
        Deque<String> path = new LinkedList<>();
        dfs(s,0,4,path,list);
        return list;
    }
    public void dfs(String s,int begin,int residue,Deque<String> path,List<String> list){
        if(begin==s.length()){
            if(residue==0){
                list.add(String.join(".",path));
                return;
            }
        }
        //开始递归
        for (int i = begin; i <begin+3 ; i++) {
            if(begin>s.length())
                break;
//            if (residue * 3 < len - i) {
//                continue;
//            }
            if(isRightNumber(s,begin,i)){
                String subStr = s.substring(begin,i+1);  //substring不包含末尾
                path.addLast(subStr);
                dfs(s,i+1,residue-1,path,list);
                path.removeLast();
            }
        }

    }
    public boolean isRightNumber(String s,int begin,int end){
        int len = end-begin+1;
        if(len>1&&s.charAt(begin)=='0')
            return false;
        int res=0;
        while(begin<=end){
            res = res*10 + s.charAt(begin)-'0';
            begin++;
        }
        return res>=0&&res<=255;
    }
}

package 栈和队列;

import java.util.HashMap;
import java.util.Stack;

public class 用栈实现括号匹配 {
    public boolean isValid(String s) {
        //这个更快一点
        if(" ".equals(s))
            return true;
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c:str){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.isEmpty()||c!=stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
    //hashmap模拟
//	private static final HashMap<Character, Character> MAP = new HashMap<Character, Character>(){
//		{
//			put('[',']');
//			put('{', '}');
//			put('(', ')');
//          put('!','!'); //防止空指针
//		}
//	};
//	public boolean isValid(String s) {
//        if(" ".equals(s))
//            return true;
//        char[] str = s.toCharArray();
//        Stack<Character> stack = new Stack<>();
//        stack.push('!');  //防止栈为空异常
//        for(char c:str){
//           if(MAP.containsKey(c))
//        	   stack.push(c);
//           else {
//        	   if(MAP.get(stack.pop())!=c)
//        		   return false;
//           }
//        }
//        return stack.pop()=='!';
//    }
}
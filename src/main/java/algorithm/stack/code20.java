package algorithm.stack;

import java.util.Stack;

public class code20 {
//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
//    有效字符串需满足：
//
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    每个右括号都有一个对应的相同类型的左括号。
//
//
//    示例 1：
//
//    输入：s = "()"
//
//    输出：true
//
//    示例 2：
//
//    输入：s = "()[]{}"
//
//    输出：true
//
//    示例 3：
//
//    输入：s = "(]"
//
//    输出：false
//
//    示例 4：
//
//    输入：s = "([])"
//
//    输出：true
    public static void main(String[] args) {
        char a = ')';
        char b = ']';
        char c = '}';

//        char a1 = (char) (a-1);

        System.out.println((char)(a-1) + " " + (char)(b-2) + " " + (char)(c-2));

    }

    public boolean isValid(String s) {
        if(s.length()%2==1){
            return false;
        }
        Stack<Character> charStack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);

            //如果是( { [入栈
            if(s.charAt(i) == '(' || s.charAt(i) =='[' ||s.charAt(i) =='{'){
                charStack.add(s.charAt(i));
            }
            else {
                //如果栈为空，结束退出
                if (charStack.isEmpty()){
                    flag = false;
                    break;
                }
                //如果栈顶元素匹配，出栈栈
                else if (charStack.peek()==ss-1 || charStack.peek()==ss-2) {
                    charStack.pop();
                }
                //如果栈顶元素不匹配，结束退出
                else {
                    flag = false;
                    break;
                }

            }

        }
        if (!charStack.isEmpty()) flag = false;
        return  flag;
    }
}

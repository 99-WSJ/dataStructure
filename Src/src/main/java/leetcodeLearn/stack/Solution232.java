package leetcodeLearn.stack;

import java.util.Stack;

/**
 * @author wsj
 * @description: 用栈实现队列
 * @date 2025年03月10日 20:57
 */
public class Solution232 {
    Stack<Integer> s1 ;
    Stack<Integer> s2 ;

    public Solution232() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);

    }

    public int pop() {
        if(!s2.isEmpty()) return s2.pop();
        while (!s1.isEmpty()){
            s2.push(s1.pop());
        }
       return s2.pop();
    }

    public int peek() {
        if(!s2.isEmpty()) return s2.peek();
        while(!s1.isEmpty()) {
            Integer temp = s1.pop();
            s2.push(temp);
        }
        return s2.peek();

    }

    public boolean empty() {
        return s1.isEmpty() && s2.empty();
    }
}

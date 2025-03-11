package leetcodeLearn.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wsj
 * @description: 用队列实现栈
 * @date 2025年03月10日 23:12
 */
public class Solution225 {
    Queue<Integer> que;
    Solution225(){
        que = new LinkedList<>();
    }
    void push(int x) {
        int size = que.size();
        que.offer(x);
        while(size > 0) {
            que.offer(que.poll());
            size--;
        }
    }
    int pop() {
        return que.poll();

    }
    boolean empty(){
        return que.isEmpty();
    }
    int peek() {
        return que.peek();
    }

}

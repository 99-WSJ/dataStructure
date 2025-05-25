package handwrite;

import cn.hutool.core.lang.tree.Tree;
import exam.test.Person;
import org.junit.internal.runners.statements.RunAfters;
import structure.sort.QuickSort;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Src
 * @description:  三个线程交替打印123，
 * 线程1打印1，线程2打印2，线程3打印3，线程1打印4
 * @author: wsj
 * @create: 2024-09-27 11:08
 **/
public class test {
    public static void main(String[] args) {
        TreeRoot treeRoot = new TreeRoot(1);
        Queue<TreeRoot> que = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        que.offer(treeRoot);
        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            while(size > 0) {
                TreeRoot temp = que.poll();
                list.add(temp.val);
                if(temp.left != null)  que.offer(temp.left);
                if(temp.right != null)  que.offer(temp.right);
                size--;
            }
            res.add(list);


        }
    }



}
class TreeRoot{
    int val;
    TreeRoot left;
    TreeRoot right;

    TreeRoot(int val) {this.val = val;}

}


package leetcodeLearn.hot.hundred;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: Src
 * @description: 课程表
 * @author: wsj
 * @create: 2024-10-29 12:59
 **/
public class hot53 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            ++inDegree[prerequisites[i][0]];
        }
        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                que.offer(i);
            }
        }
        int visited = 0;
        while(!que.isEmpty()){
            visited++;
            int u = que.poll();
            for(int v : list.get(u)) {
                inDegree[v]--;
                if(inDegree[v] == 0) {
                    que.offer(v);
                }
            }
        }

        System.out.println(visited == numCourses);

    }

}

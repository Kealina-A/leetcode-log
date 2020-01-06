package week4.I210_CourseScheduleII;

import java.util.LinkedList;

public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        int[][] pre = new int[][]{{0, 1}};
        int[] order = solution.findOrder(2, pre);
        System.out.println(order);
    }

    public int[] findOrder (int numCourses, int[][] prerequisites) {

        LinkedList<Integer>[] l = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            l[i] = new LinkedList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            l[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        boolean[] visited = new boolean[numCourses];
        int[] values = new int[numCourses];
        int count = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < l.length; i++) {
                if (! visited[i] && l[i].isEmpty()) {
                    visited[i] = true;
                    values[count++] = i;
                    flag = true;
                    for (int j = 0; j < l.length; j++) {
                        if (! visited[j] && ! l[j].isEmpty()) {
                            l[j] = xx(l[j], i);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (! visited[i]) {
                return new int[0];
            }
        }
        return values;
    }

    public LinkedList xx (LinkedList<Integer> l, int target) {
        LinkedList tmp = new LinkedList(l);
        for (Integer i : l) {
            if (i == target) {
                tmp.remove(i);
            }
        }
        return tmp;
    }

}

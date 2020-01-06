package week4.I210_CourseScheduleII;

import java.util.LinkedList;

public class Solution3 {

    public static void main (String[] args) {
        Solution3 solution = new Solution3();
        int[][] pre = new int[][]{{1, 0}};
        int[] order = solution.findOrder(2, pre);
        for (int i : order) {
            System.out.print(i + ",");
        }
    }

    private int[] flag, list;
    private int top;
    private LinkedList[] link;

    public int[] findOrder (int numCourses, int[][] prerequisites) {
        if ((numCourses * (numCourses - 1) >> 1) < prerequisites.length) {
            return new int[0];
        }
        flag = new int[numCourses + 1];
        list = new int[numCourses];
        link = new LinkedList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            link[i] = new LinkedList();
        }

        for (int[] e : prerequisites) {
            link[e[1]].add(e[0]);
        }
        top = 0;
        for (int i = 1; i <= numCourses; i++) {
            if (! dfs(i - 1)) {
                return new int[0];
            }
        }
        return list;
    }

    private boolean dfs (int x) {
        if (flag[x] == 1) {
            return false;
        }
        if (flag[x] == 2) {
            return true;
        }
        flag[x] = 1;

        LinkedList<Integer> linkedList = link[x];
        for (Integer i : linkedList) {
            if (! dfs(i)) {
                return false;
            }
        }
        flag[x] = 2;
        list[top++] = x - 1;
        return true;
    }

}

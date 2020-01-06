package week4.I210_CourseScheduleII;

import java.util.LinkedList;
import java.util.List;

public class Solution1 {

    public static void main (String[] args) {
        Solution1 solution = new Solution1();
        int[][] pre = new int[][]{{1, 0}};
        int[] order = solution.findOrder(2, pre);
        for (int i : order) {
            System.out.print(i + ",");
        }
    }

    public int[] findOrder (int numCourses, int[][] prerequisites) {

        LinkedList[] link = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            link[i] = new LinkedList();
        }

        int[] inDegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int start = prerequisites[i][1];
            int end = prerequisites[i][0];
            inDegrees[end]++;
            link[start].add(end);
        }

        List<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int count = 0;
        while (! queue.isEmpty()) {
            Integer node = queue.get(0);
            LinkedList<Integer> linkedList = link[node];
            for (Integer start : linkedList) {
                inDegrees[start]--;
                if (inDegrees[start] == 0) {
                    queue.add(start);
                }
            }
            res[count++] = node;
            queue.remove(0);
        }
        if (numCourses != count) {
            return new int[0];
        }
        return res;
    }

}

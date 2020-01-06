package week4.I207_CourseSchedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 执行结果：通过 显示详情 执行用时 :184 ms, 在所有 Java 提交中击败了6.28%的用户 内存消耗 :54.5 MB, 在所有 Java 提交中击败了24.28%的用户
 */
public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        int[][] pre = new int[][]{{1, 0}, {2, 1}, {3, 2}, {1, 3}};
        System.out.println(solution.canFinish(4, pre));
    }

    public boolean canFinish (int numCourses, int[][] prerequisites) {

        if (numCourses == 0) {
            return true;
        }
        // 构建图 邻接表
        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);
        // 判断是否有环
        boolean[] marked = new boolean[numCourses];
        for (Integer key : graph.keySet()) {
            if (hasRound(marked, key, true, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasRound (boolean[] marked, int current, boolean isRoot, Map<Integer, List<Integer>> graph) {
        if (marked[current] && ! isRoot) {
            return true;
        }
        List<Integer> integers = graph.get(current);
        if (null == integers) {
            return false;
        }
        marked[current] = true;
        for (Integer integer : integers) {
            if (hasRound(marked, integer, false, graph)) {
                return true;
            }
            ;
        }
        marked[current] = false;
        return false;
    }

    private Map<Integer, List<Integer>> buildGraph (int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>(numCourses);
        for (int[] p : prerequisites) {
            List<Integer> integers = graph.get(p[1]);
            if (null == integers) {
                List<Integer> objects = new ArrayList<>();
                objects.add(p[0]);
                graph.put(p[1], objects);
            } else {
                integers.add(p[0]);
            }
        }
        return graph;
    }


}

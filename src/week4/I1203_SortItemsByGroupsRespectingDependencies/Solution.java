package week4.I1203_SortItemsByGroupsRespectingDependencies;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main (String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> beforeItems = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            beforeItems.add(new ArrayList<>());
        }
        int[] group = {2, 0, - 1, 3, 0};
        int[][] pre = new int[][]{{2, 1, 3}, {2, 4}, {}, {}, {}};
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre[i].length; j++) {
                beforeItems.get(i).add(pre[i][j]);
            }
        }

        int[] ints = solution.sortItems(5, 5, group, beforeItems);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }

    /**
     * @param n           项目个数
     * @param m           小组个数
     * @param group       小组
     * @param beforeItems 先决项目
     * @return 项目排序结果
     */
    public int[] sortItems (int n, int m, int[] group, List<List<Integer>> beforeItems) {

        int[] inDegree = new int[n];
        int maxGroup = 0;
        HashSet groupHash = new HashSet<Integer>();
        // 邻接表
        ArrayList[] link = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            link[i] = new ArrayList<>();
            if (maxGroup < group[i]) {
                maxGroup = group[i];
            }
        }
        maxGroup++;
        //构造 group 邻接表
        ArrayList[] groupLink = new ArrayList[maxGroup];
        int[] groupInDegree = new int[maxGroup];
        for (int i = 0; i < maxGroup; i++) {
            groupLink[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int curGroup = group[i];
            groupHash.add(group[i]);
            List<Integer> list = beforeItems.get(i);
            inDegree[i] = list.size();
            if (! list.isEmpty()) {
                for (Integer it : list) {
                    if (curGroup != - 1 && group[it] != - 1 && curGroup != group[it]) {
                        groupInDegree[curGroup]++;
                        groupLink[group[it]].add(curGroup);
                    }
                    link[it].add(i);
                }
            }
        }

        List<Integer> queueGroup = new LinkedList<>();
        List<Integer> queueGroupList = new LinkedList<>();
        for (int i = 0; i < maxGroup; i++) {
            if (groupInDegree[i] == 0) {
                queueGroup.add(i);
            }
        }
        int queueCount = 0;
        while (! queueGroup.isEmpty()) {
            Integer node;
            node = queueGroup.get(0);
            queueGroup.remove(0);
            if (groupHash.contains(node)) {
                queueGroupList.add(node);
            }
            queueCount++;
            //  删除相关 node 的入度
            List<Integer> list = groupLink[node];
            for (Integer j : list) {
                groupInDegree[j]--;
                if (groupInDegree[j] == 0) {
                    queueGroup.add(j);
                }
            }
        }

        if (queueCount != maxGroup) {
            return new int[0];
        }

        List<Integer> queue = new LinkedList<>();
        List<Integer> queueNoGroup = new LinkedList<>();
        LinkedList[] maxGroupList = new LinkedList[maxGroup];
        int curGroup = - 1;
        for (int i = 0; i < maxGroup; i++) {
            maxGroupList[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (group[i] == - 1) {
                    queueNoGroup.add(i);
                } else {
                    maxGroupList[group[i]].add(i);
                }
            }
        }

        int flag = - 1;
        int[] res = new int[n];
        int index = 0;
        if (! queueGroupList.isEmpty()) {
            curGroup = queueGroupList.get(0);
            queueGroupList.remove(0);
        }
//        List<Integer> queueNoGroup = new LinkedList<>();
        while (! queue.isEmpty() || ! maxGroupList[curGroup].isEmpty()) {
            Integer node = 0;
            if (flag == - 1) {
                if (! queueNoGroup.isEmpty()) {
                    node = queueNoGroup.get(0);
                    queueNoGroup.remove(0);
                } else {
                    flag = 1;
                    continue;
                }
            } else {
                node = (Integer) maxGroupList[curGroup].get(0);
                maxGroupList[curGroup].remove(0);
            }

            res[index++] = node;
            //  删除相关 node 的入度
            List<Integer> list = link[node];
            for (Integer j : list) {
                inDegree[j]--;
                if (inDegree[j] == 0) {
                    if (group[j] == - 1) {
                        queueNoGroup.add(j);
                    } else {
                        maxGroupList[group[j]].add(j);
                    }
                }
            }
            if (flag == 1) {
                if (maxGroupList[curGroup].isEmpty()) {
                    if (! queueGroupList.isEmpty()) {
                        flag = - 1;
                        curGroup = queueGroupList.get(0);
                        queueGroupList.remove(0);
                    }
                }
            }
        }

        if (index != n) {
            return new int[0];
        }
        return res;
    }


}

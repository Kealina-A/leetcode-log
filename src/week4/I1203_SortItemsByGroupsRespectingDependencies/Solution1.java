package week4.I1203_SortItemsByGroupsRespectingDependencies;


import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public static void main (String[] args) {
        Solution1 solution = new Solution1();
        List<List<Integer>> beforeItems = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            beforeItems.add(new ArrayList<>());
        }
        int[] group = {2, 0, - 1, 3, 0, 3};
        int[][] pre = new int[][]{{2, 1, 3, 5}, {2, 4}, {}, {}, {}, {}};
        for (int i = 0; i < pre.length; i++) {
            for (int j = 0; j < pre[i].length; j++) {
                beforeItems.get(i).add(pre[i][j]);
            }
        }
        int[] ints = solution.sortItems(6, 5, group, beforeItems);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }

    private int[] res;
    private int k;

    // 建图
    // 遍历
    public int[] sortItems (int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int nGroup = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == - 1) {
                group[i] = nGroup++;
            }
        }

        Node[] groupNodes = new Node[nGroup];

        for (int i = 0; i < nGroup; i++) {
            groupNodes[i] = new Node(i, new ArrayList<>());
        }
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, null);
            groupNodes[group[i]].subNodes.add(nodes[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int before : beforeItems.get(i)) {
                if (group[i] == group[before]) {
                    nodes[before].nexts.add(nodes[i]); // 组内图的建立
                } else {
                    groupNodes[group[before]].nexts.add(groupNodes[group[i]]); // 组间图的建立
                }
            }
        }

        res = new int[n];
        k = n - 1;

        for (Node node : groupNodes) {
            if (! find(node)) {
                return new int[0];
            }
        }
        return res;
    }


    private boolean find (Node node) {
        if (node.visit == 1) {
            return false;
        } else if (node.visit == 2) {
            return true;
        }

        node.visit = 1;
        for (Node next : node.nexts) {
            if (! find(next)) {
                return false;
            }
        }

        node.visit = 2;

        if (node.subNodes == null) {
            res[k--] = node.id;
            return true;
        }

        for (Node subNode : node.subNodes) {
            if (! find(subNode)) {
                return false;
            }
        }
        return true;
    }


    private static class Node {
        int id;
        List<Node> nexts;
        List<Node> subNodes;
        int visit; // 0: 表示没有访问，1：正在访问，2：访问完成

        Node (int id, List<Node> subNodes) {
            this.id = id;
            this.subNodes = subNodes;
            this.nexts = new ArrayList<>();
        }
    }
}

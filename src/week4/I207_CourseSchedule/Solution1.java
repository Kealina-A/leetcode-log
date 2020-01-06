package week4.I207_CourseSchedule;

import java.util.Arrays;

/**
 * 执行结果：通过 显示详情 执行用时 :38 ms, 在所有 Java 提交中击败了59.98%的用户 内存消耗 :46.3 MB, 在所有 Java 提交中击败了56.23%的用户
 */
public class Solution1 {

    public static void main (String[] args) {
        Solution1 solution = new Solution1();
        int[][] pre = new int[][]{{0, 1}};
        boolean order = solution.canFinish(2, pre);
        System.out.println(order);
    }

    /*边缘列表 实现邻接链表存储图信息*/
    int[] head_next;     //下一个顶点 顶点指针
    int[] edge_next; //n个顶点 最多可以有n*(n-1)条边
    int[] edge_u;    //起始点u
    int[] edge_v;    //到达定点v
    boolean[] dp_flag;
    int[] ingress;
    int edge_num;

    public boolean canFinish (int numCourses, int[][] prerequisites) {

        edge_num = prerequisites.length;
        if (edge_num > numCourses * (numCourses - 1) / 2) {
            return false;
        }
        head_next = new int[numCourses];
        edge_next = new int[edge_num];
        edge_u = new int[edge_num];
        edge_v = new int[edge_num];
        dp_flag = new boolean[numCourses];
        ingress = new int[numCourses];

        Arrays.fill(head_next, - 1);
        Arrays.fill(edge_next, - 1);
        for (int i = 0; i < edge_num; i++) {
            int u, v;
            u = prerequisites[i][1];  //从 0 - 1 的边 u = 起始顶点
            v = prerequisites[i][0];  //从 0 - 1 的边 v = 结束顶点
            edge_u[i] = u;        //保存了起始点但目前没用上
            edge_v[i] = v;
            edge_next[i] = head_next[u];//next 指向顶点v原来的next从链表前部插入(实际链表是从尾部插入)
            head_next[u] = i;     //将顶点指针指向当前边(指向边)
            ingress[v]++;
        }

        for (int vertex = 0; vertex < numCourses; vertex++)//遍历所有顶点
        {
            if (ingress[vertex] == 0 && dfs(vertex, 0))//有环
            {
                return false;
            }
        }
        for (int i = 0; i < dp_flag.length; i++) {
            if (! dp_flag[i]) {
                return false;
            }
        }
        return true;
    }


    private boolean dfs (int vertex, int deep) {
        if (dp_flag[vertex] && deep > 1)//有环
        {
            return true;
        }

        if (dp_flag[vertex]) //已访问此顶点并且没有环则直接返回访问完成
        {
            return false;
        }

        dp_flag[vertex] = true; //顶点已访问
        for (int edge = head_next[vertex]; edge != - 1; edge = edge_next[edge])//遍历当前顶点所有边 每条边有起始点u和终点v的信息可用
        {
            if (dfs(edge_v[edge], deep + 1))//从边的终点v继续访问结点
            {
                return true;  //有环直接访问完毕退出
            }
        }

        return false;
    }

}

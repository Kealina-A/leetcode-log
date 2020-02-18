/**
 * ******************************************************************
 * Date: 2020/2/18  Tue
 * ******************************************************************
 * Title:
 * ******************************************************************
 * 执行耗时: ms,击败了 % 的Java用户
 * 内存消耗: MB,击败了 % 的Java用户
 * ******************************************************************
 */
public class ToolUtil {

    public static void main (String[] args) {
//        * [【E】155. MinStack](https://github.com/Kealina-A/leetcode-log/blob/master/src/week8/E155MinStack/MinStack.java)
        String[] x = new String[]{
                "E21MergeTwoSortedLists",
                "E83RemoveDuplicatesFromSortedList",
                "E206ReverseLinkedList",
                "H23MergeKSortedLists",
                "H25ReverseNodesInKGroup",
                "M19RemoveNthNodeFromEndOfList",
                "M24SwapNodesInPairs",
                "M61RotateList",
                "M82RemoveDuplicatesFromSortedListII",
                "M86PartitionList"};
        String week = "week9";
        for (String s : x) {
            String level = s.charAt(0) + "";
            String substring = s.substring(1);
            int count = 0;
            while (Character.isDigit(substring.charAt(count))) {
                count++;
            }
            String num = substring.substring(0, count);
            String title = substring.substring(count);
//            System.out.println(level);
//            System.out.println(num);
//            System.out.println(title);
            System.out.println("* [【" + level + "】" + num + ". " + title + "](https://github.com/Kealina-A/leetcode-log/blob/master/src/" + week + "/" + s + "/Solution.java)");
        }

    }
}

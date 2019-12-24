package week2.I39CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        backTrack(new ArrayList<>(),target,0);
        return ans;
    }

    public void backTrack (List<Integer> list, int target,int start) {
        if (target<0) return;
        if (target==0) {
            ans.add(new ArrayList<>(list));
            System.out.println(list);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (target<candidates[i]) continue;
            temp.add(candidates[i]);
            backTrack(temp,target-candidates[i],i);
            temp.remove(temp.size()-1);
        }
    }
}

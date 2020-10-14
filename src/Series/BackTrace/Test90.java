package Series.BackTrace;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author rope
 * @Date 2020/8/25 23:44
 * @Version 1.0
 */
/*
* 90 子集2
* https://leetcode-cn.com/problems/subsets-ii/
* */
public class Test90 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> temp = new LinkedList<>();
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums==null) return res;
        res.add(temp);
        backtrace(nums,0);
        return res;
    }

    private void backtrace(int[] nums,int index) {
        if(temp.size()>1 && set.contains(new LinkedList<>(temp))){
            res.add(new LinkedList<>(temp));
        }

        for(int i = index;i < nums.length;i++){


            temp.add(nums[i]);

            backtrace(nums,index+1);

            temp.remove(temp.size()-1);
        }
    }

}

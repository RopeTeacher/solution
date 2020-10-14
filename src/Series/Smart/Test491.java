package Series.Smart;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author rope
 * @Date 2020/8/25 8:49
 * @Version 1.0
 */
/*
* 491. 递增子序列
* https://leetcode-cn.com/problems/increasing-subsequences/
* 思路：找出所有子集 然后判断这些子集是否是递增序列
* 当测试用例比较多时会出现超时的情况
* 需要想别的解决办法
* */
public class Test491 {
    List<List<Integer>> res = new LinkedList<>();
    List<List<Integer>> r = new LinkedList<>();
    List<List<Integer>> myr = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        res.add(new LinkedList<>());
        for(int i = 0;i < nums.length;i++){
            int s = res.size();
            for(int j = 0;j < s;j++){
                LinkedList<Integer> list = new LinkedList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        for(List list : res){
            if(valid(list)){
                r.add(list);
            }
        }
        List<List<Integer>> myr = r.stream().distinct().collect(Collectors.toList());
        return myr;
    }

    private boolean valid(List list) {
        if(list.size()<2) return false;
        for(int i = 0;i < list.size()-1;i++){
            if ((int)list.get(i) > (int)list.get(i+1)) return false;
        }
        return true;
    }
}

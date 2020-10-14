package Series.BF;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author rope
 * @Date 2020/9/20 10:09
 * @Version 1.0
 */
public class Test78 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        if(nums == null || nums.length == 0) return res;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            int size = res.size();
            for(int j = 0;j < size;j++){
                ArrayList<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Test78().subsets(new int[]{}));
    }
}

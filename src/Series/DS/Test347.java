package Series.DS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author rope
 * @Date 2020/9/7 7:39
 * @Version 1.0
 */
/*
* 347.前K个高频元素
* https://leetcode-cn.com/problems/top-k-frequent-elements/
* */
public class Test347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        //最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for(Integer key:map.keySet()){
            //如果还未装到k个元素
            if(queue.size() < k){
                queue.add(key);
            }else if (map.get(key) > map.get(queue.peek())){
                queue.remove();
                queue.add(key);
            }
        }

        while (!queue.isEmpty()){
            res[count++] = queue.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,0,1,0};
        int k = 1;
        int[] res = new Test347().topKFrequent(arr, k);
        System.out.println(Arrays.toString(res));
    }
}

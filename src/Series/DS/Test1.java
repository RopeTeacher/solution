package Series.DS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author rope
 * @Date 2020/8/24 10:21
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }else {
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        for(int i = 0;i < n;i++){
            int temp = target - arr[i];
            if(map.containsKey(temp)){
                System.out.println(Arrays.toString(new int[]{i,map.get(temp)}));
            }
        }
    }
}

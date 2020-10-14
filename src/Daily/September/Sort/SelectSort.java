package Daily.September.Sort;

import java.util.Arrays;

/**
 * @Author rope
 * @Date 2020/9/3 23:25
 * @Version 1.0
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0;i < len;i++){
            int min = i;
            for (int j = i+1;j < len;j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i) swap(i,min,arr);
        }
    }

    public static void swap(int a,int b,int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

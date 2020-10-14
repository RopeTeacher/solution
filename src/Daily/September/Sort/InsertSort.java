package Daily.September.Sort;

import java.util.Arrays;

/**
 * @Author rope
 * @Date 2020/9/3 23:20
 * @Version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        int len = arr.length;
        for(int i = 0;i < len;i++){
            //有i+1中插入方式
            for(int j = 1;j <= i+1;j++){
                if(arr[j-1] > arr[j]){
                    swap(j-1,j,arr);
                }
            }
        }
    }

    public static void swap(int a,int b,int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

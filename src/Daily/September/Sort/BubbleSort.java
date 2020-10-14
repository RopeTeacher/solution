package Daily.September.Sort;

import java.util.Arrays;

/**
 * @Author rope
 * @Date 2020/9/3 22:36
 * @Version 1.0
 */
/*
* 冒泡排序
* 通过相邻的元素进行比较，让较大或者较小的元素浮到一边
* */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        int len = arr.length;
        //len个数
        for(int i = 0;i < len;i++){
            //当前位置要冒泡1的次数
            for(int j = 0;j < len-i-1;j++){
                if(arr[j] > arr[j+1]){
                    swap(j,j+1,arr);
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

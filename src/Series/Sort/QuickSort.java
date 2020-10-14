package Series.Sort;

import java.util.Arrays;

/**
 * @Author rope
 * @Date 2020/9/15 15:18
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,5,1,6};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right) {
        if(left < right){
            dealP(arr,left,right);
            int p = right - 1;
            int i = left;int j = right - 1;
            while (true){
                while (i < right && arr[++i] < arr[p]){ }
                while (j > left && arr[--j] > arr[p]){ }
                if(i < j){
                    swap(arr,i,j);
                }else
                    break;
            }
            swap(arr,i,right-1);

            sort(arr,left,i-1);
            sort(arr,i+1,right);
        }
    }

    public static void dealP(int[] arr,int left,int right){
        int mid = left + (right - left)/2;
        if(arr[left] > arr[right]){
            swap(arr,left,right);
        }
        if(arr[left] > arr[mid]){
            swap(arr,left,mid);
        }
        if(arr[mid] > arr[right]){
            swap(arr,mid,right);
        }
        swap(arr,mid,right-1);
    }


    public static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

package Daily.September.Sort;

import java.util.Arrays;

/**
 * @Author rope
 * @Date 2020/9/3 23:33
 * @Version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,2,5,1,6};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right){
            //左中右三数排好序了
            dealp(arr,left,right);
            int p = right - 1;
            //建立用于遍历的双指针
            int i = left;int j = right-1;
            while (true){
                while (arr[++i] < arr[p]){
                }
                while (j > left&&arr[--j] > arr[p]){
                }
                if(i < j){
                    swap(i,j,arr);
                }else {
                    break;
                }
            }
            if(i < right){
                swap(i,p,arr);
            }
            quickSort(arr,left,i-1);
            quickSort(arr,i+1,right);
        }

    }

    public static void dealp(int[] arr,int left,int right){
        int mid = left+(right-left)/2;
        if(arr[left]>arr[mid]){
            swap(left,mid,arr);
        }
        if(arr[left]>arr[right]){
            swap(left,right,arr);
        }
        if (arr[mid]>arr[right]){
            swap(mid,right,arr);
        }
        swap(mid,right-1,arr);
    }

    public static void swap(int a,int b,int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

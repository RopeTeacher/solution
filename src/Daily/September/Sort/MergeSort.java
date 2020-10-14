package Daily.September.Sort;

import java.util.Arrays;

/**
 * @Author rope
 * @Date 2020/9/4 1:24
 * @Version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] temp = new int[len];
        sort(temp,arr,0,len-1);
    }

    private static void sort(int[] temp, int[] arr, int left, int right) {
        if(left < right){
            int mid = left + (right-left)/2;
            sort(temp,arr,left,mid);
            sort(temp,arr,mid+1,right);
            merge(arr,left,mid,right,temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }
}

package Daily.August;

import java.util.Arrays;

public class Test30 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,1,5,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if(right > left){
            int mid = left + (right - left)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid+1;
        int t = 0;
        while (i <= mid && j <= right){
            if (arr[i] <= arr[j]){
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

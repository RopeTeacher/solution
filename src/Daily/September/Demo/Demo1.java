package Daily.September.Demo;

import java.util.Arrays;

/**
 * @Author rope
 * @Date 2020/9/15 15:39
 * @Version 1.0
 */

public class Demo1 {
    public static void main(String[] args) {
        int[] ints = {4, 5, 1, 2, 3};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    private static void sort(int[] ints) {
        int t = 0;
        for(int i = 0;i < ints.length-1;i++){
            if(ints[i] > ints[i+1]){
                t = i;
                break;
            }
        }
        reverse(ints,0,t);
        reverse(ints,t+1,ints.length-1);
        System.out.println(Arrays.toString(ints));
        reverse(ints,0,ints.length-1);
    }

    public static void reverse(int[] arr,int start,int end){
        int mid = start + (end - start)/2;
        for(int i = start;i <= mid;i++){
            swap(i,end--,arr);
        }
    }

    public static void swap(int a,int b,int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

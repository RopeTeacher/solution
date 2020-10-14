package Series.Double;

import java.util.Arrays;

/**
 * @Author rope
 * @Date 2020/8/22 4:47
 * @Version 1.0
 */
/*
 * 合并两个有序数组
 * https://leetcode-cn.com/problems/sorted-merge-lcci/
 * */
public class Test10_01 {
    public void merge(int[] A, int m, int[] B, int n) {
        if(m == 0){
            for(int i = 0;i < B.length;i++){
                A[i] = B[i];
            }
        }
        int j = m - 1;
        int k = n - 1;
        int count = A.length - 1;
        while (j >= 0 && k >= 0) {
            if (A[j] >= B[k]) {
                A[count] = A[j];
                count--;
                j--;
            } else {
                A[count] = B[k];
                count--;
                k--;
            }
        }
        if (j == -1 && k != -1) {
            for (int i = k - 1; k >= 0; k--) {
                A[count--] = B[k];
            }
        }
        if (j != -1 && k == -1) {
            for (int i = j - 1; j >= 0; j--) {
                A[count--] = A[j];
            }
        }
    }

    public static void main(String[] args) {
        int[] dp = new int[]{1,2};
        int[] dp1 = new int[]{1,2,3};
        dp = dp1.clone();
        System.out.println(Arrays.toString(dp));
    }

}

package com.jtli.practice.arthmetic;

import java.util.Arrays;

/**
 * @Classname DynamicPlan
 * @Description <p>
 * 利用动态规划求解背包问题
 * </p>
 * @Date 2024/4/13 17:04
 * @Author by jtlee
 * @Version 1.0.0
 */
public class DynamicPlan {
    private static final int N = 6;
    private static final int maxT = 1000;

    static int[][] c = new int[N][12];// 12 表示用于求解0-11 每个重量最优解
    static int[] v = {0, 1, 6, 18, 22, 28};
    static int[] w = {0, 1, 2, 5, 6, 7};
    static int count = 0;

    /**
     * 一共6个元素，重量为11 array[6][11+1]
     * <pre>
     * {@code
     * [
     *  [-1, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0],
     *  [-1, -1, 1, 1, 1, 1, 1, -1, -1, 1, -1, 1],
     *  [0, -1, -1, -1, 7, 7, 7, -1, -1, -1, -1, 7],
     *  [-1, -1, -1, -1, 7, 18, -1, -1, -1, -1, -1, 25],
     *  [-1, -1, -1, -1, 7, -1, -1, -1, -1, -1, -1, 40],
     *  [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40],
     * ]
     * }
     * </pre>
     * @param args
     */
    public static void main(String[] args) {
        System.out.printf("result = %d",Memoized_Knapsack(v,w,11));
        System.out.println();
        for (int[] ints : c) {
            System.out.println(Arrays.toString(ints));
        }
    }


    /**
     *
     * @param v
     * @param w
     * @param T 背包最大容量
     * @return
     */
    private static int Memoized_Knapsack(int[] v, int[] w, int T) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= T ; j++) {
                c[i][j] = -1;
            }
        }
        return Calculate_Max_Value(v,w,N-1,T);
    }

    /**
     *
     * @param v 物品价值
     * @param w 物品重量
     * @param i 当前物品的索引
     * @param j 当前背包剩余容量
     * @return
     */
    private static int Calculate_Max_Value(int[] v, int[] w, int i, int j) {
        int temp = 0;
        if (c[i][j] != -1){
            return c[i][j];
        }
        if (i==0|| j==0){
            c[i][j]=0;
        }else{
            c[i][j] = Calculate_Max_Value(v,w,i-1,j);
            if (j>=w[i]){ //是否可装入
                // 递归求解当前步骤最优解
                temp = Calculate_Max_Value(v,w,i-1,j-w[i])+v[i];
                if (c[i][j] < temp) {
                    c[i][j] = temp;
                }
            }
        }
        if (c[i][j]>=0){
            count++;
            System.out.printf("c[%d][%d]=%d\t",i,j,c[i][j]);
        }
        if (count%3==0) System.out.println();
        return c[i][j];
    }
}

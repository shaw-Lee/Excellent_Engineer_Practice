package com.jtli.practice.arthmetic;

/**
 * @Classname Knapsack
 * @Description <p>
 *      回溯法求01背包问题
 * </p>
 * @Date 2024/4/13 11:32
 * @Author by jtlee
 * @Version 1.0.0
 */
public class Knapsack {
    static int current_weight = 0; //当前背包容量
    static float current_profit = 0f;//当前背包价值
    static int W = 22;//背包最大容量
    static int n = 3;
    static int[] Weights = {15, 10, 10};// 重量
    static float[] Values = {30, 18, 17};// 价值
    static float[] VW = {2f, 1.8f, 1.7f};// 单位价值

    /**
     * 计算上界函数 功能为剪枝
     * @param Profit_Gained
     * @param Weight_Used
     * @param k
     * @return
     */
    static float bound(float Profit_Gained,int Weight_Used,int k) {
        for (int i = k + 1; i < n; i++) {
            if (Weight_Used + Weights[i] <= W) {
                Profit_Gained += Values[i];
                Weight_Used += Weights[i];
            } else {
                Profit_Gained += VW[i] * (W - Weight_Used);
//                Weight_Used = W;
                return Profit_Gained;
            }
        }
        return Profit_Gained;
    }

    public static void main(String[] args) {

        knapsack();

    }

    public static void knapsack() {

        int Weight = 0;
        float Profit = -1f;
        int index = 0;
        int[] X = new int[n+1];
        int[] Y = new int[n+1];
        for (int j = 0; j < n; j++) {
            X[j] = -1;
            Y[j] = -1;

        }
        while (true) {
            while (index < n && current_weight + Weights[index] <= W) {
                current_profit += Values[index];
                current_weight += Weights[index];
                Y[index] = 1;
                index++;
            }
            if (index >= n) {
                Weight = current_weight;
                Profit = current_profit;
                index = n;
                if (n >= 0) System.arraycopy(Y, 0, X, 0, n);
            } else {
                Y[index] = 0;
            }
            while (bound(current_profit,current_weight,index) <= Profit) {
                while (index != 0 && Y[index] != 1) {
                    index--;
                }

                if (index == 0) {
                    for (int i = 0; i < n; i++) {
                        System.out.printf("X[%d]=%d\t", i, X[i]);
                        System.out.printf("profit=%f\tweight=%d\n", Profit, Weight);
                    }

                    if (Y[0] == 0) {
                        return;
                    } else {
                        Y[0] = 0;
                        current_weight = 0;
                        current_profit = 0;
                        Weight = 0;
                        Profit = -1;
                        continue;
                    }
                }
                Y[index] = 0;
                current_profit -= Values[index];
                current_weight -= Weights[index];
            }
            index++;
        }
    }
}


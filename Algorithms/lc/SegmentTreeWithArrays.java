package com.yyf.lc;

import java.util.Arrays;

/**
 * @author yifei yang
 */
public class SegmentTreeWithArrays {
    public static void main(String[] args) {
//        int[] input = {1,2,-3,4,-5,-6,7,8,9};
        int[] input = {1,2,3,4,5};
//        int[] input = {1,2,3,4};
        int len = input.length;
        int n = len * 2 - 1;
        int[] segTree = new int[n];
        constructTree(input, segTree, 0, len - 1, 0);
        System.out.println(Arrays.toString(segTree));
//        System.out.println(query(0, 8, 0, len - 1, segTree, 0));
    }
    public static void constructTree(int[] input, int[] segTree, int low, int high, int pos) {
        if (low == high) {
            segTree[pos] = input[low];
            return;
        }
        int mid = (low + high) / 2;
        constructTree(input, segTree, low, mid, 2 * pos + 1);
        constructTree(input, segTree, mid + 1, high, 2 * pos + 2);
        segTree[pos] = Math.min(segTree[2 * pos + 1] , segTree[2 * pos + 2]);
        segTree[pos] = segTree[2 * pos + 1] + segTree[2 * pos + 2];
    }

    public static int query(int i, int j, int low, int high, int[] segTree, int pos) {
        if (i <= low && j >= high) {
            return segTree[pos];
        }
        if (i > high || j < low) {
            return Integer.MAX_VALUE;
        }
        int mid = (low + high) / 2;
        return Math.min(query(i, j, low, mid, segTree, 2 * pos + 1),
                query(i, j, mid + 1, high, segTree, 2 * pos + 2));
    }

    public static int nextPowerOf2(int num){
        if(num == 0){
            return 1;
        }
        if(num > 0 && (num & (num-1)) == 0){
            return num;
        }
        while((num & (num-1)) > 0){
            num = num & (num-1);
        }
        return num<<1;
    }
}

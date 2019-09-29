package com.example.logindemo;

public class ArrDemo {
    public static void main(String[] args) {
        int[] ar = new int[]{1, 2, 3, 4, 3, 2, 1};
        mao(ar);
        System.out.println("================》冒泡");
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
        xuan(ar);
        System.out.println("================>选择");
        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
    }
    public static void mao(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    //=====================>选择
    public static void xuan(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]){
                    int temp = arr[j];
                    arr[j]= arr[i];
                    arr[i]=temp;
                }
            }
        }
    }
}

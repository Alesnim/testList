package com.javalesson.graphic.lists;

import java.util.Arrays;

public class MyArrayList {
    int arr[];
    int count = 0;


    public MyArrayList() {
        arr = new int[3];
    }

    public void add(int i) {
        if (count >= arr.length) {
            int a2[] = new int[arr.length * 2];
            System.arraycopy(arr, 0, a2, 0, arr.length);
            arr = a2;
            arr[count] = i;
            count++;
        } else {
            arr[count] = i;
            count++;
        }
    }




    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < count; i++) {
            res += arr[i] + " ";
        }
        return res;

    }
}

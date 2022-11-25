// Dou Jingru
// CS 272
// Lab 11
// 30 Novemeber 2021

import java.util.Scanner;

public class search {
    //find the target element e in the array of A
    public static int binarySearch(int[] A, int e) {
        int left = 0, right = A.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (A[middle] == e) {
                return middle;
            } else if (A[middle] > e) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        //-1 representing not find the element
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array length: ");
        int length = scanner.nextInt();
        int[] A = new int[length];
        for (int i = 0; i < A.length; ++i) {
            System.out.print("A[" + i + "] = ");
            A[i] = scanner.nextInt();
        }
        System.out.print("Enter the target value:");
        int value = scanner.nextInt();
        int index = binarySearch(A, value);
        if (index >= 0) {
            System.out.println("A[" + index + "] = " + value);
        } else {
            System.out.println("The value " + value + " is not in the array");
        }
    }
}

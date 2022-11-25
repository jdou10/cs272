// Dou Jingru
// CS 272
// Lab 11
// 30 Novemeber 2021

import java.util.ArrayList;
import java.util.Scanner;

public class Q3 {
    public static ArrayList<Integer> findKNearest(ArrayList<Integer> A, int k, int target) {
        int left = 0;
        int right = 0;
        if (A.get(0) >= target) {
            left = -1;
        } else if (A.get(A.size() - 1) <= target) {
            left = A.size() - 1;
            right = left + 1;
        } else {
            int l = 0, r = A.size() - 1;
            while (l <= r) {
                int position = (l + r) / 2;
                if (A.get(position) >= target) {
                    left = position - 1;
                    right = position;
                    r = position - 1;
                } else {
                    l= position + 1;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = k; i >= 1; --i) {
            if (left < 0 && right < A.size()) {
                result.add(A.get(right++));
            }
            if (right >= A.size() && left >= 0) {
                result.add(0, A.get(left--));
            }
            if (left >= 0 && right < A.size()) {
                if (Math.abs(target - A.get(left)) > Math.abs(target - A.get(right))) {
                    result.add(A.get(right++));
                } else {
                    result.add(0, A.get(left--));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number (if number is -1 then quit): ");

        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int number = scanner.nextInt();
            if (number == -1) {
                break;
            }
            list.add(number);
        }
        System.out.print("Please enter the k: ");
        int k = scanner.nextInt();
        System.out.print("Please enter the target: ");
        int target = scanner.nextInt();
        ArrayList<Integer> result = findKNearest(list, k, target);
        System.out.println("The output is " + result);

    }
}
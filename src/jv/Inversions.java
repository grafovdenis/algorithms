package jv;

import java.util.Scanner;

public class Inversions {

    private long count = 0;

    public int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] res = new int[a.length + b.length];

        for (int k = 0; k < res.length; k++) {
            if (j == b.length || i < a.length && a[i] <= b[j]) {
                res[k] = a[i];
                i++;
            } else {
                // a[i, i + 1, ..., a.length - 1] > b[j]
                count += a.length - i;
                res[k] = b[j];
                j++;
            }
        }
        return res;
    }

    public int[] mergeSort(int[] a) {
        if (a.length == 1) return a;
        int n = a.length;
        int m = n / 2;
        int[] left = new int[m];
        int[] right = new int[n - m];

        System.arraycopy(a, 0, left, 0, m);
        System.arraycopy(a, m, right, 0, n - m);

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int[] sortedA = mergeSort(a);
        System.out.println(count);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new Inversions().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ns");
    }
}

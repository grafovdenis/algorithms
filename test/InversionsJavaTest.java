import jv.Inversions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InversionsJavaTest {

    private Inversions inversions = new Inversions();

    @Test
    void mergeTest() {
        int[] a = new int[new Random().nextInt(100)];
        int[] b = new int[new Random().nextInt(100)];
        int[] expectation = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(1000);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = new Random().nextInt(1000);
        }
        System.arraycopy(a, 0, expectation, 0, a.length);
        System.arraycopy(b, 0, expectation, a.length, b.length);
        Arrays.sort(expectation);

        Arrays.sort(a);
        Arrays.sort(b);

        assertArrayEquals(inversions.merge(a, b), expectation);
    }

    @Test
    void mergeSortTest() {
        int[] a = new int[new Random().nextInt(100)];
        for (int i = 0; i < a.length; i++) {
            a[i] = new Random().nextInt(1000);
        }

        int[] expectation = new int[a.length];
        System.arraycopy(a, 0, expectation, 0, expectation.length);
        Arrays.sort(expectation);

        assertArrayEquals(expectation, inversions.mergeSort(a));
    }
}

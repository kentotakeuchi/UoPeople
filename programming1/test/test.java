package programming1.test;

import java.util.*;

class ArrayGames {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < a.length; i++)
            a[i] += a[i];
        System.out.println(Arrays.toString(a));
    }
}

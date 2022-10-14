package programming1.test;

import java.util.*;

class ArrayGames {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        for (int i = 1; i < a.length; i++)
            a[i] = a[i - 1];
        System.out.println(Arrays.toString(a));
    }
}

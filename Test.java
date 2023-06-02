import java.util.*;

public class Sample {

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				System.out.println(array[j]);

				if (array[j] > array[j + 1]) { // swap elements j and j+1
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String args[]) {
		int[] list = { 4, 8, 10, 6, 2, 8, 5 };
		bubbleSort(list);
	}

}
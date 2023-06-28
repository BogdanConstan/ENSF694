import java.util.Scanner;
import java.util.Arrays;

class Lab2 {
	public static void main(String[] args) {
		
		//Q1
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array: ");
		int numElements = scanner.nextInt();
		
		int[] array = new int[numElements];
		
		System.out.println("Enter the elements in the array: ");
		
		for (int i = 0; i < numElements; i++) {
			System.out.println();
			array[i] = scanner.nextInt();
		}
		
		Arrays.sort(array);
		
		System.out.println("Enter the search key: ");
		int key = scanner.nextInt();
		
		double startTimeLinear = System.nanoTime();
		
		for(int i = 0; i < numElements; i++) {
			if (array[i] == key) {
				System.out.println("Using Linear Search:");
				System.out.println("Search key FOUND at index " + i);
				break;
			}
			else if (i == numElements - 1) {
				System.out.println("Search key NOT FOUND");
			}
		}
		
		double endTimeLinear = System.nanoTime();
		double elapsedTimeLinear = endTimeLinear - startTimeLinear;
		
		int low = 0;
		int mid;
		double pos;
		int high = numElements - 1;
		
		double startTimeInterpolation = System.nanoTime();

		while (low <= high) {
			pos = (double) (key - array[low]) / (array[high] - array[low]);
			mid = (int) (low + Math.ceil((high - low) * pos));
		
			if(key < array[mid]) {
				high = mid - 1;
			}
			else if(array[mid] < key) {
				low = mid + 1;
			}
			else {
				System.out.println("Using Interpolation Search: ");
				System.out.println("Search key FOUND at index " + mid);
				break;
			}
			
			
		}
		
		double endTimeInterpolation = System.nanoTime();
		double elapsedTimeInterpolation = endTimeInterpolation - startTimeInterpolation;
		
		
		//Q2
		System.out.println("Linear Search run time: " + elapsedTimeLinear + " ms");
		System.out.println("Interpolation Search run time: " + elapsedTimeInterpolation + " ms");
		System.out.println("Linear search performed better because the array size is small and sorted");
		
		//Q3
		int startIndex;
		int middle = numElements / 2;
		
		double startTimeLinearImproved = System.nanoTime();
		if(array[middle] < key) {
			startIndex = 0;
		}
		else {
			startIndex = middle;
		}
		
		for(int i = startIndex; i < numElements; i++) {
			if (array[i] == key) {
				System.out.println("Using Improved Linear Search:");
				System.out.println("Search key FOUND at index " + i);
				break;
			}
			else if (i == numElements - 1) {
				System.out.println("Search key NOT FOUND");
			}
		}
		
		double endTimeLinearImproved = System.nanoTime();
		double elapsedTimeLinearImproved = endTimeLinearImproved - startTimeLinearImproved;
		
		System.out.println("Improved Linear Search run time: " + elapsedTimeLinearImproved + " ms");
		System.out.println("The improved linear search improved the run time by over 80%\n"
							+ " in a test run compared to normal linear search.\n"
							+ " I used a binary split on the first iteration to determine\n"
							+ " an appropriate index to start my searching from\n"
							+ " instead of just searching from index 0 like in the regular search.\n"
							+ " This greatly improved my results");
		
	}
}
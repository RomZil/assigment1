// מתן עזרא - 208054296
// רום זילברמן - 322547076
import java.util.*;

public class mainClass {
    public static void main(String[] args) {
        // Run on two random arrays
        for (int i=0; i<2; i++) {

            // define random array
            int[] randomArray = createRandomArray(100);

            // Printing the array
            System.out.print("Array:");
            printArray(randomArray);
            System.out.println();


            System.out.println("Value of a Local Maximum Point is:" + localMaximumPoint(randomArray));

            System.out.println("Number Of Local Maximum Points:" + numberOfLocalMaximumPoints(randomArray));
        }
    }



    public static int[] createRandomArray(int size) {
        Random rd = new Random();
        int[] randomArray = new int[size];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = rd.nextInt(100);
        }

        return randomArray;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 20 == 0) {
                System.out.println();
            }
            System.out.print(arr[i] + ", ");
        }
    }

    public static int localMaximumPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int middle = (left + right) / 2;

        while ((middle != 0 && arr[middle] <= arr[middle - 1]) ||
                (middle != arr.length - 1 && arr[middle] <= arr[middle + 1])) {

            if (arr[middle] < arr[middle + 1]) {
                left = middle + 1;
                middle = (left + right) / 2;
            } else if (arr[middle] < arr[middle - 1]) {
                right = middle - 1;
                middle = (left + right) / 2;
            }
        }

        return arr[middle];
    }

    public static int numberOfLocalMaximumPoints(int[] arr) {
        return numberOfLocalMaximumPoints(arr, 0, arr.length - 1);
    }

    public static int numberOfLocalMaximumPoints(int[] arr, int left, int right) {
        int numOfMaximumPoints = 0;
        int middle = (left + right) / 2;

        if ((middle == 0 || arr[middle] > arr[middle - 1]) &&
                (middle == arr.length - 1 || arr[middle] > arr[middle + 1])) {
            numOfMaximumPoints++;
        }

        if (left != right) {
            if (middle != left) {
                numOfMaximumPoints += numberOfLocalMaximumPoints(arr, left, middle - 1);
            }

            if (middle != right) {
                numOfMaximumPoints += numberOfLocalMaximumPoints(arr, middle + 1, right);
            }
        }

        return numOfMaximumPoints;
    }


}


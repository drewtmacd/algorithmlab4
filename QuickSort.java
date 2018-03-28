import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;


/**
 * This Class contains a Quick Sorting Method, and a Main method which runs the sorting method, while
 tracking the runtime, and checking if the arrays are correctly sorted.
 *
 * @author Drew Macdonald
 */
public class QuickSort
{
    int arraySize;
    int rangeMax;

    /**
     * Constructor for Sorter class. Contains 2 instance variables. The two parameters are both ints, arraySize and rangeMax.
     */
    public QuickSort(int arrraySize, int rangeMax) {
        arraySize = arraySize;
        rangeMax = rangeMax;
    }

    /**
     * Main method for the Sorter class. Contains the program which randomly creates an array of given size and range, sorts it
     * with Counting Sort and Quick Sort, times then, and checks for correct sort.
     */
    public static void main(String[] args) {
       Scanner scan1 = new Scanner(System.in);
       System.out.println("Enter Size of Array");
       int arraySize = scan1.nextInt();
       System.out.println("Enter Range of Array");
       int rangeMax = scan1.nextInt();

       int[] theArray = new int[arraySize]; //Creates initial array to be sorted, of specified input size
       //Generates random numbers in range, and populates array with them
       for (int i=0; i < arraySize; i++) {
           Random rand = new Random();
           int  n = rand.nextInt(rangeMax); //Generates value for array within inputted range
           theArray[i] = n;
       }


       //Set of commands for running, checking, and timing the Counting Sort procedure
       int[] quickSortArray = theArray;
       long quickStartTime = System.currentTimeMillis(); //Marks start time of QS
       QuickSort(quickSortArray, 0, arraySize - 1);
       long quickEndTime = System.currentTimeMillis(); //Marks end time of QS
       long quickRunTime = quickEndTime - quickStartTime;
       System.out.println("Quick Sort took " + quickRunTime + " ms");

       //Checks quick sort correctly sorted the array
       for (int i=0; i<arraySize-1;i++) {
           if (quickSortArray[i] > quickSortArray[i+1]) {
               System.out.print("Quick Sort Failed.");
               break;
           }
       }
    }

    /**
     * A method which executes the quick sort algorithm on an inputted array. Sorts recursively, and runst in nlogn time.
     *
     * @param array Refers to an integer array to be sorted by the algorithm.
     * @param p Refers to the lower of the inputed indices for sorting.
     * @param r Refers to the higher of the inputed indices for sorting.
     *
     * @return Void, sorts the original array and gives no output.
     */
    public static void QuickSort(int[] array, int p, int r) {
        if (p < r) {
            int q = Partition(array, p, r);
            QuickSort(array, p, q-1);
            QuickSort(array, q+1, r);
        }
    }

    /**
     * Helper method for QuickSort(). Partitions the array, so the recursive QuickSort method can find the correct index for quick sorting.
     * It is used to divide the array into two approximate halves.
     *
     * @param array
     * @param p Refers to the lower of the inputed indices for sorting.
     * @param r Refers to the higher of the inputed indices for sorting.
     *
     * @return Returns an integer index value to be used with the QuickSort method.
     */
    public static int Partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (array[j] <= pivot) {
                i++; //Increments lesser element
                //swaps array[i] and array[j]
                int placeHolder = array[i];
                array[i] = array[j];
                array[j] = placeHolder;
            }
        }

        //swaps array[i+1] and array[r]
        int placeHolder = array[i+1];
        array[i+1] = array[r];
        array[r] = placeHolder;
        return i + 1;
    }
}

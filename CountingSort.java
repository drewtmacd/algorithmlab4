import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;


/**
 * This Class contains a Counting Sorting method, and a Main method which runs the sorting method, while
 tracking the runtime, and checking if the arrays are correctly sorted.
 *
 * @author Drew Macdonald
 */
public class CountingSort
{
    int arraySize;
    int rangeMax;

    /**
     * Constructor for Sorter class. Contains 2 instance variables. The two parameters are both ints, arraySize and rangeMax.
     */
    public CountingSort(int arrraySize, int rangeMax) {
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
       int[] countSortArray = theArray;
       long countStartTime = System.currentTimeMillis(); //Marks start time of CS
       CountingSort(countSortArray,rangeMax);
       long countEndTime = System.currentTimeMillis(); //Marks end time of CS
       long countRunTime = countEndTime - countStartTime;
       System.out.println("Count Sort took " + countRunTime + " ms");

       //Checks count sort correctly sorted the array
       for (int i=0; i<arraySize-1;i++) {
           if (countSortArray[i] > countSortArray[i+1]) {
               System.out.print("Count Sort Failed.");
               break;
           }
       }
    }

    /**
     * A method which executes the counting sort algorithm on an inputted array. Run in (n + k) time where n is the size of the
     * inputted array, and k is the range.
     *
     * @param array Refers to an integer array to be sorted by the algorithm.
     * @param range Refers to the range of the array values, given as range in the constructor.
     *
     * @return Void, sorts the original array and gives no output.
     */
    public static void CountingSort(int[] array,int range)
    {
        int arraySize = array.length;
        int [] countArray = new int[range];

        //Initiallay populates count array with counts of 0
        for (int i = 0; i < range; i++) {
            countArray[i] = 0;
        }

        //Stores count of each element in the original array within count Array
        for (int i = 0; i < arraySize; i++) {
            countArray[array[i]]++;
        }

        //modifies countArray to have positions for creating new array
        for (int i = 1; i < range; i++) {
            countArray[i] += countArray[i-1];
        }

        //uses countArray information to create sorted array, called temp
        int[] temp = new int[arraySize];
        for (int i=0; i<arraySize; i++) {
            temp[countArray[array[i]]-1] = array[i];
            countArray[array[i]]--;
        }

        //Replaces original array with temp, the sorted version
        for (int i=0;i<arraySize;i++) {
            array[i]=temp[i];
        }
    }
}

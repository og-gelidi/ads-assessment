import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TimeSortingAlgorithms {
    public static final long THRESHOLD = 300_000_000_000L;
    public static long startTime;

    public static void timeToSort(String path) {
        int[] originalArr = readArray(path);
        int[] arr;
        int startIndex = 0;
        int endIndex = originalArr.length - 1;
        long time1;
        long time2;
        double timeTaken;
        double timeTotal;
        double average;

        
        System.out.printf("Time taken to sort %s:\n\n\n",path);
        timeTotal = 0.0;
        arr = originalArr.clone();
        for (int i = 0; i < 10; i++) {
            time1 = System.nanoTime();
        
            InsertionSort.sort(arr);
            time2 = System.nanoTime();
            timeTaken = (time2 - time1) / 1_000_000.0;
            timeTotal += timeTaken;
        }
        average = timeTotal / 10.0; 
        System.out.println("InsertionSort: " + average + " milliseconds");
        
        timeTotal = 0.0;
        arr = originalArr.clone();
        for (int i = 0; i < 10; i++) {
            time1 = System.nanoTime();
            SelectionSort.sort(arr);
            time2 = System.nanoTime();
            timeTaken = (time2 - time1) / 1_000_000.0;
            timeTotal += timeTaken;
        }
        average = timeTotal / 10.0; 
        System.out.println("SelectionSort: " + average + " milliseconds");

        timeTotal = 0.0;
        arr = originalArr.clone();
        for (int i = 0; i < 10; i++) {
            time1 = System.nanoTime();
            ShellSort.sort(arr);
            time2 = System.nanoTime();
            timeTaken = (time2 - time1) / 1_000_000.0;
            timeTotal += timeTaken;
        }
        average = timeTotal / 10.0; 
        System.out.println("ShellSort: " + average + " milliseconds");

        timeTotal = 0.0;
        arr = originalArr.clone();
        for (int i = 0; i < 10; i++) {
            time1 = System.nanoTime();
            MergeSort.sort(arr, startIndex, endIndex);
            time2 = System.nanoTime();
            timeTaken = (time2 - time1) / 1_000_000.0;
            timeTotal += timeTaken;
        }
        average = timeTotal / 10.0; 
        System.out.println("MergeSort: " + average + " milliseconds");

        
        timeTotal = 0.0;
        arr = originalArr.clone();
        for (int i = 0; i < 10; i++) {
            time1 = System.nanoTime();
            MergeSort.sortCutOff(arr, startIndex, endIndex, 10 );
            time2 = System.nanoTime();
            timeTaken = (time2 - time1) / 1_000_000.0;
            timeTotal += timeTaken;
        }
        average = timeTotal / 10.0; 
        System.out.println("MergeSort (hybrid, cut off size = 10): " + average + " milliseconds");


        timeTotal = 0.0;
        arr = originalArr.clone();
        for (int i = 0; i < 10; i++) {
            time1 = System.nanoTime();
            MergeSort.sortBottomUp(arr, startIndex, endIndex);
            time2 = System.nanoTime();
            timeTaken = (time2 - time1) / 1_000_000.0;
            timeTotal += timeTaken;
        }
        average = timeTotal / 10.0; 
        System.out.println("MergeSort (bottom up): " + average + " milliseconds");
        
        timeTotal = 0.0;
        arr = originalArr.clone();
        for (int i = 0; i < 10; i++) {
            time1 = System.nanoTime();
            QuickSort.sort(arr, startIndex, endIndex);
            time2 = System.nanoTime();
            timeTaken = (time2 - time1) / 1_000_000.0;
            timeTotal += timeTaken;
        }
        average = timeTotal / 10.0; 
        System.out.println("QuickSort: " + average + " milliseconds");

        timeTotal = 0.0;
        arr = originalArr.clone();
        for (int i = 0; i < 10; i++) {
            time1 = System.nanoTime();
            QuickSort.sortMedian3(arr, startIndex, endIndex);
            time2 = System.nanoTime();
            timeTaken = (time2 - time1) / 1_000_000.0;
            timeTotal += timeTaken;
        }
        average = timeTotal / 10.0;
        System.out.println("QuickSort (median of 3): " + average + " milliseconds");

        timeTotal = 0.0;
        arr = originalArr.clone();
        for (int i = 0; i < 10; i++) {
            time1 = System.nanoTime();
            QuickSort.sort3Way(arr, startIndex, endIndex);
            time2 = System.nanoTime();
            timeTaken = (time2 - time1) / 1_000_000.0;
            timeTotal += timeTaken;
        }
        average = timeTotal / 10.0; 
        System.out.println("QuickSort (dutch flag): " + average + " milliseconds");

        timeTotal = 0.0;
        arr = originalArr.clone();
        for (int i = 0; i < 10; i++) {
            time1 = System.nanoTime();
            QuickSort.sortCutOff(arr, startIndex, endIndex, 10);
            time2 = System.nanoTime();
            timeTaken = (time2 - time1) / 1_000_000.0;
            timeTotal += timeTaken;
        }
        average = timeTotal / 10.0; 
        System.out.println("QuickSort (hybrid, cut off size = 10): " + average + " milliseconds");
        
    }



    public static int[] copyArray(ArrayList<Integer> data) {
        int n = data.size();
        int[] res = new int[n];
        for (int i = 0; i<n; i++){
            res [i] = data.get(i);
        }
        return res;
    }

    public static int[] readArray(String path){
        ArrayList<Integer> data;
        data = new ArrayList<>();
        try {
            try (Scanner sc = new Scanner(new File(path))) {
                while (sc.hasNextInt()) {
                    data.add(sc.nextInt());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.printf(e + "\nFile not found.\n");
        }
        return copyArray(data);
    }



    public static void main(String[] args) {
        timeToSort("int20k.txt");
    }
}   


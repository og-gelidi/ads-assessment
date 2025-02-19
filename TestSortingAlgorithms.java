import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestSortingAlgorithms{ 
 
    public static boolean isSorted(int a[]){ 
      int n = a.length; 
      for (int i = 0; i < n-1; i++){ 
        if (a[i] > a[i+1]){ 
          return false; 
        } 
      } 
      return true; 
    } 

    public static int[] copyArray(ArrayList<Integer> data) {
        int n = data.size();
        int[] res = new int[n];
        for (int i = 0; i<n; i++){
            res [i] = data.get(i);
        }
        return res;
    }

    public static int[] readArray(String path) throws FileNotFoundException{

        ArrayList<Integer> data;
        try (Scanner sc = new Scanner(new File(path))) {
            data = new ArrayList<>();
            while (sc.hasNextInt()) {
                data.add(sc.nextInt());
            }
        }
        return copyArray(data);
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[] test1 = readArray("int10.txt");
        int[] test2 = readArray("int50.txt");
        int[] test3 = readArray("int100.txt");
        int[] test4 = readArray("int1000.txt");

        InsertionSort.sort(test1);
        InsertionSort.sort(test2);
        InsertionSort.sort(test3);
        InsertionSort.sort(test4);

        System.out.println(TestSortingAlgorithms.isSorted(test1));
        System.out.println(TestSortingAlgorithms.isSorted(test2));
        System.out.println(TestSortingAlgorithms.isSorted(test3));
        System.out.println(TestSortingAlgorithms.isSorted(test4));
    }
  }
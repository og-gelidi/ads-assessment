public class SelectionSort{ 
 
    public static void sort(int a[]){ 
      int n = a.length; 
      for (int i = 0; i < n - 1; i++){ 
        int index = i; 
        for (int j = i + 1; j < n; j++){ 
          if (a[j] < a[index]){ 
            index = j; 
          }
        }
        int min = a[index]; 
        a[index] = a[i];
        a[i] = min; 
        }
    }
}
public class InsertionSort{ 
 
    public static void sort(int a[]){ 
      int n = a.length; 
      for (int j = 1; j < n; j++){ 
        int key = a[j]; 
        int i = j-1; 
        while ((i >= 0) && (a[i] > key)){ 
          a[i+1] = a[i]; 
          i--; 
        } 
        a[i+1] = key; 
      } 
    } 

    public static void sort(int a[], int p, int r){ 
      for (int i = p + 1; i < r; i++){ 
        for (int j = i; j > p && a[j] < a[j-1]; j--){ 
          swap(a, j, j-1); 
        } 
      } 
    }

    public static void swap(int a[], int b, int c) {
      int saved = a[c];
      a[c] = a[b];
      a[b] = saved;
  }
  }
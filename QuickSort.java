public class QuickSort{

    public static void sort(int[] unsorted, int p, int r) {
        if (p < r) {
            int q = partition(unsorted, p, r-1);
            sort(unsorted, p, q-1);
            sort(unsorted,q+1,r);
        }
    }
        
    public static int partition(int[] array, int p, int r) {
        int x = array[r]; 
        int i = p - 1;
    
        for (int j = p; j < r; j++) {
            if (array[j] <= x) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, r);
        return i + 1;
    }
    

    public static void swap(int a[], int b, int c) {
        int saved = a[c];
        a[c] = a[b];
        a[b] = saved;
    }


    public static void sortMedian3(int a[], int p, int r){ 
        if (r <= p) return; 
        swap(a, (p+r)/2, r-1); 
        if (a[r-1] < a[p]) swap (a, p, r-1); 
        if (a[r] < a[p]) swap (a, p, r); 
        if (a[r] < a[r-1]) swap (a, r-1, r); 
        int q = partition(a, p+1, r-1); 
        sortMedian3(a, p, q-1); 
        sortMedian3(a, q+1, r); 
      }

      public static void sort3Way(int[] arr, int low, int high) {
    if (low >= high) return; // Base case to stop recursion

    int lt = low, i = low + 1, gt = high;
    int pivot = arr[low];

    while (i <= gt) {
        if (arr[i] < pivot) {
            swap(arr, lt++, i++);
        } else if (arr[i] > pivot) {
            swap(arr, i, gt--);
        } else {
            i++;
        }
    }

    // Recursively sort the partitions
    sort3Way(arr, low, lt - 1);
    sort3Way(arr, gt + 1, high);
}

    private static void kSort(int a[], int p, int r, int k) { 
        if (p >= r) return; 
        if (r - p + 1 <= k) return;
        
        int q = partition(a, p, r);
        System.out.println("p: " + p + ", q: " + q + ", r: " + r);

        if (q > p) kSort(a, p, q - 1, k); 
        if (q < r) kSort(a, q + 1, r, k);  
    }
    
       public static void sortCutOff(int a[], int p, int r, int k){ 
        kSort(a, p, r, k); 
        InsertionSort.sort(a, p, r); 
      }
}



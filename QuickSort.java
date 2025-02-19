public class QuickSort{

    public static void sort(int[] unsorted, int p, int r) {
        if (p < r) {
            int q = partition(unsorted, p, r-1);
            sort(unsorted, p, q-1);
            sort(unsorted,q+1,r);
        }
    }
        
    public static int partition(int[] array, int p, int r){
        int x = array[r];
        int i = p - 1;
        for (int j = p ; j<r ; j++) {
            if (array[j]<= x){
                i = i + 1;
                int intermediate = array[i];
                array[i] = array[j];
                array[j] = intermediate;
            }
            int intermediate = array[i];
            array[i] = array[j];
            array[j] = intermediate;
        }
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

      public static void sort3Way(int arr[], int left, int right) { 
        if (right <= left) return; 
        
        int pivot = arr[right]; 
        int low = left - 1, high = right, equalLow = left - 1, equalHigh = right, index; 
    
        for (;;) { 
            while (arr[++low] < pivot); 
            while (pivot < arr[--high]) if (high == left) break; 
    
            if (low >= high) break; 
            swap(arr, low, high); 
    
            if (arr[low] == pivot) { equalLow++; swap(arr, equalLow, low); } 
            if (arr[high] == pivot) { equalHigh--; swap(arr, equalHigh, high); } 
        } 
        
        swap(arr, low, right); 
        high = low - 1; 
        low = low + 1; 
    
        for (index = left; index <= equalLow; index++, high--) swap(arr, index, high); 
        for (index = right - 1; index >= equalHigh; index--, low++) swap(arr, index, low); 
    
        sort3Way(arr, left, high); 
        sort3Way(arr, low, right); 
    }
    


      private static void kSort(int a[], int p, int r, int k){ 
        if (r - p <= k) return; 
        int q = partition(a, p, r); 
        kSort(a, p, q-1, k); 
        kSort(a, q+1, r, k); 
      } 
       public static void sortCutOff(int a[], int p, int r, int k){ 
        kSort(a, p, r, k); 
        InsertionSort.sort(a, p, r); 
      }
}



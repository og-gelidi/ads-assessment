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

      //Dutch flag
    //@param l is the starting parameter
    //q is meant to be the right boundary of a partition
    public static void sort3Way(int a[], int l, int r) {
        if (r <= l) return;
    
        int pivot = a[r]; // Consider using median-of-three for better performance
        int i = l, lt = l, gt = r;
    
        while (i <= gt) {
            if (a[i] < pivot) swap(a, lt++, i++);
            else if (a[i] > pivot) swap(a, i, gt--);
            else i++;
        }
    
        sort3Way(a, l, lt - 1);  // Sort elements less than pivot
        sort3Way(a, gt + 1, r);  // Sort elements greater than pivot
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



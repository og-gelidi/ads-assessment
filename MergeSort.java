public class MergeSort{ 
 
    static void merge(int[] array, int left, int middle, int right) {  
        int leftSize = middle - left + 1;  
        int rightSize = right - middle;  
    
        int[] leftArray = new int[leftSize];  
        int[] rightArray = new int[rightSize];  
    
      
        for (int i = 0; i < leftSize; i++)  
            leftArray[i] = array[left + i];  
        for (int j = 0; j < rightSize; j++)  
            rightArray[j] = array[middle + 1 + j];
    
        int leftIndex = 0, rightIndex = 0, mergedIndex = left;
    
        
        while (leftIndex < leftSize && rightIndex < rightSize) { 
            if (leftArray[leftIndex] <= rightArray[rightIndex]) { 
                array[mergedIndex] = leftArray[leftIndex]; 
                leftIndex++; 
            } else { 
                array[mergedIndex] = rightArray[rightIndex]; 
                rightIndex++; 
            }  
            mergedIndex++;  
        }  
    
       
        while (leftIndex < leftSize) { 
            array[mergedIndex] = leftArray[leftIndex];  
            leftIndex++; 
            mergedIndex++; 
        }  
    
        
        while (rightIndex < rightSize) { 
            array[mergedIndex] = rightArray[rightIndex]; 
            rightIndex++; 
            mergedIndex++; 
        }  
    }
    
     
    public static void sort(int[] array, int left, int right) { 
        if (left < right) { 
            int middle = left + (right - left) / 2; 
    
            
            sort(array, left, middle); 
            sort(array, middle + 1, right); 
    
            
            merge(array, left, middle, right);  
        } 
    }
    


    public static void sortCutOff(int[] array, int left, int right, int cutoff) {
        if (right - left + 1 <= cutoff) {  
            InsertionSort.sort(array, left, right);
            return;
        } 
    
        int middle = left + (right - left) / 2;
    
        sortCutOff(array, left, middle, cutoff);
        sortCutOff(array, middle + 1, right, cutoff);
    
        merge(array, left, middle, right);
    }

    public static void sortBottomUp(int a[], int p, int r){ 
        int n = r - p; 
        for (int sz = 1; sz < n; sz = sz+sz) 
          for (p = 0; p < n-sz; p += sz+sz) 
            merge(a, p, p+sz-1, Math.min(p+sz+sz-1, n-1)); 
      }
    
}
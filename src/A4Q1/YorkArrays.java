package A4Q1;
import java.util.*;

/**
 *
 * Provides two static methods for sorting Integer arrays (heapSort and mergeSort)
 * @author jameselder
 */
public class YorkArrays {

    /* Sorts the input array of Integers a using HeapSort.  Result is returned in a.
     * Makes use of java.util.PriorityQueue.  
       Sorting is NOT in place - PriorityQueue allocates a separate heap-based priority queue. 
       Not a stable sort, in general.  
       Throws a null pointer exception if the input array is null.  */
    public static void heapSort(Integer[] a) throws NullPointerException {
       //implement this method.
    	PriorityQueue heap = new PriorityQueue(Arrays.asList(a));
    	for(Integer e : a)
    	{
    		heap.add(e);
    	}
    	
    }
    
    /* Sorts the input array of Integers a using mergeSort and returns result.
     * Sorting is stable.
       Throws a null pointer exception if the input array is null. */
    public static Integer[] mergeSort(Integer[] a)  throws NullPointerException {
        return(mergeSort(a, 0, a.length-1));
    }
    
    /* Sorts the input subarray of Integers a[p...q] using MergeSort and returns result.
     * Sorting is stable.
     */
    private static Integer[] mergeSort(Integer[] a, int p, int q) {
        //implement this method.
    	 if (a.length <= 1) 
		  {
		  	return a;
		  }
	    Integer[] leftOfCurrent = new Integer[(((q+p)/2) - p) + 1];
	    Integer[] rightOfCurrent = new Integer[q - ((q+p)/2)];
	    int x = 0;

	    for (int i = 0; i < leftOfCurrent.length; i++)
	    {
	        leftOfCurrent[i] = a[x++];
	    }
	    for (int i = 0; i < rightOfCurrent.length; i++)
	    {
	        rightOfCurrent[i] = a[x++];
	    }

	    leftOfCurrent = mergeSort(leftOfCurrent, 0, leftOfCurrent.length-1);
	    rightOfCurrent = mergeSort(rightOfCurrent, 0, rightOfCurrent.length-1);
	    return merge(leftOfCurrent, rightOfCurrent);
    }
    
    /* Merges two sorted arrays of Integers into a single sorted array.  Given two
     * equal elements, one in a and one in b, the element in a precedes the element in b.
     */
    private static Integer[] merge(Integer[] a, Integer[] b) {
        //implement this method.
    	 Integer[] lenofAB = new Integer[a.length + b.length];
         int x = 0;
         int y = 0;
         int z = 0;
         int alen = a.length;
         int blen = b.length;
         
         do {
        	 if (a[x] > b[y]) {
        		 lenofAB[z++] = b[y++];
           } else {
               lenofAB[z++] = a[x++];
           }
         } while (x < alen && y < blen);

         while ( x < alen) {
             lenofAB[z++] = a[x++];
         }
         while (y < blen) {
             lenofAB[z++] = b[y++];
         }
         return (lenofAB);
     }
    }

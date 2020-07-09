public class CheckPermutation {

    public static void main (String[] args)
    {
        char[] s1 = {'b', 'e', 'e', 'r'};
        char[] s2 = {'r', 'e', 'e', 'b'};

        System.out.println("s1.length="+s1.length);
        System.out.println("s2.length="+s2.length);

        if (s1.length!=s2.length)
            System.out.println("False - arrays not equal");

        MergeSort ob = new MergeSort(); 
        ob.sort(s1, 0, s1.length - 1); // O(n log n)
        ob.sort(s2, 0, s2.length - 1); // O(n log n)

        for (int i = 0;i<s1.length;i++)
        {
            System.out.println("s1 sorted="+s1[i]);
            System.out.println("s2 sorted="+s2[i]);

            if (s1[i]!=s2[i]){
                System.out.println("False");
            }
        }
    }
}

/* Java program for Merge Sort */
class MergeSort { 
	// Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
	void merge(char arr[], int l, int m, int r) 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* Create temp arrays */
		char L[] = new char[n1]; 
		char R[] = new char[n2]; 

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i) 
			L[i] = arr[l + i]; 
		for (int j = 0; j < n2; ++j) 
			R[j] = arr[m + 1 + j]; 

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l; 
		while (i < n1 && j < n2) { 
			if (L[i] <= R[j]) { 
				arr[k] = L[i]; 
				i++; 
			} 
			else { 
				arr[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) { 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) { 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(char arr[], int l, int r) 
	{ 
		if (l < r) { 
			// Find the middle point 
			int m = (l + r) / 2; 

			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr, m + 1, r); 

			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	} 

	
} 


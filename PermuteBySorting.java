
public class PermuteBySorting {
	
	public static void randomizedHireAssistant(int[] A) {
		permuteBySorting(A);
		
		System.out.print("Randomly Permuted List: ");
		for (int i : A)
			System.out.print(i + " ");
		
		int best = A[0];
		System.out.println("\n\n" + A[0] + " is hired initially.");
		int numHired = 1; 
		
		for (int i = 1 ; i < A.length ; i++) {
			if (A[i] > best) {
				System.out.println(A[i] + " is hired as new assistant, " + best + " has been fired!");
				best = A[i];
				numHired++;
			}
			else {	
				System.out.println(A[i] + " is not hired, " + best + " remains as the current assistant!");
			}	
		}
		
		System.out.println("\n" + numHired + " assistants were hired.");
	}
	
	private static void permuteBySorting(int[] A) {
		int n = A.length;
		int[] priorityKey = new int[n];
		int range = (int) Math.pow(n, 3);
		
		for (int i = 0 ; i < n ; i++) {
			priorityKey[i] = (int) (Math.random() * range);
		}

		mergeSort(A, priorityKey);	
	}
	
	private static void mergeSort(int[] list, int[] key) {
		mergeSort(list, key, 0, list.length-1);
	}

	private static void mergeSort (int[] list, int[] key, int p, int r) {
		if (r - p < 1) return;
		int q = (p + r) / 2;
		mergeSort(list, key, p, q);
		mergeSort(list, key, q + 1, r);
		merge(list, key, p, q, r);
	}

	private static void  merge(int[] list, int[] key, int p, int q, int r) {

		int[] tmp = new int[r-p+1];
		int[] tmpK = new int[r-p+1]; 
		int i = p;
		int j = q + 1;
		int k = 0;
		
		while (i <= q && j <= r) {
			if (key[i] <= key[j]) {
				tmpK[k] = key[i];
				tmp[k] = list[i];
				i++;
			}	
			else {
				tmpK[k] = key[j];
				tmp[k] = list[j];
				j++;
			}	
			k++;
		}
		if (i <= q && j > r) {
			while (i <= q) {
				tmpK[k] = key[i];
				tmp[k] = list[i];
				k++;
				i++;
			}
				
		} else {
			while (j <= r) {
				tmpK[k] = key[j];
				tmp[k] = list[j];
				k++;
				j++;
			}	
		}
		for (k = 0 ; k < tmp.length ; k++) {
			key[k+p] = tmpK[k];
			list[k+p] = tmp[k]; 
		}
	}
		
	public static void main(String[] args) {
		int[] list = {1, 2, 3, 4, 5, 6, 7, 8 , 9, 10};	
		
		randomizedHireAssistant(list);	
	}	
}

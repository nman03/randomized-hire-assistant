public class RandomizeInPlace {

	public static void randomizedHireAssistant(int[] A) {
		System.out.println("Randomize In Place\n");
		int n = A.length;
		int numHired = 1; 
		int best = 0;

		for (int i = 0 ; i < A.length ; i++) {
			int tmp = A[i];
			int randomIndex = (int) (Math.random() * (n - i) + i);
			A[i] = A[randomIndex];
			A[randomIndex] = tmp;
				
			if (i == 0) {
				best = A[i];
				System.out.println(A[i] + " is hired initially.");
			}	
			
			else if (A[i] > best) {
				System.out.println(A[i] + " is hired as new assistant, " + best + " has been fired!");
				best = A[i];
				numHired++;
			}
			else {	
				System.out.println(A[i] + " is not hired, " + best + " remains as the current assistant!");
			}	
		}
		
		System.out.print("\nRandomly Permuted List: ");
		for (int a : A) {
			System.out.print(a + " ");
		}

		System.out.println("\n\n" + numHired + " assistants were hired.");
	}
	
	public static void main(String[] args) {
		int[] list = {1, 2, 3, 4, 5, 6, 7, 8 , 9, 10};	
		
		randomizedHireAssistant(list);	
	}

}

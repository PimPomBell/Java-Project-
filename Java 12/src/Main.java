public class Main {
	
	public static void sort(int [] num) {
		for(int i = 0; i<num.length; i++) {
			for(int j = 0; j<num.length-i-1; j++) {
				if (num[j]<num[j+1]) {
				int temp = num[j];
				num[j] = num[j+1];
				num[j+1] = temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int [] num = {4,2,3,1};
		
		for (int i = 0; i<num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		sort(num);
		for(int j = 0; j<num.length; j++) {
			System.out.print(num[j] + " ");
		}
		
		
		
		
	}
}

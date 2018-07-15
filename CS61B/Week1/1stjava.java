public class testjava{
	public static void fib(int n) {
		int a0 = 0;
		int a1 = 1;
		int a2 = 0;
		int i  = 0;
		while (i<n){
			if (i==0){
				System.out.println(a0);
			}
			else if (i==1){
				System.out.println(a1);
			}
			else{
				a2 = a0 + a1;
				System.out.println(a2);
				a0 = a1;
				a1 = a2;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		fib(n=5);
	}
}
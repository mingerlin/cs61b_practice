public class HelloNumbers{
	public static void main(String[] args) {
		// original

		// int x=0;
		// while(x<10) {
		// 	System.out.print(x+ " ");
		// 	x+=1;

		// modified
		int x=0;
		int cumsum=0;
		while(x<10) {
			cumsum+=x;
			System.out.print(cumsum+ " ");
			x+=1;
		}
	}
}
import java.util.Scanner;

public class MP2_20
{
	static Scanner sc = new Scanner(System.in);

	public static int factorial(int n)
	{
		if (n==0)
			return 1;
		else
			return n * factorial(n-1);
	}
	public static int fibo(int n)
	{
		if (n==0 || n==1)
			return n;
		else
			return fibo(n-1)+fibo(n-2);
	}
	public static int power(int base, in	t n)
	{
		if (n==0)
			return 1;
		else
			return power(base,n-1)*base;
	}
	public static int power2(int base, int n)
	{
		if (n==0)
			return 1;
		else if (n%2==0)
			return power2(base,n/2)*power2(base,n/2);
		else
			return power2(base,n/2)*power2(base,n/2)*base;
	}
	public static int SumArray(int[] a, int n)
	{
		if (n==1)
			return a[1];
		else
			return SumArray(a,n-1)+a[n];
	}
	public static int SumArray2(int[]a, int p, int n)
	{
		if (p==n)
			return a[n];
		else
			return SumArray2(a, p+1,n) + a[p];
	}
	public static int SumArray3(int[] a, int p, int r)
	{
		int q;
		if (p==r)
			return a[p];
		else
			q = (p+r)/2;
			return SumArray3(a, p, q) + SumArray3(a, q+1, r);
	}
	public static void main(String args[]) throws NullPointerException
	{
		int num;
		int[] arr = {0,1,2,3,4,5,6,7,8,9,10};
		System.out.println("Enter a number");
		num = sc.nextInt();
		System.out.println("The factorial is " + factorial(num));
		System.out.println("The nth term of the fibo sequence is " + fibo(num));
		System.out.println("The power is " + power(2,num));
		System.out.println("The power is " + power2(2,num));
		System.out.println("The Sumarray1 is " + SumArray(arr,10));
		System.out.println("The Sumarray2 is "+ SumArray2(arr,3,7));
		System.out.println("The Sumarray3 is "+ SumArray3(arr,3,7));
	}
}

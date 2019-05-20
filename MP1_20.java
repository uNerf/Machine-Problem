import java.util.Scanner;

public class MP_20{

    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        System.out.println("Input a number: ");
        long num = s.nextLong();


/*
        long recStart = System.currentTimeMillis();
        System.out.println("nth term in Recursion fibo is: "+ Fiborec(num));
        long recEnd =System.currentTimeMillis();
        System.out.println("Recursive time is: "+((recEnd-recStart)/1000)+" s");

        System.out.println('\n'+"---------------------------"+'\n');
*/
        double iteStart = System.currentTimeMillis();
        System.out.println("nth term in Iterative fibo is: "+ iteFibo(num));
        double iteEnd = System.currentTimeMillis();
        System.out.println("Iterative time is: "+ ((iteEnd-iteStart)/1000)+" s");

    }

/*
    public static double Fiborec(double n){
        if (n==1||n==0){
            return n;
        }
        else return Fiborec(n-1)+ Fiborec(n-2);
    }*/

    public static long iteFibo(long n){
        long x = 0;
        long y = 1;
        if (n==0){
            return 0;
        }
        else
            for(long i =2; i<=n;i++){
                long z=x+y;
                x=y;
                y=z;
            }
        return y;
    }
}

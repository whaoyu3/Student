import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by whaoy on 2017/3/21.
 */

public class Factor {

    private static Random rand;


    public static void main(String[] args) {
        final long startTime = System.nanoTime();

        // command-line argument
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter a number to test for primality.");
        long n = new Long(stdin.next());

        System.out.println("The prime factorization of " + n + " is: ");

        System.out.print(n + "=" +1 +" * ");

        if (n%2==0) {
            long fac = 2;

            while (n % fac == 0) {
                System.out.print(fac + " * ");
                n = n / fac;
            }
        }



        // for each potential factor
        for (long factor = 3; factor*factor <= n; factor+=2) {

            // if factor is a factor of n, repeatedly divide it out
            while (n % factor == 0) {
                System.out.print(factor + " * ");
                n = n / factor;
            }
        }

        // if biggest factor occurs only once, n > 1
        if (n > 1) System.out.println(n);
        else       System.out.println();

        final long duration = System.nanoTime() - startTime;

        System.out.println("The running time is: "+duration/1e9);


    }
}

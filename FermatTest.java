import java.math.BigInteger;
import java.util.*;

public class FermatTest
{

    private static Random rand;


    public static void main(String[] args)
    {
        rand = new Random();

        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter a number to test for primality.");
        BigInteger n = new BigInteger(stdin.next());

        if (isProbPrime(n, 50))
            System.out.println("Number is probably prime");
        else
            System.out.println("Number is composite");

    }


    public static boolean isProbPrime(BigInteger p, int testCount)

    { for (int i=0; i < testCount; i++) {
        BigInteger a = new BigInteger("" + rand.nextInt());  // random big-int
        // calculate a^(p-1) mod p
        // return true iff it passes the Fermat Test
        BigInteger ans = a.modPow(p.subtract(BigInteger.ONE), p);
        if (!ans.equals(BigInteger.ONE))
            return false;  // not prime  / it is definitely composite
    }
        // the calculation == 1 testCount times, and so is probably correct!
        return true;
    }  // end of isProbPrime()

}  // end of FermatPrimeTest class
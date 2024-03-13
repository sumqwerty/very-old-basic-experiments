import java.util.*;

public class PrimeList
{
    public static boolean isPrime(int num)
    {
        
        for(int i=2; i<=(num/2); ++i)
        {
            if(num%i == 0)
            {
                return false;
            }
        }
        
        return true;
    }
    public static void main(String[] args)
    {
        LinkedList<Integer> ls = new LinkedList<Integer>();
        
        int numOfPrime = 0;
        int num = 2;
        while(numOfPrime < 50)
        {
            if(isPrime(num))
            {
                ls.add(num);
                numOfPrime += 1;
            }
            num += 1;
        }
        
        int j = 0;
        for(Integer n : ls)
        {   
            ++j;
            System.out.print(n+" ");
            if(j%10 == 0)System.out.println(); 
        }
    }
}

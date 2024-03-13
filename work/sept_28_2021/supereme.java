import java.io.*;
import java.util.*;
 
public class solution1
{
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static void main (String[] args)
    {
        int[] a1 = new int[10000];
        
        for(int i=0; i<10000; ++i)
        {
            a1[i] = getRandomNumber(-500, 500);
        }

        for(int i=0; i<3; ++i)
        {

            long start = System.nanoTime();
            int res[] = testSolution1(a1);
            long end = System.nanoTime();
            System.out.println("test 1: " + (end-start) +" ns");
        }

        for(int i=0; i<3; ++i)
        {

            long start = System.nanoTime();
            int res[] = testSolution2(a1);
            long end = System.nanoTime();
            System.out.println("test 2: " + (end-start) +" ns");
        }

        for(int i=0; i<3; ++i)
        {

            long start = System.nanoTime();
            int res[] = testSolution3(a1);
            long end = System.nanoTime();
            System.out.println("test 3: " + (end-start) +" ns");
        }
    }
 
    public static int[] testSolution1(int A[])
    {
        int size = A.length;
        int maxF = Integer.MIN_VALUE;
        int maxE = 0;
        int[] res = {-1,-1};
        for (int i = 0; i < size; i++)
        {
            maxE = maxE + A[i];
            
            if (maxF < maxE)
            {
                res[1] = i;
                maxF = maxE;
            }
            
            if (maxE < 0)
            {
                res[0] = i+1;
                maxE = 0;
            }
        }
        
        
        if(res[0] >= size || res[0] < 0)
        {res[0]=-1;res[1]=-1;}
        
        return res;
    }

    public static int[] testSolution2(int A[])
    {
        int n = A.length;
        int max = A[0];
        int sum;
        
        int[] res = {-1,-1};
        
        for (int i = 0; i < n; i++)

        {

            sum = 0;

            for (int j = i; j < n; j++)

            {

                sum += A[j];

                if (sum >= max)

                {

                    res[0]=i;
                    res[1]=j;
                    max = sum;

                }

            }

        }
        if(res[0]==0 && res[1]==0)
        {
            res[0]=-1;
            res[1]=-1;
        }
        return res;
    }

    public static int[] testSolution3(int A[])
    {
        int n = A.length;
        int max = A[0];
        int st=-1;
        int en=-1;
        
        int S = A[0];
        int T = 0;
        int[] res = {-1,-1};
        
        for (int i = 0; i < n; i++)
        {
            if(S>0)
            {
                S=S+A[i];
            }
            else{
                S=A[i];
                T=i;
            }
            if(S > max)
            {
                st = T;
                en = i;
                max = S;
            }
        }

        res[0]=st;
        res[1]=en;
        return res;
    }
}

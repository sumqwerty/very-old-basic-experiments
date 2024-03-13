import java.io.*;
import java.util.*;
 
public class solution3
{
    public static void main (String[] args)
    {
        int [] a2 = { 1, 3, -5, 7, 4, -2};
       
        //long start = System.nanoTime();
        int res[] = testSolution(a2);
        //long end = System.nanoTime();
        //System.out.println(end-start+" ns");
		System.out.println(res[0]+" : "+res[1]);
    }
 
    public static int[] testSolution(int A[])
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

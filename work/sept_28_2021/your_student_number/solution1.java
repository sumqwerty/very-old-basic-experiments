import java.io.*;
import java.util.*;
 
public class solution1
{
    public static void main (String[] args)
    {
        int a1[] = { 1, 3, -5, 7, 4, -2};
        int res[] = testSolution(a1);
		System.out.println(res[0]+" : "+res[1]);
    }
 
    public static int[] testSolution(int A[])
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
}

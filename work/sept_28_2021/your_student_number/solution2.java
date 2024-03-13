import java.io.*;
import java.util.*;
 
public class solution2
{
    public static void main (String[] args)
    {        
        int [] a1 = { 1, 3, -5, 7, 4, -2};
              
        //long start = System.nanoTime();
        int res[] = testSolution(a1);
        //long end = System.nanoTime();
        //System.out.println(end-start+" ns"); 
		System.out.println(res[0]+" : "+res[1]);
    }
 
    public static int[] testSolution(int A[])
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
}

import java.util.Scanner;
public class Task2{
    public static void main(String args[]){
        int numStar = 5;
        int numSpace = 0;
        int lines = 9;
        boolean flip = false;
        for(int i=0; i<lines; ++i)
        {
            String sp = "";
            
            for(int j=0; j<numSpace; ++j)sp+=" ";
            
            System.out.print(sp);
            
            for(int j=0; j<numStar; ++j)System.out.print("* ");
            
            if(flip == false)
            {
                ++numSpace;
                --numStar;
            }
            else
            {
                ++numStar;
                --numSpace;
            }
            if(numStar==0)
            {   
                flip = true;
                numStar=2;
                numSpace=3;
            }
            System.out.println();
        }
    }
}

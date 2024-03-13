
/******************************************************************************
 *  Under Linux:
 *  Compilation:  javac LangValidator.java
 *  Execution:    java LangValidator file.txt
 *  
 *  Reads in a text file and checks to see if the strings (one string per line)
 *  belongs to the following language:
 *  L={w$w' | w is possibly an empty string of characters except $, and w' = reverse(w)}
 *
 *  % java  java LangValidator
 *  $
 *  true
 *
 *  % java LangValidator
 *  aab$aba
 *  false
 *
 ******************************************************************************/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;


public class LangValidator {
	private static final char delimeter = '$';
	
	
	
    public static boolean isValidString(String s,int curr) {
    	//Hint: use a stack of characters:
        //Stack<Character> stack = new Stack<Character>();
        
        if(s.charAt(curr) == delimeter)
        {
            if(s.length() == 1)return true;
            else if(curr == 0)return false;
            else
            {
                if((curr*2)+1 == s.length())return true;
                return false;
            }
        }
        
        if(!isValidString(s, curr+1))return false;
        
        if(s.charAt(curr) == s.charAt(s.length()-1-curr))return true;
        
        return false;
    }

	
    public static void main(String[] args) throws FileNotFoundException {
       	Scanner fin = new Scanner(new FileReader("../input.txt"));
        while (fin.hasNext()) {
            String str = fin.nextLine();
            System.out.println(str);
            System.out.println(isValidString(str,0));
            System.out.println();
        }
    }

	
	
}

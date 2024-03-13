
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
	private static final char delimeter    = '$';
    public static boolean isValidString(String s) {
    	//Hint: use a stack of characters:
        Stack<Character> stack = new Stack<Character>();
    	
    	boolean startPopping = false;
    	boolean res = false;
    	
    	
    	if(s.charAt(0) != delimeter)
    	{
            for(int i=0; i<s.length(); ++i){
                
                if(s.charAt(i) == delimeter)
                {
                    startPopping=true;
                    res = true;
                    continue;
                }
                
                if(!startPopping)
                {
                    stack.push(s.charAt(i));
                }
                
                else{
                    char top = stack.pop();
                    
                    if( (stack.isEmpty() && i!=s.length()-1) || top != s.charAt(i))
                    {
                        res = false;
                        break;
                    }
                }
            }
    	}
    	
    	if(!stack.isEmpty())return false;
    	
        return res;
    }

	
    public static void main(String[] args) throws FileNotFoundException {
       	Scanner fin = new Scanner(new FileReader("./input.txt"));
        while (fin.hasNext()) {
            String str = fin.nextLine();
            System.out.println(str);
            System.out.println(isValidString(str));
            System.out.println();
        }
    }

	
	
}

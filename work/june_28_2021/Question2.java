// -------------------------------------------------------
// Assignment (include number)
// Written by: (include your name and student id)
// For “Programming Concepts I” Section (your section) – Summer 2021
// --------------------------------------------------------


/*
THIS PROGRAM SHOWS THE STEP BY STEP PROCESS OF ADDING 2 NUMBERS WITH UPTO 3 DIGITS.
*/

import java.util.Scanner;


public class Question2{
    
    static Scanner inpt = new Scanner(System.in); // Scanner for taking input
    
    // the main tutorial function
    public static void tutorial(){
        
        System.out.print("Enter two numbers with at most 3-digits each, separated by a space and press enter: ");
        
        // the 2 numbers that are to be added
        int num1 = inpt.nextInt();
        int num2 = inpt.nextInt();
        System.out.println();
        
        // converting the numbers to string to format the digits to be under the right digit to match the place of digit
        // once over once... tens over tnes... hundreds over hundreds
        String num1S = ""+num1;
        String num2S = ""+num2;
        
        // formatting
        if(num1S.length() == 2)num1S = " "+num1;
        else if(num1S.length() == 1)num1S = "  "+num1;
        
        if(num2S.length() == 2)num2S = " "+num2;
        else if(num2S.length() == 1)num2S = "  "+num2;
        
        // printing the numbers to be added
        System.out.println("You requested the following operation:");
        System.out.println();
        System.out.println(" num1:    "+num1S);
        System.out.println(" num2:  + "+num2S);
        System.out.println("       -------");
        System.out.println();
        
        int t1 = num1;
        int t2 = num2;
        
        int carry = 0; // carry is initally zero
        
        int i = 1; // iteration control
        while(i <= 3){
        
            if(i==1){
                System.out.println("1st addition:");
                System.out.println("  last digit of each number");
            }
            else if(i == 2){
                System.out.println("2nd addition:");
                System.out.println("  the carry from previous addition plus the middle digit of each number");
            }
            else{
                System.out.println("3rd addition:");
                System.out.println("  the carry from previous addition plus the first digit of each number");
            }
            // get the digits on the place currently adding. (ones, tens or hundreds)
            int n1 = (t1%10); 
            int n2 = (t2%10);
            
            int sumOfEachPlace = n1 + n2 + carry;
            
            // message for ones place
            if(i == 1){
                System.out.println("  " + n1 + " + " + n2 + " = " + sumOfEachPlace + " so answer is " + (sumOfEachPlace%10) + " with a carry of "+(int)(sumOfEachPlace/10));
            }
            
            // message for tens place
            else if(i == 2){
                System.out.println("  " + carry + " + " + n1 + " + " + n2 + " = " + sumOfEachPlace + " so answer is " + (sumOfEachPlace%10) + " with a carry of "+(int)(sumOfEachPlace/10));
            }
            
            // message for hundreds place
            else if(i == 3){
                System.out.println("  " + carry + " + " + n1 + " + " + n2 + " = " + sumOfEachPlace + " so answer is " + (sumOfEachPlace));
            }
            
            carry = (int)(sumOfEachPlace/10); // calculating carry
            
            
            // reduce the number of 10th.. example 123 becomes 12
            t1 = (int)(t1/10);
            t2 = (int)(t2/10);
            
            ++i;
            System.out.println();
        }
        
        // formatting and printing the final answer
        String ans = ""+(num1+num2);
        if(ans.length() == 3)ans = " "+ans;
        else if(ans.length() == 2)ans = "  "+ans;
        else if(ans.length() == 1)ans = "   "+ans;
        System.out.println("Final answer:");
        System.out.println(" num1:    "+num1S);
        System.out.println(" num2:  + "+num2S);
        System.out.println("       ------");
        System.out.println("Answer:  "+ans);
        System.out.println();
    }
    
    
    public static void main(String[] args){
        // Welcome message
        System.out.println("Welcome to Addition Tutorial Program!");
        System.out.println("----------------------------------------");
        System.out.println();
        
        boolean runAgain = true; // run the Tutorial until this is True
        
        while(runAgain){
            tutorial(); // starting the tutorial
            
            // asking if the user wants to continue
            System.out.print("Do you want to try another one? (y or Y to repeat) ");
            char res = inpt.next().charAt(0);
            if(!(res=='y' || res=='Y'))runAgain = false;
            System.out.println();
        }
        // ending message
        System.out.println("Hope you are more comfortable with additions now! If not, don't hesitate to come back :-)");
    }
    
    

}

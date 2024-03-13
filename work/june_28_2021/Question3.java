// -------------------------------------------------------
// Assignment (include number)
// Written by: (include your name and student id)
// For “Programming Concepts I” Section (your section) – Summer 2021
// --------------------------------------------------------

/*
THIS PROGRAM TAKES A STRING AS INPUT AND CONVERTS IT INTO ubbi dubbi STRING, THE RULES FOR WHICH ARE GIVEN BELOW

RULES FOR ubbi dubbi: 
1. The vowels are a, e, i, o and u.

2. In the case that a word has 2 vowels following one another we only place ub in front of the 1st
vowel. So zoom would be zuboom and not zuboubom. Similarly, steak would be stubeak and not
stubeubak.

3. For words that are 1 character or 2 character long we add ub in front of each character whether
they are vowels or consonants.

4. If e is the last character of the word, we don’t add ub in front of it. For example, the word one
is translated as ubone and not ubonube.

5. Any other characters (punctuations, digits) are treated as non-vowels

*/

import java.util.Scanner;

public class Question3{

    static Scanner inpt = new Scanner(System.in); // Scanner for taking input
    
    public static void main(String args[]){
        // Starting message
        System.out.println("------------------------------------------------------");
        System.out.println("      English to Ubbi Dubbi Translator Program");
        System.out.println("------------------------------------------------------");
        System.out.println();
        
        System.out.println("Please enter the English sentence you want translated into Ubbi Dubbi");
        System.out.println("(Be sure to have 1 space bwtween words and to not have any spaces at the front and end of the sentence):");
        
        String userStr = inpt.nextLine(); // taking user input
        String res = "";
        
        
        int j = 1; // word length counter
        for(int i=0; i<userStr.length(); ++i){
        
            char curr = userStr.charAt(i); // current character
            
            if(curr == ' ')j=1; // if current character is space then reset the word length counter to 1
            
            if(i==0){ // FOR THE FIRST CHARACTER OF THE STRING
                 
                if(curr=='a' || curr=='e' || curr=='i' || curr=='o' || curr=='u'){ // for first character
                    res = "ub" + curr;
                }
                else{ // for non vowels and non alpha character
                    res = res + curr;
                }
                
            }
            else{ // FOR ALL CHARACTERS OTHER THAN THE FIRST ONE
            
                char prev = userStr.charAt(i-1); // character before the current character
                
                if(
                  (j == 2 && (i==(userStr.length()-1) || userStr.charAt(i+1) == ' ' )) || // if word length is 2, RULE 3 
                  (i==(userStr.length()-1) && (curr=='a' || curr=='i' || curr=='o' || curr=='u')) || // if last character is vowel other than 'e', RULE 4
                  (i!=(userStr.length()-1) && (curr=='a' || curr=='e' || curr=='i' || curr=='o' || curr=='u') && !(prev=='a' || prev=='e' || prev=='i' || prev=='o' || prev=='u')) // if current character is a vowel in somwhere other than the 1st or last position of the string
                ){
                    res = res + "ub" + curr;
                }
                else{ // for non vowels and non alpha character
                    res = res + curr;
                }
                
            }
            // increase the word length counter if an alphabet is encountered
            if(curr>='a' && curr<='z')++j;
        }
        
        System.out.println("Translated sentence:");
        
        System.out.println(res); // output string
        
        System.out.println("Have fun speaking it!!!");
    }
}

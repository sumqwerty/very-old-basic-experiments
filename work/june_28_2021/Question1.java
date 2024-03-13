// -------------------------------------------------------
// Assignment (include number)
// Written by: (include your name and student id)
// For “Programming Concepts I” Section (your section) – Summer 2021
// --------------------------------------------------------


/*
THIS PROGRAM CALCULATES THE FINE AND DEMERIT POINTS OF A PERSON, BASED ON NUMBER OR PARAMETERS LIKE 
WHERE THE PERSON WAS FINED AND WHAT HE WAS DOING.
*/

import java.util.Scanner;


public class Question1{
    
    static Scanner inpt = new Scanner(System.in); // Scanner for taking input
    
    // Welcome message to show the propgram  
    public static void welcomeMessage(){ 
        System.out.println("-------****-------****-------****-------****-----****-----");
        System.out.println("       Welcome to Fine and Demerit Point Evaluator!");
        System.out.println();
        System.out.println("-------****-------****-------****-------****-----****-----");
    }
    
    // Possible locations to the Officer to choose from
    public static int locationSelector(){
        int res = 0;
        
        System.out.println("Welcome Officer - I need some information before i tell you what the fine and demerit points are.");
        System.out.println("Here are the possible locations");
        System.out.println("       1 - Driver was stopped on the highway");
        System.out.println("       2 - In a school zone");
        System.out.println("       3 - Car is stopped at a Stop sign or traffic light");
        System.out.println("       4 - None of the above");
        System.out.println();
        
        System.out.print("Please enter the digit corresponding to your case: ");
        res = inpt.nextInt();
        return res;
    }
    
    // previous demerit points
    public static int getOldDemerit(){
        System.out.print("Last questin officer! How many demerit points did the driver have prior to being stopped? ");
        int res = inpt.nextInt(); // asking the officer for previous demerit points
        System.out.println();
        return res;
    }
    
    
    // Calulate and get fine and demerit after loaction is specified
    public static void calcFineAndDemerit(int loc){
        int totalDemerit;
        int newDemerit;
        
        // comparing the location at which the driver's pulled over
        switch(loc){
            // highway
            case 1:
                // asking if this is driver's first offence
                System.out.print("Officer, is this driver's 1st offence (answer with y for yes and anyting else for no)? ");
                
                newDemerit = 2;
                if(inpt.next().charAt(0) == 'y') newDemerit = 1;
                
                totalDemerit = (getOldDemerit() + newDemerit); // calculating total demerit points
                
                if(totalDemerit < 12){ // demerit is less than 12
                    System.out.println("--> Write a ticket for $80, and inform the driver that they now have "+totalDemerit+" demerit points.");
                }
                else{ // Demerit is 12 or greater
                    System.out.println("--> Write a ticket for $80. Also the driver has "+totalDemerit+" demerit points.");
                    System.out.println("Please take away their driver's license and make arrangements to have the car towed right away.");
                }
                break;
            
            // school zone
            case 2:
                // asking duration of the dirver's driving 
                System.out.print("Officer, how many months has the driver been driving? ");
                newDemerit = 4;
                if(inpt.nextInt() < 24){ // if driver's been driving for less than 24 months
                    System.out.println();
                    System.out.println("--> Officer, write a ticket for $100, take away their dirver's license and make arrangements to have the car towed right away.");
                }
                else{
                    
                    totalDemerit = (getOldDemerit() + newDemerit); // calculating total demerit points
                    System.out.println("--> Write a ticket for $100, and inform the driver that they now have "+totalDemerit+" demerit points.");
                }
                break;
            
            // Stop sign or traffic light
            case 3:
                // asking about driver's phone
                System.out.print("Officer, is this the cellphone in question is an iPhone (answer with y for yes and anyting else for no)? ");
                newDemerit = 1;
                int fine = 80;
                
                if(inpt.next().charAt(0) == 'y'){ // if cellphone is an iPhone
                    newDemerit = 2;
                    fine = 100;
                }
                
                totalDemerit = (getOldDemerit() + newDemerit); // calculating total demerit points
                
                if(totalDemerit < 12){ // demerit is less than 12
                    System.out.println("--> Write a ticket for $"+fine+", and inform the driver that they now have "+totalDemerit+" demerit points.");
                }
                else{ // Demerit is 12 or greater
                    System.out.println("--> Write a ticket for $"+fine+". Also the driver has "+totalDemerit+" demerit points.");
                    System.out.println("Please take away their driver's license and make arrangements to have the car towed right away.");
                }
                break;
            
            // None of the above
            case 4:
                newDemerit = 3;
                totalDemerit = (getOldDemerit() + newDemerit); // calculating total demerit points
                
                if(totalDemerit < 12){ // demerit is less than 12
                    System.out.println("--> Write a ticket for $90, and inform the driver that they now have "+totalDemerit+" demerit points.");
                }
                else{ // Demerit is 12 or greater
                    System.out.println("--> Write a ticket for $90. Also the driver has "+totalDemerit+" demerit points.");
                    System.out.println("Please take away their driver's license and make arrangements to have the car towed right away.");
                }
                break;
        }
    }

    public static void main(String[] args){
        welcomeMessage(); // display welcome message
        
        int loc = locationSelector(); // choose a location
        
        calcFineAndDemerit(loc); // Calulate fine and demerit
        
        // Message showing the end of the program
        System.out.println();
        System.out.println("Good job Officer! keep up the good work!!!!");
    }
}

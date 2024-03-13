package foldr;

import java.io.*;
import java.util.*;


public class Runner{
    
    static Scanner inpt = new Scanner(System.in);
    static Scanner fullLine = new Scanner(System.in);
    
    public static void newLine(){
        System.out.println();
    }
    
    public static String[] bank_info(){
        String[] res = new String[2];
        System.out.print("Enter bank name: ");
        res[0] = inpt.next();
        
        
        System.out.print("Enter branch location: ");
        res[1] = inpt.next();
        
        
        newLine();
        System.out.println("Welcome to "+res[1]+" of "+res[0]);
        newLine();
        
        return res;
        
        
    }

	public static void main(String args[]){
        String[] commands = {"Add", "View", "Account", "Modify", "Delete", "Summary", "Help"};
        boolean gameOver = false;
        
        String[] bnk_info = bank_info();
        Bank bank = new Bank(bnk_info[0],bnk_info[1]);
        
        while(!gameOver){
            System.out.println("Enter the option you want to proceed with");
            System.out.println("o Add Account");
            System.out.println("o View Account");
            System.out.println("o Account Details");
            System.out.println("o Modify Account");
            System.out.println("o Delete Account");
            System.out.println("o Summary");
            System.out.println("o Help");
            System.out.println("o Enter q or Q to quit");
            
            
            newLine();
            
            String command = "";
            boolean valid = false;
            while(!valid)
            {
                System.out.print("Enter an option: ");
                command = fullLine.nextLine();
                
                if(command.compareToIgnoreCase("q") == 0){
                    gameOver = true;
                    break;
                }
                
                String temp[] = command.split(" ");
                
                for(int i=0; i < commands.length; ++i){
                    if(temp[0].compareToIgnoreCase(commands[i]) == 0)
                    {
                        valid = true;
                        break;
                    }
                    else valid = false;
                }
                if(valid){
                    valid = true;
                    break;
                }
                else System.out.println("Enter a valid command");
            }
            while(!gameOver)
            {
                bank.parse_commands(command);
                System.out.print("Continue[Y/n]");
                String s = inpt.next();
                if(s.compareToIgnoreCase("n") == 0){
                    gameOver = true;
                    break;
                }
            }
            
        }

	}

}




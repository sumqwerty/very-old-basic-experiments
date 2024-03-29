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
            
            
                bank.parse_commands(command);
                System.out.println();
                
            
        }

	}

}

class Account{
	private String acc_num;
	private double acc_bal;
	private String acc_name;

	String get_acc_num(){
		return acc_num;
	}

	double get_acc_balance(){
		return acc_bal;
	}

	String get_acc_name(){
		return acc_name;
	}

	boolean set_acc_num(String _acn){
		for(int i=0; i < _acn.length(); ++i){
			if(!((_acn.charAt(i) >= '1' && _acn.charAt(i) <= '9') || ((_acn.charAt(i) >= 'A' && _acn.charAt(i) <= 'Z') || (_acn.charAt(i)>='a' && _acn.charAt(i)<= 'z') ))){
				return false;
			}
		}


		acc_num = _acn;
		return true;
	}

	boolean set_acc_name(String _name){
		for(int i=0; i < _name.length(); ++i){
            if(!((_name.charAt(i) >= 'A' && _name.charAt(i) <= 'Z') || (_name.charAt(i) >= 'a' && _name.charAt(i) <= 'z') || _name.charAt(i) == '-' || _name.charAt(i) == ' ') ){
                return false;
            }
		}
		
		acc_name = _name;
		
		return true;
	}
	
	boolean set_acc_balance(double _bal){
        if(_bal < 0 )return false;
        
        acc_bal = _bal;
        return true;
	}

	
}

class Bank{
    
    Scanner inpt = new Scanner(System.in);
    Scanner fullLine = new Scanner(System.in);
    
	private String bank_name;
	private String branch_loc;
	private ArrayList<Account> accounts;
	
	Bank(String _name, String _branch){
        bank_name = _name;
        branch_loc = _branch;
        accounts = new ArrayList<Account>();
	}
	
	
    Account get_account(String acc_number){
        for(Account a : accounts){
            if(a.get_acc_num().equals(acc_number)){
                return a;
            }
        }
        
        return null;
    }
    
    void add_account(){
        Account acc = new Account();
        accounts.add(acc);
        
        System.out.print("Enter new Account number: ");
        
        while(!acc.set_acc_num(inpt.next())){
            System.out.print("Please enter a valid account number.(The account number can only contain alphanumerical characters): ");
        }
        
        
        System.out.print("Enter new Account name: ");
        while(!acc.set_acc_name(fullLine.nextLine())){
            System.out.print("Please enter a valid account name.(The account name can only contain alphabetical characters, as well as spaces and hyphens): ");
        }
        
        System.out.print("Enter initial Account balance: ");
        while(!acc.set_acc_balance(inpt.nextDouble())){
            System.out.print("Please enter a valid account balance.(The account balance can only contain non-negative): ");
        }
    }
    
    void view_accounts(){
        if(accounts.size() == 0)System.out.println("No accounts in this bank");
        else
            for(Account acc : accounts)
            {
                System.out.println();
            
                System.out.println("Account Number: "+acc.get_acc_num());
                System.out.println("Account Name: "+acc.get_acc_name());
                System.out.println("Account Balance: "+acc.get_acc_balance());
                
                System.out.println();
            }
    }
    
    void view_account(String acc_number){
        Account temp = get_account(acc_number);
        while(temp == null){
            System.out.print("Account number not registered(retry): ");
            String acc_n = inpt.next();
            temp = get_account(acc_n);
            if(temp != null)break;
        }
        
        System.out.println();
            
        System.out.println("Account Number: "+temp.get_acc_num());
        System.out.println("Account Name: "+temp.get_acc_name());
        System.out.println("Account Balance: "+temp.get_acc_balance());
                
        System.out.println();
        
        
    }
    
    void modify_account(String acc_number, String opt){
        Account temp = get_account(acc_number);
        while(temp == null){
            System.out.print("Account number not registered(retry): ");
            String acc_n = inpt.next();
            temp = get_account(acc_n);
            if(temp != null)break;
        }
        
        if(opt.compareToIgnoreCase("1")==0 || opt.compareToIgnoreCase("name")==0){
            System.out.print("Enter modified Account name: ");
            while(!temp.set_acc_name(fullLine.nextLine())){
                System.out.print("Please enter a valid account name.(The account name can only contain alphabetical characters, as well as spaces and hyphens): ");
            }
            
        }
        
        else if(opt.compareToIgnoreCase("2")==0 || opt.compareToIgnoreCase("number")==0){
            System.out.print("Enter modified Account number: ");
            while(!temp.set_acc_num(inpt.next())){
                System.out.print("Please enter a valid account number.(The account number can only contain alphanumerical characters): ");
            }
            
        }
        
        else if(opt.compareToIgnoreCase("3")==0 || opt.compareToIgnoreCase("balance")==0){
            System.out.print("Enter new Account balance: ");
            while(!temp.set_acc_balance(inpt.nextDouble())){
                System.out.print("Please enter a valid account balance.(The account balance can only contain non-negative): ");
            }
            
        }
    }
    
    void modify_account(String acc_number){
        Account temp = get_account(acc_number);
        while(temp == null){
            System.out.print("Account number not registered(retry): ");
            String acc_n = inpt.next();
            temp = get_account(acc_n);
            if(temp != null)break;
        }
        
        System.out.println("Choose the option to be modified:");
        System.out.println("1. name");
        System.out.println("2. number");
        System.out.println("3. balance");
        
        String opt = inpt.next();
        
        if(opt.compareToIgnoreCase("1")==0 || opt.compareToIgnoreCase("name")==0){
            System.out.print("Enter modified Account name: ");
            while(!temp.set_acc_name(fullLine.nextLine())){
                System.out.print("Please enter a valid account name.(The account name can only contain alphabetical characters, as well as spaces and hyphens): ");
            }
            
        }
        
        else if(opt.compareToIgnoreCase("2")==0 || opt.compareToIgnoreCase("number")==0){
            System.out.print("Enter modified Account number: ");
            while(!temp.set_acc_num(inpt.next())){
                System.out.print("Please enter a valid account number.(The account number can only contain alphanumerical characters): ");
            }
            
        }
        
        else if(opt.compareToIgnoreCase("3")==0 || opt.compareToIgnoreCase("balance")==0){
            System.out.print("Enter new Account balance: ");
            while(!temp.set_acc_balance(inpt.nextDouble())){
                System.out.print("Please enter a valid account balance.(The account balance can only contain non-negative): ");
            }
            
        }
        
    }
    
    void delete_account(String acc_number){
        System.out.print("Are you sure you want to delete the account?[y/N]: ");
        String res = inpt.next();
        
        if(res.compareToIgnoreCase("y")==0 || res.compareToIgnoreCase("yes")==0){
            boolean found = false;
            int i;
            for(i=0; i<accounts.size(); ++i){
                if(accounts.get(i).get_acc_num().equals(acc_number))
                {
                    found = true;
                    break;
                }
            }
            
            if(found)accounts.remove(i);
            else System.out.println("No account found");
            
        }
        
    }
    
    void summary_accounts(){
        
        int total_acc = accounts.size();
        
        double total_bal = 0;
        for(Account acc : accounts)total_bal += acc.get_acc_balance();
        
        double avg_bal = total_bal / total_acc;
        
        System.out.println();
        
        System.out.println("Total number of accounts: "+total_acc);
        System.out.println("Sum of all balances: "+total_bal);
        System.out.println("Average of all balances: "+avg_bal);
        
        System.out.println();
    }
    
    void help_page(){
        System.out.println();
    
        System.out.println("========== HELP MANUAL ==========");
        
        System.out.println("1. Add Account :             to add a new account to the bank.");
        System.out.println();
        System.out.println("2. View Accounts :           Output all account information for each of the Banks’ account.");
        System.out.println();
        System.out.println("3. Account Details :         get a summary of the specific account details.");
        System.out.println("                             USAGE: view ACCOUNT_NUMBER details ");
        System.out.println();
        System.out.println("4. Modify Account :          get a list of options user can modify of the account object (name, number, balance)");
        System.out.println("                             USAGE(for all account info): modify ACCOUNT_NUMBER");
        System.out.println("                             USAGE(for specific account info): modify ACCOUNT_NUMBER OPTION");
        System.out.println("                             OPTION: name, number, balance");
        System.out.println("5. Delete Account :          Remove account from the bank.");
        System.out.println("                             USAGE: delete ACCOUNT_NUMBER");
        System.out.println("6. Help :                    Shows help manual.");
        System.out.println("6. q or Q :                  Quits the program.");

        System.out.println();
        
        

    }
    
    void parse_commands(String command){
        
        String[] commandParts = command.split(" ");
        
        if(commandParts.length == 1){
            if(commandParts[0].compareToIgnoreCase("Summary") == 0){
                summary_accounts();
            }
            
            else if(commandParts[0].compareToIgnoreCase("Help") == 0){
                help_page();
            }
        }
        
        else if(commandParts.length == 2){
            if(commandParts[0].compareToIgnoreCase("Add") == 0){
                add_account();
            }
            
            else if(commandParts[0].compareToIgnoreCase("View") == 0){
                view_accounts();
            }
            
            else if(commandParts[0].compareToIgnoreCase("Modify") == 0){
                modify_account(commandParts[1]);
            }
            
            else if(commandParts[0].compareToIgnoreCase("Delete") == 0){
                delete_account(commandParts[1]);
            }
        }
        
        else if(commandParts.length == 3){
            if(commandParts[0].compareToIgnoreCase("Modify") == 0){
                modify_account(commandParts[1],commandParts[2]);
            }
            
            else if(commandParts[0].compareToIgnoreCase("View") == 0){
                view_account(commandParts[1]);
            }
        }
        
    }

}



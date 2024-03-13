
employee_list = [] # 0:6
item_list = [] # 0:2

def mainMenu():
    print()
    print("--------------------------------------------")
    cPrint("1-Create Employee")
    cPrint("2-Create Item")
    cPrint("3-Make Purchase")
    cPrint("4-All Employee Summary")
    cPrint("5-Exit")
    print("--------------------------------------------")
    
    choice = int(input())
    
    return choice

def getIndex(lst,ele):
    res = -1
    for i in range(0, len(lst)):
        if(lst[i] == ele):
            return i
        i+=1
    return res;

def inptValid(string,typ,lst,indx=-1,chk=""):
    inpt=0;
    valid=False;
    
    while not valid:
        print(string,end=": ")
    
        if(typ == "str"):
            inpt=input()
            
            if len(inpt) == 0:
                continue
            
            elif chk == "hourly-manager" and inpt not in chk:
                continue
            
            if chk == "hourly-manager":
                return inpt
            
        else:
            inpt=int(input());
            
            if(chk == "false"):
                return inpt                
        
            
        found=False
        
        if(chk != "false"):
            for inner in lst:
                res = getIndex(inner,inpt)
                if(res == indx):
                    found = True
                    break;
                
        if not found:
            valid=True
                
    
    return inpt


def createItem():
    iID=0;
    iName="";
    iCost="";
    gameOver=False;
    while not gameOver:    
        iID=inptValid("Enter Item ID","int",item_list,0)
        iName=inptValid("Enter Item Name","str",item_list,-1,"false")
        iCost=inptValid("Enter Item Cost","int",item_list,-1,"false")
        item_list.append([iID,iName,iCost])
        
        ask = input("Another Item?(y/n) ")
        if ask[0] != 'y' or ask[0] == 'Y':
            ask=input("Go to Main menu?(y/n) ")
            if ask[0] == 'y' or ask[0] == 'Y':
                return
            else:
                exit();        

def createEmployee():
    eID=0;
    eName="";
    eType="";
    workYr="";
    totalPur=0;
    totalDiscount=0;
    discountNum=0;
    
    gameOver=False;
    while not gameOver:
        eID=inptValid("Enter Employee ID","int",employee_list,0)
        eName=inptValid("Enter Employee Name","str",employee_list,-1,"false")
        eType=inptValid("Enter Employee Type","str",employee_list,2,"hourly-manager")
        workYr=inptValid("Enter Years Worked","int",employee_list,-1,"false")
        discountNum=inptValid("Enter Employee Discount Number","int",employee_list,6)
        
        employee_list.append([eID,eName,eType,workYr,0,0,discountNum])
        
        ask = input("Another Employee?(y/n) ")
        if ask[0] != 'y' or ask[0] == 'Y':
            ask=input("Go to Main menu?(y/n) ")
            if ask[0] == 'y' or ask[0] == 'Y':
                return
            else:
                exit();
            
def printSummary():
    print("Employee ID, Employee Name, Employee Type, Years Worked, Total Purchased, Total Discounts, Employee Discount Number");
    for lst in employee_list:
        num=0
        for ele in lst:
            if num == 6:
                print(ele,end=" ")
            else:
                print(ele,end=", ")
            num+=1
        print()

    ask=input("Go to Main menu?(y/n) ")
    if ask[0] == 'y' or ask[0] == 'Y':
        return
    else:
        exit();

    

def makePurchase():
    print("Item Number, Item Name, Item Cost");
    empIndex=0;
    itemIndex=0;
    for lst in item_list:
        num=0
        for ele in lst:
            if num == 2:
                print(ele,end=" ")
            else:
                print(ele,end=", ")
            num+=1
        print()
    
    gameOver = False
    
    while not gameOver:
        valid = False
        while not valid:
            emp_id=int(input("Enter Discount number: "))
            for i in range(0,len(employee_list)):
                res = getIndex(employee_list[i],emp_id)
                if res == 6:
                    valid=True
                    empIndex=i;
                    break
            if valid:
                break;
        
        
        valid = False
        while not valid:
            item_to_purchase=int(input("Item ID to purchase: "))
            for i in range(0,len(item_list)):
                res = getIndex(item_list[i],item_to_purchase)
                if res == 0:
                    itemIndex=i;
                    valid=True
                    break
            
            if valid:
                
                break;
            
    
        confirm = input("Confirm purchase: ");
        
        if confirm[0] == 'y' or confirm[0] == 'Y':
            if(employee_list[empIndex][5] < 200):
                
                discountPrt = 0;
                # years working
                if(employee_list[empIndex][3] > 5):
                    discountPrt+=10;
                else:
                    discountPrt+= (employee_list[empIndex][3]*2)
                
                # emp Type
                if(employee_list[empIndex][2]=="manager"):
                    discountPrt+=10;
                else:
                    discountPrt+=2;
                
                currDiscount = (item_list[itemIndex][2]*(discountPrt/100));
                
                if(employee_list[empIndex][5]+currDiscount > 200):
                    currDiscount = 200 - employee_list[empIndex][5];
                
                toPay = item_list[itemIndex][2]-currDiscount;
                employee_list[empIndex][4] += toPay;
                employee_list[empIndex][5] += currDiscount;
            else:
                toPay = item_list[itemIndex][2];
                employee_list[empIndex][4] += toPay;
        
        ask = input("New Purchase?(y/n) ")
        
        if ask[0] != 'y' or ask[0] == 'Y':
            printSummary()
            ask=input("Go to Main menu?(y/n) ")
            if ask[0] == 'y' or ask[0] == 'Y':
                return
            else:
                exit();


def cPrint(string):
    for i in range(0,40):
        if i >= len(string):
            string+=" ";
            
    print("|",string,"|");


def gameLoop():
    gameOver = False;
    while(not gameOver):
        choice = mainMenu();
        
        if choice == 1:
            createEmployee();
        
        elif choice == 2:
            createItem();
        
        elif choice == 3:
            makePurchase()
        
        elif choice == 4:
            printSummary()
        
        elif choice == 5:
            gameOver = True
            break
        
        
        

gameLoop()

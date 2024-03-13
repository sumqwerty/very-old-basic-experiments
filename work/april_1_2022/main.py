user = []
expenses = []
userExp = []

def menu():
    print("-------------------------------")
    print("| 1 - Create user             |")
    print("| 2 - Create expense          |")
    print("| 3 - Add Expense to User     |")
    print("| 4 - Show all expenses       |")
    print("| 5 - Exit                    |")
    print("-------------------------------")
    
    choice = int(input())
    return choice


def createUser():
    name = input("Enter Name: ")
    age = int(input("Enter age: "))
    
    user.append([name,age])
    print(user[0])



# home transportation food
def createExpense():
    expense_type = input("Expense type: ")
    expense_cost = float(input("Expense cost: "))
    expenses.append([expense_type,expense_cost])
    


def addExpense():
    print("User Names")
    for usr in user:
        print("  "+usr[0])
    
    print("Expenses")
    for exp in expenses:
        print("  "+exp[0])
    
    valid = False
    nme=""
    exps=""
    while not valid:
        nme = input("Enter User Name: ")
        for i in user:
            if nme in i:
                valid=True
                break
    
    valid = False
    
    while not valid:
        exps = input("Enter expense type: ")
        for i in expenses:
            if exps in i:
                valid=True
                break
    
    userExp.append([nme,exps])
    
    
def showAllExpense():
    expCost = {}
    
    for val in expenses:
        expCost[val[0]] = val[1]
    print("User\t|\tExpense\t|\tCost")
    print("---------------------------------------------")
    for pair in userExp:
        print(pair[0]+"\t|\t"+pair[1]+"\t|\t"+str(expCost[pair[1]]))



def mainLoop():
    gameOver=False
    
    while not gameOver:
        choice = menu()
        if choice == 1:
            createUser()
        elif choice == 2:
            createExpense()
        elif choice == 3:
            addExpense()
        elif choice == 4:
            showAllExpense()
        if choice == 5:
            gameOver = True
            break

mainLoop();
"""
################# NOTE #################
THERE ARE NO PRE REGISTERED PRODUCTS. SO THE FIRST STEP IS TO REGISTER NEW PRODUCTS
AND FILL UP THEIR STOCK BY RECEIVING THE SHIPMENT 
########################################

USING SMART_MART APPLICATION
1. Regsiter the products the store will be selling
2. Order the products and receive the shipment to fill the stock
3. Sell the products and generate the bills 
4. Check sales report for the day
5. Keep the stocks filled and check stock report
"""


from helper import FormatTable # Class to Display formatted output of the billes and reports
from productObj import StockProduct # prodcut object to keep in the store

# driver class
class Smart_Mart():
    def __init__(self):
        self.products = {} # Registered Products, {productNumber : StockProduct_Object}
        self.soldProducts = [] # product sold
        self.orderList = [] # products to be ordered
        self.disp = FormatTable() # formatting outputs as table
        self.running = True # application is running flag

    # Each product to be ordered or to be sold is to be Registered first
    def registerProduct(self):
        name = input("Enter Product Name: ")
        num = int(input("Enter Product Number: "))
        desc = input("Enter product description: ")
        price = int(input("Enter unit selling price: "))
        temp = StockProduct(name,num,desc,price)
        self.products[num] = temp
    
    
    # Custorme buys some product and bill is generated
    def billing(self):
        loop = True
        billTotal = 0;
        lst = []
        
        # heading for billing output
        heading = ["Product Number", "Units Purchased", "Unit Price", "Total Price"]
        data = []
        
        while loop: # keep asking for bought Prodcuts until user enters -1
            num = int(input("Enter Prodcut Number(Enter -1 if no more products left): "))
            if num != -1:
                quantity = int(input("Product Quantity to buy: "))
                lst.append([num, quantity])
                
                self.products[num].soldProduct(quantity) # update product quantity in stock
                
                if num not in self.soldProducts:
                    self.soldProducts.append(num) # add product to the sold list
                
                billTotal += self.products[num].unitSellingPrice * quantity
            else:
                loop = False
        
        # fill the enetries for the table in data list to be displayed in a formatted output
        for ele in lst:
            data.append([str(ele[0]), str(ele[1]), str(self.products[ele[0]].unitSellingPrice), str(self.products[ele[0]].unitSellingPrice * ele[1])])
        
        print()
        print("##################### BILL #####################")
        self.disp.loadArr(heading) # load table headings
        self.disp.displayHeading() # dipslay table headings
        self.disp.displayData(data) # display table data
        print("")
        print("13% Tax: "+str(billTotal*0.13)) # calculating taxes
        billTotal += (billTotal*0.13)
        print("Total Bill: "+str(billTotal)) # total bill to be paid
        print("################################################")
            
    
    
    # displays the sales for the day
    def salesReport(self):
        totalProducts = 0
        totalPrice = 0
        
        # heading for sales report
        heading = ["Product Number", "Product Name", "Product Purchased", "Total Price"]
        data = []
        
        # fill the enetries for the table in data list to be displayed in a formatted output
        for ele in self.soldProducts: # check the list of sold products
            totalProducts += self.products[ele].sold
            totalPrice += self.products[ele].sold*self.products[ele].unitSellingPrice
            data.append([str(ele),str(self.products[ele].productName),str(self.products[ele].sold),(str(self.products[ele].sold*self.products[ele].unitSellingPrice))])
        
        print()
        print("##################### SALES REPORT #####################")        
        self.disp.loadArr(heading) # load table headings
        self.disp.displayHeading() # dipslay table headings
        self.disp.displayData(data) # display table data
        print("Total Products Sold: "+ str(totalProducts))
        print("Total Price: "+ str(totalPrice))
        print("########################################################")


    def updateOrderList(self):
        self.orderList = []
        for num in self.products:
            product = self.products[num]
            if(product.inStock < 10 and num not in self.orderList): # if stock is less than 10 units 
                self.orderList.append(num) # add the product to the order list
        
        
    # Shipping Products to the store
    def shipment(self):
        num = int(input("Enter product number: "))
        units = int(input("Enter units received: "))
        wprice = int(input("Enter wholesale price: "))
        exp = input("Enter expiry date(dd-mm-yyyy) if any, otherwise just press enter: ")
        self.products[num].setNew(units,wprice,exp) # updating stocks for the products received
        self.updateOrderList() # update the order list after receiving shipment
            
        
    
    
    # The report will show the products that are about to finish
    def stockReport(self):
        # headings for the stock report
        heading = ["Product Number", "Product Name", "Stock"]
        data = []

        # checking the product stock in the store
        for num in self.products:
            product = self.products[num]
            data.append([str(product.productNumber),product.productName,str(product.inStock)])
            if(product.inStock < 10 and num not in self.orderList): # if stock is less than 10 units 
                self.orderList.append(num) # add the product to the order list
                
                
                
        print()
        print("##################### STOCK REPORT #####################")        
        self.disp.loadArr(heading)
        self.disp.displayHeading()
        self.disp.displayData(data)
        
        
        if(len(self.orderList) == 0): # if order list is empty then end of report
            print("########################################################")
            return
        
        print("\nProducts in Order List")
        data = []
        for num in self.orderList:
            product = self.products[num]
            data.append([str(product.productNumber),product.productName,str(product.inStock)])                
        
        # displaying order list
        self.disp.displayHeading()
        self.disp.displayData(data)
        print("########################################################")
        
    
    # Main interface menu where the user will chose which action to take
    def mainMenu(self):
        print("")
        print("############## MENU ##############")
        print("1. Register New Product")
        print("2. Customer Billing")
        print("3. Sales Report")
        print("4. Order New Products")
        print("5. Stocking Report")
        print("6. Exit")
        print("##################################")
        
        loop = True
        while loop:
            try:
                choice = int(input("Enter choice: "))
                if(choice > 6 or choice < 1):
                    raise Exception("") # if invalid input is given raise an Exception
                return choice
            except:
                print("Please enter a valid choice from [1,2,3,4,5,6]")
    
    # main application loop
    def mainLoop(self):
        
        while self.running:
            choice = self.mainMenu() # get the user choice from the main menu
            
            if choice == 1:
                self.registerProduct()
            elif choice == 2:
                self.billing()
            elif choice == 3:
                self.salesReport()
            elif choice == 4:
                self.shipment()
            elif choice == 5:
                self.stockReport()
            elif choice == 6: # exit and close the application
                self.running = False

# entry point of the application
mart = Smart_Mart()
mart.mainLoop()

# Base product class that contains basic Product Properties
class Product():
    def __init__(self,_name, _num, _desc, _price):
        self.productName = _name
        self.productNumber = _num
        self.productDescription = _desc
        self.unitSellingPrice = _price


# Chlid class inherits the Product Parent Class 
# Adding Shipping attributes to the Product Object
class ShippingProduct(Product):
    def __init__(self, _name, _num, _desc, _price, _units=0, _wprice=0, _exp=""):
        super().__init__(_name, _num, _desc, _price)
        self.productUnits = _units
        self.wholeSalePrice = _wprice
        self.expiry = _exp
    
    # Function to update the stock enteries when new shipment is received at the store
    def setNew(self, _units=0, _wprice=0, _exp=""):
        self.productUnits = _units
        self.wholeSalePrice = _wprice
        self.expiry = _exp
        
        
# Child Class of ShippingProduct Class
# Adding Retail attributes to the Product Object
class StockProduct(ShippingProduct):
    def __init__(self, _name, _num, _desc, _price):
        super().__init__(_name, _num, _desc, _price)
        self.inStock = 0
        self.sold = 0
        
    # Update the stock and sold units amount after a product is sold
    def soldProduct(self, units):
        self.inStock -= units
        self.sold += units
    
    # Updating product stock after new shipment is received at the store
    def setNew(self, _units=0, _wprice=0, _exp=""):
        super().setNew(_units, _wprice, _exp) # calling the parent class setNew function to update the Product Object
        self.inStock += _units
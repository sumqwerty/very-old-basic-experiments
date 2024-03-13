# Class to Display formatted output of the billes and reports
"""
Each entry of the output table is a label(both the column names and the data)
A fixed space of 4 space characters(    ) is fixed between the labels
If the label is too long or short extra space characters are added to format the 
output properly
"""
class FormatTable():
    def __init__(self):
        self.heading = [] # heading for the output table columns
        self.size = []
        
    def loadArr(self, _head): # loads new headings 
        self.heading = []
        self.size = []
        for i in _head:
            self.heading.append(i)
            self.size.append(len(i))
            
    def formatString(self, label): # formatting ouput strings with proper spaces 
        final = ""
        for i in range(0,len(label)):
            st = str(label[i])
            space = "    " # fixed space between headings
            for j in range(0,(self.size[i]-len(st))):
                space = " "+space #adding extra spaces for shorter labels
                
            final += (st+space)
        
        return final

    # display column headings
    def displayHeading(self):
        print(self.formatString(self.heading))
    
    # display table data
    def displayData(self, labels):
        for label in labels:
            print(self.formatString(label))
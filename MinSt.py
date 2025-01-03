#Approach 1: 

class MinStack:

    def __init__(self):
        self.st=[]
        self.minst=[]
        self.Min=int(sys.maxsize)
        self.minst.append(self.Min)
        
        

    def push(self, val: int) -> None:
        if val<=self.Min:
            self.Min=val
        self.st.append(val)
        self.minst.append(self.Min)

    def pop(self) -> None:
        self.st.pop()
        self.minst.pop()
        self.Min=self.minst[-1]
       

    def top(self) -> int:
        return self.st[-1]
        

    def getMin(self) -> int:
        return self.Min
    

#Approach 2:
class MinStack:

    def __init__(self):
        self.st=[]
        self.Min=int(sys.maxsize)
        

    def push(self, val: int) -> None:
        if val<=self.Min:
           self.st.append(self.Min)
           self.Min=val
        self.st.append(val)
        

    def pop(self) -> None:
        popped=self.st.pop()
        if popped == self.Min:
            self.Min=self.st.pop()
        

    def top(self) -> int:
        return self.st[-1]
        

    def getMin(self) -> int:
        return self.Min
        
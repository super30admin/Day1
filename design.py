class MinStack:

    def __init__(self):
        self.mainStack = [] # This is the main Stack where we store the values
        self.minAtEachLevel = [] # We calculate the minimum at each level[basically for each elment of stack we find the minimun in the whole stack]
        

    def push(self, val: int) -> None:
        # O(1) as appending at end takes O(1)
        self.mainStack.append(val)

        if not self.minAtEachLevel:
            self.minAtEachLevel.append(val)
        else:
            self.minAtEachLevel.append(min(val,self.minAtEachLevel[-1]))    
        

    def pop(self) -> None:
        #To remove the last elemnt takes O(1)
        if self.mainStack:
            self.mainStack.pop()
            self.minAtEachLevel.pop()
        

        

    def top(self) -> int:
        # contsnt time O(1) bcoz we use indexing and get the last element
        if self.mainStack:
            return self.mainStack[-1]
        

    def getMin(self) -> int:
        # contsnt time O(1) bcoz we use indexing and get the last element
        if self.minAtEachLevel:
            return self.minAtEachLevel[-1]

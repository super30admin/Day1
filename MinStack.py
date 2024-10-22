"Time and Space Complexity of all the functions below is O(1)"

#EXxplanation of the problem

"You have a variable with an infinte value, This keeps getting updated as a new value is added or popped based on the condition that min, should always have the least value"
"If the value we are trying to add is greater than the min, we can directly append the value into the stack"
"But when the value is lesser than min, we have to add both min and the value into the stack as we want to retrive the last min value too"
"Top function just gives the last value of stack"
"getMin just gives the value of min value variable, which always contains the min"

class MinStack:

    def __init__(self):
        self.stack = []
        self.min1 = float('inf')
        
    def push(self, val: int) -> None:
        if val <= self.min1:
            self.stack.append(self.min1)
            self.min1 = val
        self.stack.append(val)
        
        
    def pop(self) -> None:
        popped_value = self.stack.pop()
        if self.min1 == popped_value:
            self.min1 = self.stack.pop()      

    def top(self) -> int:
        return self.stack[-1]
    
    def getMin(self) -> int:
        return self.min1
        
# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
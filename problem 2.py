class MinStack:

    def __init__(self):
        self.stack = [] # stack to store elements
        self.stack_min = [] #stack to store only min element
        

    def push(self, val: int) -> None:
        self.stack.append(val) #push value 

        #to check if the new val is not in stack_min or if the val is less than 
        # the entry in stack_min then we append this val as the new min in stack_min
        if not self.stack_min or val <= self.stack_min[-1]:
            self.stack_min.append(val)
        

    def pop(self) -> None:
        # Pop the value from the main stack.
        popped_value = self.stack.pop()

        # If the popped value is the min then remove it from stack_min too
        if popped_value == self.stack_min[-1]:
            self.stack_min.pop()
        

    def top(self) -> int:
        return self.stack[-1] #return top element
        

    def getMin(self) -> int:
        return self.stack_min[-1] #return top element in stack_min wwhich is the min element
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
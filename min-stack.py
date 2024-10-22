# We will initialize 2 stacks one for normal stack and another for min stack
# we will push the value in normal stack and if the value is less than the min value we will push it in minStack
# similarly we will pop the value from normal stack and if the value is equal to the min value we will pop it from minStack.

# // Time Complexity :  o(1) for all functions
# // Space Complexity : O(n) for both stacks in worst case, wouldve been O(1) for 1 stack
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Failed single stack approach 


# // Your code here along with comments explaining your approach

class MinStack:

    def __init__(self):                                                     # 2 stack appraoch
        self.stack = []
        self.minStack = [float('inf')]

    def push(self, val: int) -> None:
        self.stack.append(val)                                              # normal stack                      
        self.minStack.append(min(self.minStack[-1], val))                   # 2nd push minStack after comparison
        
    def pop(self) -> None:
        if self.stack :                                                     # if stack is not empty          
            temp = self.stack.pop()                                         # pop normal stack
            if temp >= self.minStack[-1]:                                   # if temp is greater than or equal to min value
                self.minStack.pop()                                         # 2nd pop minStack     
        

    def top(self) -> int:
        if self.stack:                                                       # if stack is not empty
            return self.stack[-1]                                            # peek
        else:
            return None

    def getMin(self) -> int:                                                       
        if self.minStack:   
            return self.minStack[-1]                                          # Min is last element of minStack      
        else:
            return None


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
obj.push(-2)
obj.push(0)
obj.push(-3)
print(obj.getMin()) #// return -3
obj.pop()
print(obj.top())   #// return 0
print(obj.getMin()) #// return -2
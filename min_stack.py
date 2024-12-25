
# Time Complexity - O(1) for push,pop,top,getMin
# Space Complexity - O(n) due to two stacks

# Approach - 
# Used two stacks: one (stack) to store all elements and another (minStack) to keep track of the minimum values
# On push, appending the value to stack and update minStack with the smaller of the new value or the current minimum
# On pop, remove the top elements from both stack and minStack, and usec minStack to retrieve the minimum in O(1) time 

class MinStack:

    def __init__(self):
        self.stack= []
        self.minstack = []
    def push(self, val: int) -> None:
        self.stack.append(val)
        val = min(val,self.minstack[-1] if self.minstack else val )
        self.minstack.append(val)
    def pop(self) -> None:
        self.stack.pop()
        self.minstack.pop()
    def top(self) -> int:
        return self.stack[-1]
    def getMin(self) -> int:
        return self.minstack[-1]

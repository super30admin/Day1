# Problem 2 : Min Stack
# Time Complexity :
'''
All operation- O(1)
'''
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
class MinStack:

    def __init__(self):
        # creating two stack. One stack for pushing the value and second stack for storing the minimum value
        self.stack = []
        self.minStack = []
        

    def push(self, val: int) -> None:
        # append the val to the first stack which is storing the val
        self.stack.append(val)
        # check if minStack is not empty and then compare the val with the top value of minStack
        if not self.minStack or val <= self.minStack[-1]:
            # if the val is small then append the val to minStack which is new minimum value
            self.minStack.append(val)
        else:
            # append the top valus of minStack again to maintain one to one mapping of stack and minStack
            self.minStack.append(self.minStack[-1])
        

    def pop(self) -> None:
        # Check self.stack is not empty 
        if self.stack:
            # if it is not empty then pop the top element from stack and pop the element from minStack
            self.stack.pop()
            self.minStack.pop()
        

    def top(self) -> int:
        # Check self.stack is not empty 
        if self.stack:
            # if it is not empty then return the top element of the stack
            return self.stack[-1]
        

    def getMin(self) -> int:
        # Check self.minStack is not empty 
        if self.minStack:
            # if it is not empty then return the top element of the minStack
            return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
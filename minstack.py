import sys

# clarifying questions -  unique element
# with two stacks and maintaining min element for each element
# TIme complexity = O(1)
# space complexity = O(n)
# tested on Leetcode
class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []
        self.min = sys.maxsize

    def push(self, val: int) -> None:
        # compute min before pushing
        self.min = min(self.min, val) 
        self.stack.append(val)
        self.min_stack.append(self.min)

    def pop(self) -> None:
        # point min to the previous min element in min_stack
        self.stack.pop()
        self.min_stack.pop()
        self.min = self.min_stack[-1] if self.min_stack else sys.maxsize

    def top(self) -> int:
        return self.stack[-1] if self.stack else None

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

# with two stacks and maintaining min element only when min  changes
# slightly optimized in terms of space for avg cases but worst case remains the same
# Approach - to compute min and push to min_stack only when the new element is <= to min
# pop out the elment from min_stack when min element = to popped element
# min always points to the current min


import sys

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []
        self.min = sys.maxsize

    def push(self, val: int) -> None:
        # compute min before pushing
        if self.min >= val: # dont forget equal to
            self.min_stack.append(self.min)
            self.min = val
        self.stack.append(val)


    def pop(self) -> None:
        # point min to the previous min element in min_stack
        val = self.stack.pop()
        if val == self.min:
            self.min = self.min_stack.pop()            
        return val

    def top(self) -> int:
        return self.stack[-1] if self.stack else None

    def getMin(self) -> int:
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


# def __init__(self):
#         self.stack = []
#         self.min_stack = []
        

#     def push(self, val: int) -> None:
#         index = len(self.stack)
#         self.stack.append(val)

#         not self.min_stack and self.min_stack.append(index)

#         if self.min_stack and val < self.stack[self.min_stack[-1]]:
#             self.min_stack.append(index)
        

#     def pop(self) -> None:
#         self.stack.pop()
#         index = len(self.stack)

#         if self.min_stack[-1] == index:
#             self.min_stack.pop()
        

#     def top(self) -> int:
#         return self.stack[-1]
        

#     def getMin(self) -> int:
#         return self.stack[self.min_stack[-1]]
        
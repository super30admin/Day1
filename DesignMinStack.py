import sys
#-------------Maintain single stack and push the min if it changes----------
class MinStack:

    def __init__(self):
        self.main_stack = []
        self.min = sys.maxsize
        

    def push(self, val: int) -> None:
        if val <= self.min:
            self.main_stack.append(self.min)
            self.min = val
        self.main_stack.append(val)

    def pop(self) -> None:
        if self.main_stack[-1] <= self.min:
            self.main_stack.pop()
            self.min = self.main_stack.pop()
        else:
            self.main_stack.pop()
        

    def top(self) -> int:
        return self.main_stack[-1]
        

    def getMin(self) -> int:
        return self.min 

#------------------Maintain 2 stacks---------------------
# class MinStack:

#     def __init__(self):
#         self.main_stack = []
#         self.min_stack = []
#         self.min = sys.maxsize

#     def push(self, val: int) -> None:
#         self.main_stack.append(val)
#         self.min_stack.append(min(self.getMin(), val))
        

#     def pop(self) -> None:
#         self.main_stack.pop()
#         self.min_stack.pop()
        

#     def top(self) -> int:
#         return self.main_stack[-1]
        

#     def getMin(self) -> int:
#         return self.min_stack[-1] if len(self.min_stack) else self.min
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
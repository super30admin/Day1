# Problem : https://leetcode.com/problems/min-stack/description/
# TLDR : build a minstack paralled with building a stack; pop and push into both. Utilize min stack for finding min value 
# Wastes space (order size of stack) as compared to a variable; But each operation is O(1)

class MinStack:
    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self , val:int) -> None:
        self.stack.append(val)
        val = min(val, minStack[-1] if self.minStack else float('inf'))
        self.minStack.append(val)

    def pop(self)->None:
        self.stack.pop()
        self.minStack.pop()

    def top(self)-> int:
        return self.stack[-1]

    def getMin(self) ->int:
        return self.minStack[-1]


"""
Maintaining 2 stacks, one to store the min and other to store all elements.
Value is popped from min only if it is less than minimum in min stack.
Last element in minstack gives the smallest (min).


"""



class MinStack:

    def __init__(self):
        self.minSt = []
        self.St = []


    def push(self, val: int) -> None:
        self.St.append(val)
        if self.minSt:
            val = min(self.minSt[-1], val)
        self.minSt.append(val)

    def pop(self) -> None:
        self.St.pop()
        self.minSt.pop()
        

    def top(self) -> int:
        return self.St[-1]

    def getMin(self) -> int:
        return self.minSt[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
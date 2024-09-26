#used minstack to store smallest element at [-1] position and lenStack to track length
class MinStack:

    def __init__(self):
        self.Stack = []
        self.minStack = []
        self.lenStack = 0

    def push(self, val: int) -> None:
        self.Stack.append(val)
        print("pushed ", val)
        self.lenStack += 1
        if self.lenStack == 1:
            self.minStack.append(val)
        elif val <= self.minStack[-1] :
            self.minStack.append(val)    

    def pop(self) -> None:
        if self.lenStack == 0:
            return None
        else:
            popped_num = self.Stack[-1]Q
            self.Stack.pop()
            self.lenStack -= 1
            if popped_num == self.minStack[-1]:
                self.minStack.pop()
        

    def top(self) -> int:
        if self.lenStack == 0:
            return None
        else:
            return self.Stack[-1]

    def getMin(self) -> int:
        if self.lenStack == 0:
            return None
        else:
            return self.minStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
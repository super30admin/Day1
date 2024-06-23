import sys

class MinStack:

    def __init__(self):
        self.store = []
        self.minStack = []
        self.minEle = sys.maxsize

#Time complexity O(1)
# Space complexity O(n)          
    def push(self, val: int) -> None:
        
        self.store.append(val)
        if self.minEle >= val:
            self.minStack.append(self.minEle)
            self.minEle = val
#Time complexity O(1)
# Space complexity O(1)   
    def pop(self) -> None:
        check = self.store.pop()
        if check == self.minEle:
            self.minEle = self.minStack.pop()
        return check
#Time complexity O(1)
# Space complexity O(1)   
    def top(self) -> int:
        return self.store[-1]
#Time complexity O(1)
# Space complexity O(1)   
    def getMin(self) -> int:
        return self.minEle
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
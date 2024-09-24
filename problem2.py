"Leetcode - 155"

"""
- Create mainStack and minStack with 1:1 mapping.
- Compare the min value on every append in mainStack to the minStack[-1], and assign the min value to the minimum integer.
- On every pop, pop the element from mainStack and it's counterpart min element from the minStack.
- Time complexity = 0(1)
- Space complexity = 0(N) 

"""

class MinStack:

    def __init__(self):
        # 2 empty stacks, main & min with 1:1 mapping
        self.mainSt = []
        self.minSt = []
        
    def push(self, val: int) -> None:
        self.mainSt.append(val)
        if self.minSt:          #if minSt is not empty, compare the new minimum 
            self.minSt.append(min(val, self.minSt[-1]))
        else:
            self.minSt.append(val)      #if minSt is empty, take val as the minimum.

    def pop(self) -> None:
        self.mainSt.pop()
        self.minSt.pop()
        
    def top(self) -> int:
        return self.mainSt[-1]

    def getMin(self) -> int:
        return self.minSt[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
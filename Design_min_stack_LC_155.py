class MinStack:
    #TC:O(n) SC:O(n)
    
    # def __init__(self):
    #     self.st = []
    #     self.minSt = []

    # def push(self, val: int) -> None:
    #     recentMin = val
    #     if self.minSt:
    #         recentMin = min(recentMin, self.minSt[-1])
    #     self.minSt.append(recentMin)
    #     self.st.append(val)

    # def pop(self) -> None:
    #     self.st.pop()
    #     self.minSt.pop()

    # def top(self) -> int:
    #     return self.st[-1]

    # def getMin(self) -> int:
    #     return self.minSt[-1]

    def __init__(self):
        self.st = []
        self.minVal = inf

    def push(self, val: int) -> None:
        if val <= self.minVal:
            self.st.append(self.minVal)
            self.minVal = val
        self.st.append(val)

    def pop(self) -> None:
        if self.minVal == self.st.pop():
            self.minVal = self.st.pop()

    def top(self) -> int:
        return self.st[-1]

    def getMin(self) -> int:
        return self.minVal

# def __init__(self):
#         self.st = []
#         self.minSt = []
#         self.minVal = inf

#     def push(self, val: int) -> None:
#         if val <= self.minVal:
#             self.minVal = val
#         self.minSt.append(self.minVal)
#         self.st.append(val)

#     def pop(self) -> None:
#         self.st.pop()
#         self.minSt.pop()
#         if self.minSt:
#             self.minVal = self.minSt[-1]
#         else:
#             self.minVal = inf    

#     def top(self) -> int:
#         return self.st[-1]

#     def getMin(self) -> int:
#         return self.minVal


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

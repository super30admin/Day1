"""
Time Complexity: 0(1) all functions
Space Complexity : <0(2n) in avg cases

Approach:
    Whenever my minimum changes/remains same push the previous minimum
    to the stack first and then push the updated value.

"""
class MinStack:

    def __init__(self):
        self.__primaryStack = []
        self.__minVal = float('inf')

    def push(self, val: int) -> None:
        
        # maintain the updated minimum
        if val <= self.__minVal:
            # push the previous min to the stack first and then the corresponding element
            self.__primaryStack.append(self.__minVal) # appended previous minimum
            self.__minVal = val
        
        self.__primaryStack.append(val)

    def pop(self) -> None:

        # if the ele that we are popping is the same as minVal, pop twice 
        # 1st pop val, 2nd pop previous minimum and update the minVal to 2nd pop

        if self.__primaryStack[-1] == self.__minVal:
            # pop twice
            self.__primaryStack.pop()
            self.__minVal = self.__primaryStack.pop() # updated to previous minimum
        
        else:
            # pop once
            self.__primaryStack.pop()

    def top(self) -> int:
        return self.__primaryStack[-1]
        

    def getMin(self) -> int:
        return self.__minVal
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
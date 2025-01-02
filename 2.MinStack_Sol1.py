'''
Time Complexity:
    push - O(1)
    pop - O(1)
    top - O(1)
    getMin - O(1)

Space Complexity: O(2n)

Approach:
    Implement using two stacks
    For each element maintian 1-1 mapping i.e. (element, possible minimum)
'''
class MinStack:

    def __init__(self):
        self.__pushStack = []
        self.__minStack = []

    def push(self, val: int) -> None:
        
        self.__pushStack.append(val)

        if len(self.__minStack) == 0:
            self.__minStack.append(val)
        else:
            self.__minStack.append(
                                    min(val,self.__minStack[-1])
                                )

    def pop(self) -> None:
        self.__pushStack.pop()
        self.__minStack.pop()

    def top(self) -> int:
        return self.__pushStack[-1]
        

    def getMin(self) -> int:
        return self.__minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

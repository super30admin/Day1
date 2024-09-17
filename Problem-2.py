#Approach

# Finding the min in the stack requries the trace of min for every number is added in to the stack.
# so for every number  pushed we will calculate the minimum for minumum with previous and store in the another min stack.
# If an element is popped we will pop the minimum of popped element so that if poped element is minimum we will remove the minimum and previous elements has minnimum untill the popped element.

#Complexities
# Time complexity - O(1) for all operations
# Space complexity - O(n) as we are taking exta space for stroing present min at all the pushes.

class MinStack:

    def __init__(self):
        self.stack = []
        self.min = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if len(self.min) != 0:
            val = min(self.min[-1], val)
        self.min.append(val)

    def pop(self) -> None:
        if len(self.stack) == 0:
            return None
        else:
            popped = self.stack.pop()
            self.min.pop()
            return popped

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.min[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
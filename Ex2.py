# In order to retrieve min element in constant time, two stacks are used
# Lets assume stack and minStack, to keep a track of the min element

# Push operation for stack is a simple push of val
# However, for minStack, it should push the min element between val and top of the minStack (if its non empty)
# If the minStack is empty, just push the val
# (T: O(1))

# Pop is the same operation for both the stacks (T: O(1))

# Top will return the topmost element from the stack (T: O(1))

# getMin will return the topmost element from the minStack (T: O(1))

# Below code was copied from LC:
# It ran and passed all the test cases

class MinStack:

    def __init__(self):
        self.stack = []
        self.minStack = []

    def push(self, val: int) -> None:
        self.stack.append(val)

        if self.minStack:
            val = min(val, self.minStack[-1])
        self.minStack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.minStack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
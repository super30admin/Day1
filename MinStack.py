#The MinStack class supports standard stack operations along with retrieving the minimum element in constant time. It uses two lists: stack for regular stack operations and stack_desc to track the minimum values. When a value is pushed, it is added to both stack and, if it's the new minimum, to stack_desc. The pop method removes the top element from both lists if it matches the current minimum. The top method returns the last element of stack, and getMin returns the current minimum from stack_desc. All operations (push, pop, top, getMin) have O(1) time complexity, with O(n) space complexity for storing elements and minimums.

class MinStack:

    def __init__(self):
        self.stack = []
        self.stack_desc = []
        
    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.stack_desc or val <= self.stack_desc[-1]:
            self.stack_desc.append(val)
        
    def pop(self) -> None:
        if self.stack.pop() == self.stack_desc[-1]:
            self.stack_desc.pop()
        
    def top(self) -> int:
        return self.stack[-1]
        
    def getMin(self) -> int:
        return self.stack_desc[-1]

# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
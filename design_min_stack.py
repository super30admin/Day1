class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []
        self.current_min = float("inf")
        self.min_stack.append(self.current_min)

    def push(self, val: int) -> None:
        """
        :param val: add the value to the stack.
        The idea is to update the minimum whenever a value is pushed.
        (1) Update the minimum value
        (2) push the value to stack
        (3) push the previous min to min stack
        :return: None
        TC: O(1)
        """
        self.current_min = min(self.current_min, val)
        self.stack.append(val)  # when val is pushed its corresponding min is current_min pushed to min stack
        self.min_stack.append(self.current_min)

    def pop(self) -> None:
        """
        The idea is when a value is popped its corresponding minimum value is also popped.
        and the current minimum is updated
        (1) pop from of the stack and min stack
        (2) update the minimum value which would be top/peek of the min stack
        :return: None
        TC: O(1)
        """
        self.stack.pop()  # when a value is popped its corresponding min is also popped
        self.min_stack.pop()
        self.current_min = self.min_stack[-1]

    def top(self) -> int:
        """
        :return: the value at the top of stack
        TC: O(1)
        """
        return self.stack[-1]

    def getMin(self) -> float:
        """
        :return: the value at the top of min stack
        TC: O(1)
        """
        return self.min_stack[-1]


# Your MinStack object will be instantiated and called as such:
obj = MinStack()
# obj.push(1)
print(obj.getMin())
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

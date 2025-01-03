# Brute Force
"""
Approach:
I will use two stacks and a variable. The variable tracks the current minimum,
and the minStack keeps track of the minimum value at each index.
Time Complexity: for each operation O(1)
Space Complexity: O(1)
"""


class MinStackApproach1:

    def __init__(self):
        self.mainStack = []  # Stack to store all values
        self.minStack = []   # Stack to store the minimum values at each index

        # Variable to track the current minimum
        self.min_value = float('inf')  # Use infinity for initialization

        # Initialize minStack with infinity as the default minimum
        self.minStack.append(self.min_value)

    def push(self, val: int) -> None:
        # Add value to the main stack
        self.mainStack.append(val)

        # Update the current minimum if the new value is smaller
        if val < self.min_value:
            self.min_value = val

        # Add the current minimum to the minStack
        self.minStack.append(self.min_value)

    def pop(self) -> None:
        if not self.mainStack:
            # Stack is empty, nothing to pop
            return

        # Remove the top element from both stacks
        self.mainStack.pop()
        self.minStack.pop()

        # Update the current minimum to the top of the minStack
        self.min_value = self.minStack[-1]

    def top(self) -> int:
        if not self.mainStack:
            # Stack is empty, no top element
            return None
        return self.mainStack[-1]

    def getMin(self) -> int:
        # Return the current minimum
        return self.min_value


# Optimized Approach
"""
Approach:
To further optimize space complexity, we avoid using a separate `min` variable and rely on just two stacks.
We assume that the value at the top of `minStack` is always the current minimum.
Time Complexity: for each operation O(1)
Space Complexity: O(1)
"""


class MinStackApproach2:

    def __init__(self):
        self.mainStack = []  # Stack to store all values
        self.minStack = []   # Stack to store the minimum values at any given time

        # Initialize minStack with infinity as the default minimum
        self.minStack.append(float('inf'))

    def push(self, val: int) -> None:
        self.mainStack.append(val)

        # Compare the current minimum (top of minStack) with the new value
        # If the new value is smaller than or equal to the current minimum, update minStack
        if val <= self.minStack[-1]:
            # Push the current value onto the minStack as the new minimum
            self.minStack.append(val)

    def pop(self) -> None:
        if not self.mainStack:
            return

        value_to_be_removed = self.mainStack.pop()

        # If the removed value is the current minimum, pop it from the minStack
        if value_to_be_removed == self.minStack[-1]:
            self.minStack.pop()

    def top(self) -> int:
        if not self.mainStack:
            return None
        return self.mainStack[-1]

    def getMin(self) -> int:
        return self.minStack[-1]


# Further Optimization
"""
Approach: Now instead of using 2 stacks and a variable, how about just one stack.
I will store the tuple in stack where first value is variable and second value in tuple is minimum.
Time Complexity: For each operation : O(N)
Space Complexity: O(N)
"""


class MinStack:

    def __init__(self):
        self.mainStack = []  # our main stack with tuples

    def push(self, val: int) -> None:

        # Now if this is the first element in the stack, min is infinity
        if not self.mainStack:
            # first element, element is val and current min is also val
            self.mainStack.append((val, val))
        else:
            # get the latest elemnt
            top_val, current_min = self.mainStack[-1]
            new_min = val if current_min > val else current_min
            # push value in stack
            self.mainStack.append((val, new_min))

    def pop(self) -> None:
        if not self.mainStack:
            return
        self.mainStack.pop()

    def top(self) -> int:
        if not self.mainStack:
            return None
        top_val, current_min = self.mainStack[-1]
        return top_val

    def getMin(self) -> int:
        top_val, current_min = self.mainStack[-1]
        return current_min

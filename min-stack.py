#Used an array to initialize a stack and minimum stack to keep track of the minimum element
#Appended stack and also min_stack if it's empty or the new val is less than previous top(minimum). Same with pop.
#Peeked the top to return top and peeked the min_stack to return minimum element
#Time complexity is O(1) for all of the functions since we are performing single operation to push or pop or peek
#Space complexity is O(n) since we used 2 stacks and the worst case is every next element is minimum and minstack becomes the size of n

#This code succesfully ran in Leetcode


class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []


    def push(self, val: int) -> None:
        self.stack.append(val)
        if not self.min_stack or val <= self.min_stack[-1]:
            self.min_stack.append(val)

    def pop(self) -> None:
        if self.stack:
            popped = self.stack.pop()
        if popped == self.min_stack[-1]:
            self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1] if self.stack else None

    def getMin(self) -> int:
        return self.min_stack[-1] if self.min_stack else None
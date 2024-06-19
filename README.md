Explain your approach in **three sentences only** at top of your code
Done in Python 3
# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

Not efficient in Tree structures will submit in 2-3 days

## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)
##1. Since we are doing a stack, used a linkedlist since head is always O(1)
##2.The data node of mylinked list is a list of len 2 where the index 1 stores the minimum value, and minstack retieves this in O(1)



class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        
class MinStack:
    def __init__(self):
        self.stack = None
        
    def push(self, val: int) -> None:
        if self.stack is None:
            self.stack = Node([val, val])
        else:
            current_min = min(val, self.stack.data[1])
            new_node = Node([val, current_min])
            new_node.next = self.stack
            self.stack = new_node

    def pop(self) -> None:
        if self.stack is not None:
            self.stack = self.stack.next

    def top(self) -> int:
        if self.stack is None:
            return None
        return self.stack.data[0]

    def getMin(self) -> int:
        if self.stack is None:
            return None
        return self.stack.data[1]





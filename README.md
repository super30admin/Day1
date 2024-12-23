Explain your approach in **three sentences only** at top of your code

# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)
'''
class MyHashSet:

    def __init__(self):
        self.mp=defaultdict(int)
        

    def add(self, key: int) -> None:
        self.mp[key]=True
        

    def remove(self, key: int) -> None:
        self.mp[key]=False

    def contains(self, key: int) -> bool:
        return self.mp[key]
'''



## Problem 2: Design MinStack (https://leetcode.com/problems/min-stack/)




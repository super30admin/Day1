// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// PROBLEM 1: 
class MyHashSet:

    def __init__(self):
        self.primaryBucket = 1000
        self.secondaryBucket = 1000
        self.storage = [None] * (self.primaryBucket)

    def getPrimaryHash(self,key) :
        return key % self.primaryBucket
    
    def getSecondaryHash(self,key) :
        return key // self.secondaryBucket

    
    def add(self, key: int) -> None:
        primary_hash = self.getPrimaryHash(key)

        if self.storage[primary_hash] is None:
            if primary_hash == 0:
                self.storage[primary_hash] = [False] * (self.secondaryBucket + 1)
            else:
                self.storage[primary_hash] = [False] * self.secondaryBucket

        secondary_hash = self.getSecondaryHash(key)
        self.storage[primary_hash][secondary_hash] = True

        

    def remove(self, key: int) -> None:
        primary_hash = self.getPrimaryHash(key)
        if self.storage[primary_hash] is None:
            return 
        else:
            secondary_hash = self.getSecondaryHash(key)
            self.storage[primary_hash][secondary_hash] = False

        

    def contains(self, key: int) -> bool:
        primary_hash = self.getPrimaryHash(key)
        if self.storage[primary_hash] is None:
            return False
        else:
            secondary_hash = self.getSecondaryHash(key)
            return self.storage[primary_hash][secondary_hash]

        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

// PROBLEM 2: 
# APPROACH 2
class MinStack:

    def __init__(self):
        self.stack = []
        self.min = (2**63 - 1)
        
        
    def push(self, val: int) -> None:
        if val <= self.min:
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)

    def pop(self) -> None:
        el = self.stack.pop()
        if el == self.min:
            self.min = self.stack.pop()
            
    def top(self) -> int:
        return self.stack[-1]
        

    def getMin(self) -> int:
        return self.min
        


// # Your MinStack object will be instantiated and called as such:
// # obj = MinStack()
// # obj.push(val)
// # obj.pop()
// # param_3 = obj.top()
// # param_4 = obj.getMin()

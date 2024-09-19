// Time Complexity : O(1)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Problem 1 - Hashset

class MyHashSet:

    def __init__(self):
        self.primaryBuckets = 1000;
        self.secondaryBuckets = 1000;
        self.storage = [None] * self.primaryBuckets

    def getPrimaryHash(self,key):
        return key % self.primaryBuckets

    def getSecondaryHash(self,key):
        return key // self.secondaryBuckets
        

    def add(self, key):  // T.C = O(1)

        primaryHash = self.getPrimaryHash(key)

        if(self.storage[primaryHash] is None):
            if(primaryHash == 0):
                self.storage[primaryHash] = [False] * (self.secondaryBuckets +1)
            else:
                self.storage[primaryHash] = [False] * (self.secondaryBuckets)
        
        secondaryHash = self.getSecondaryHash(key)
        self.storage[primaryHash][secondaryHash] = True
        

    def remove(self, key): // T.C = O(1)

        primaryHash = self.getPrimaryHash(key)

        if(self.storage[primaryHash] is None):
            return
        secondaryHash = self.getSecondaryHash(key)
        self.storage[primaryHash][secondaryHash] = False
        

    def contains(self, key): // T.C = O(1)
        primaryHash = self.getPrimaryHash(key)
        if(self.storage[primaryHash] == None):
            return False
        secondaryHash = self.getSecondaryHash(key)
        return self.storage[primaryHash][secondaryHash]
        
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

// Problem 2 - Minstack

class MinStack:

    def __init__(self):
        self.stack = []
        self.minValue = int(sys.maxsize)
        

    def push(self, val): // T.C = O(1)
        if(val <= self.minValue):
            self.stack.append(self.minValue)
            self.minValue = val
        self.stack.append(val)

        

    def pop(self): // T.C = O(1)
        new_value = self.stack.pop()
        if(new_value == self.minValue):
            self.minValue = self.stack.pop()
        

    def top(self): // T.C = O(1)
        return self.stack[-1]
        

    def getMin(self): // T.C = O(1)
        return self.minValue
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None]*self.buckets

    def getBucket(self,key:int) -> int:
        return key % self.buckets
    
    def getBucketItem(self, key:int)-> int:
        return key // self.bucketItems

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [None] *(self.bucketItems +1)
            else:
                self.storage[bucket] = [None]* self.bucketItems
        self.storage[bucket][bucketItem] = True        

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][bucketItem] == True
            
    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem] = False

# Add = O(1); contains = O(1); remove = O(1)


## Problem 2: Design MinStack (https://leetcode.com/problems/min-stack/)

class MinStack:
#Using one Stack 
    def __init__(self):
        self.stack = []
        self.Min = int(sys.maxsize)
    
    def push(self, val: int) -> None:
        if val <= self.Min:
            self.stack.append(self.Min)
            self.Min = val
        self.stack.append(val)    
                 
    def pop(self) -> None:
        popped = self.stack.pop()
        if popped == self.Min:
            self.Min = self.stack.pop()
                
    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.Min
        
#TC: Push = O(1), Pop = O(1), Push = O(1),top = O(1), getmin = O(1)

#Using two Stacks
#     def __init__(self):
#         self.stack = []
#         self.MinStack = []
#         self.Min = int(sys.maxsize) # assigning infinite integer value
#         self.MinStack.append(self.Min)

#     def push(self, val: int) -> None:
#         if val <= self.Min:
#             self.Min = val
#         self.stack.append(val)
#         self.MinStack.append(self.Min)                

#     def pop(self) -> None:
#         self.stack.pop()
#         self.MinStack.pop()  
#         self.Min = self.MinStack[-1]      

#     def top(self) -> int:
#         return self.stack[-1]        

#     def getMin(self) -> int:
#         return self.Min
        
# #TC: Push = O(1), Pop = O(1), Push = O(1),top = O(1), getmin = O(1)
# Problem 1: Design Hashset

# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initial problem was getting index out of range, which was fixed by adding extra index to 0 index.

class MyHashSet:
    # Initialize a 2D list with a fixed number of buckets and bucket items.
    def __init__(self):
        self.buckets = 1000         
        self.bucketItems = 1000   
        self.storage = [None] * self.buckets  
        
     # Uses two hash functions
    def getBucket(self, key: int) -> int:
        return key % self.buckets   # Determine the bucket index using modulo operation.
    
    def getBucketItem(self, key: int) -> int:
        return key // self.bucketItems  # Determine the item index within a bucket using integer division.
        
        
    def add(self, key: int) -> None:
        bucket = self.getBucket(key)   
        bucketItem = self.getBucketItem(key)    
        # Initialize the bucket if it is not already initialized.
        # Bucket 0 has an extra item to handle the maximum key value.
        if self.storage[bucket] == None:
            if bucket == 0:
                self.storage[bucket] = [None] * (self.bucketItems + 1)                  
            else:
                self.storage[bucket] = [None] * self.bucketItems
        self.storage[bucket][bucketItem] = True        
    
    def remove(self, key: int) -> None:
        bucket = self.getBucket(key)    
        bucketItem = self.getBucketItem(key) 
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem] = False
        
    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        
        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][bucketItem] == True
    
    
# Problem 2: Design MinStack
# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class MinStack:

    def __init__(self):
        self.stack = []           # Main stack to store all values  
        self.minStack = []          # Stack to keep track of the minimum values
        self.Min = int(sys.maxsize)    # Initialize Min to the maximum possible integer value
        self.minStack.append(self.Min)  # Push the initial maxsize to the minStack

    def push(self, val: int) -> None:
        '''
        If the new value is less than or equal to the current minimum. Update the current minimum,
        Push the value onto the main stack. Push the current minimum onto the minStack
        '''
        if val <= self.Min:
            self.Min = val
        self.stack.append(val)
        self.minStack.append(self.Min)

    def pop(self) -> None:
        self.stack.pop()    # Remove the top element from the main stack
        self.minStack.pop()     # Remove the top element from the minStack
        self.Min = self.minStack[-1]    # Update the current minimum to the new top of the minStack

    def top(self) -> int:
        return self.stack[-1]   # Return the top element of the main stack

    def getMin(self) -> int:
        return self.Min     # Return the current minimum value
    
    
# Another method that is more efficient in space complexity while not in worst case.

class MinStack:

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
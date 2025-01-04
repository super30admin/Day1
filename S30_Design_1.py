# Design Hash Set_Solution_Q1

# 2 hash func double hashing

class MyHashSet(object):

    def __init__(self):
        self.buckets = 1000  # primary
        self.bucketItems = 1000  # secondary
        self.storage = [None] * self.buckets

    def hash1(self, key: int) -> int:
        return key % self.buckets

    def hash2(self, key: int) -> int:
        return key // self.buckets

    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] is None:
            self.storage[bucket] = [None] * self.bucketItems
        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] is None:
            return
        self.storage[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        bucket = self.hash1(key)
        bucketItem = self.hash2(key)
        if self.storage[bucket] is None:
            return False
        return self.storage[bucket][bucketItem] is True

---------------------------------------------------------------------------------------------

# Design Min Stack_Solution_Q2

# using 2 stacks copying 2 elements and pushing 2 elements

class MinStack(object):

    def __init__(self):
        self.st = []
        self.minst=[]
        self.Min = int(sys.maxsize)
        self.minst.append(self.Min)

    def push(self, val):
        if val <= self.Min:
            self.Min = val
        self.st.append(val)
        self.minst.append(self.Min)
        

    def pop(self):
        self.st.pop()
        self.minst.pop()
        self.Min = self.minst[-1]
        

    def top(self):
        return self.st[-1]
        

    def getMin(self):
        return self.Min
    
# pushing min st and then the value

class MinStack(object):

    def __init__(self):
        self.st = []
        self.Min = int(sys.maxsize)

    def push(self, val):
        if val <= self.Min:
            self.st.append(self.Min)
            self.Min = val
        self.st.append(val)
        

    def pop(self):
        popped = self.st.pop()
        if popped == self.Min:
            self.Min = self.st.pop()
        

    def top(self):
        return self.st[-1]
        

    def getMin(self):
        return self.Min
    
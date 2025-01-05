class MyHashSet:

    def __init__(self):
        self.buckets = 1000 # primary arr
        self.bucketitems = 1000 #secondary array
        self.storage = [None] * self.buckets #primary array
    def  hash1(self,key :int) -> int:
        return key % self.buckets
    def  hash2(self,key :int) -> int:
        return key // self.bucketitems

    def add(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketitem = self.hash2(key)
        if self.storage[bucket] == None:
            if bucket ==0:
                self.storage[bucket] = [False] * (self.bucketitems +1)
            else:
                self.storage[bucket] = [False] * (self.bucketitems)
        self.storage[bucket][bucketitem] = True

    def remove(self, key: int) -> None:
        bucket = self.hash1(key)
        bucketitem = self.hash2(key)
        if self.storage[bucket] == None:
            return 
        self.storage[bucket][bucketitem] = False
        

    def contains(self, key: int) -> bool:
        bucket = self.hash1(key)
        bucketitem = self.hash2(key)
        if self.storage[bucket] == None:
            return False
        return self.storage[bucket][bucketitem] 
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
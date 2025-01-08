class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItem = 1000
        self.storage = [None] * self.buckets
        
    def hash1(self, key: int) -> int:
        return key % self.buckets
    
    def hash2(self, key : int) ->int:
        return key // self.buckets

    def add(self, key: int) -> None:

        buckets = self.hash1(key)
        bucketItem = self.hash2(key)

        if(self.storage[buckets] == None):
            if buckets == 0:
                self.storage[buckets] = [False] * (self.bucketItem + 1)
            else:
                self.storage[buckets] = [False] * self.bucketItem

        
        self.storage[buckets][bucketItem] = True


    def remove(self, key: int) -> None:
        buckets = self.hash1(key)
        bucketItem = self.hash2(key)

        if self.storage[buckets] == None:
            return False

        self.storage[buckets][bucketItem] = False

        

        

    def contains(self, key: int) -> bool:
        buckets = self.hash1(key)
        bucketItem = self.hash2(key)

        if self.storage[buckets] == None :
            return False
        return self.storage[buckets][bucketItem]

        #self.storage[bucket][bucketItems] = False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
#TC:O(1) SC:0(1)

class MyHashSet:

    def __init__(self):
        self.bucket=1000
        self.bucketItem=1000 
        self.hashSet=[None]*self.bucket

    def getBuckets(self, key:int) -> int:
        return key%self.bucket 

    def getBucketItems(self, key:int) -> int:
        return key//self.bucketItem   

    def add(self, key: int) -> None:
        buckets = self.getBuckets(key)
        bucketItems = self.getBucketItems(key)
        if self.hashSet[buckets] == None:
            if buckets==0:
                self.hashSet[buckets] = [None]*(self.bucketItem+1)
            else:
                self.hashSet[buckets] = [None]*self.bucketItem
        self.hashSet[buckets][bucketItems]=True

    def remove(self, key: int) -> None:
        buckets = self.getBuckets(key)
        bucketItems = self.getBucketItems(key)
        if self.hashSet[buckets] == None:
            return
        self.hashSet[buckets][bucketItems]=False
       

    def contains(self, key: int) -> bool:
        buckets = self.getBuckets(key)
        bucketItems = self.getBucketItems(key)
        if self.hashSet[buckets] == None:
            return False
        return self.hashSet[buckets][bucketItems]
       


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)

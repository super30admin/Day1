# with two stacks and maintaining min element for each element
# TIme complexity = O(1)
# space complexity = O(1) as we are maintaining a list of const elements. 
# tested on Leetcode
# USes double hashing technique

class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None] * 1000
        
    def get_bucket(self, key):
        return key % self.buckets

    def get_bucketItem(self, key):
        return key // self.bucketItems
        
    def add(self, key: int) -> None:
        bucket = self.get_bucket(key)
        bucketItem = self.get_bucketItem(key)
        if not self.storage[bucket]:
            if bucket == 0:
                self.storage[bucket] =  [None]*(self.bucketItems + 1)
            else:
                self.storage[bucket] = [None]*self.bucketItems

        self.storage[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = self.get_bucket(key)
        if not self.storage[bucket]:
            return
        bucketItem = self.get_bucketItem(key)
        if self.storage[bucket][bucketItem]:
            self.storage[bucket][bucketItem] = False
        


    def contains(self, key: int) -> bool:
        bucket = self.get_bucket(key)
        if not self.storage[bucket]:
            return False
        bucketItem = self.get_bucketItem(key)
        return self.storage[bucket][bucketItem]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
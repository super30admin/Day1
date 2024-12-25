#Time complexity: O(1)
#Space complexity: O(n)
#Leetcode: Yes

class MyHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None]* self.buckets

    def add(self, key: int) -> None:
        bucket = int(key%self.buckets)
        bucketItem = int(key/self.bucketItems)
        if self.storage[bucket] == None:
            self.storage[bucket]= [False]* (self.bucketItems+1)
        self.storage[bucket][bucketItem]= True
        return

    def remove(self, key: int) -> None:
        bucket = int(key%self.buckets)
        bucketItem = int(key/self.bucketItems)
        if self.storage[bucket] == None:
            return
        self.storage[bucket][bucketItem]= False

    def contains(self, key: int) -> bool:
        bucket = key%1000
        bucketItem = int(key/1000)
        if self.storage[bucket] == None:
            return False
        elif self.storage[bucket][bucketItem] is True:
            return True
        else:
            return False

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
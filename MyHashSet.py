class MyHashSet:

    def __init__(self):
        self.bucketSize = 1000
        self.bucketItemSize = 1000
        self.storage = [None] * self.bucketSize

    def bucket(self, key: int) -> int:
        return key % self.bucketSize

    def bucketItem(self, key: int) -> int:
        return key // self.bucketItemSize


    def add(self, key: int) -> None:
        if self.storage[self.bucket(key)] == None:
            self.storage[self.bucket(key)] = [False] * (self.bucketItemSize + 1)
        self.storage[self.bucket(key)][self.bucketItem(key)] = True

    def remove(self, key: int) -> None:
        if self.storage[self.bucket(key)] != None:
            self.storage[self.bucket(key)][self.bucketItem(key)] = False
        

    def contains(self, key: int) -> bool:
        if self.storage[self.bucket(key)] != None:
            return self.storage[self.bucket(key)][self.bucketItem(key)]
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
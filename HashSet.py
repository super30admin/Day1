class MyHashSet:
    def __init__(self):
        self.buckets = 1000
        self.bucketItems = 1000
        self.storage = [None]*self.buckets
    
    def getBucket(self,key):
        # tc: O(1)
        return key % self.buckets
    
    def getBucketItem(self,key):
        # tc: O(1)
        return key // self.bucketItems
        
    def add(self, key: int) -> None:
        # tc: O(1)
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] is None:
            if bucket == 0:
                self.storage[bucket] = [False]*(self.bucketItems+1)
            else:

                self.storage[bucket] = [False]*self.bucketItems
        self.storage[bucket][bucketItem] = True
        

    def remove(self, key: int) -> None:
        # tc: O(1)
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] is not None:
            self.storage[bucket][bucketItem] = False
        
        

    def contains(self, key: int) -> bool:
        # tc: O(1)
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItem(key)
        if self.storage[bucket] is not None:
            return self.storage[bucket][bucketItem]
        return False



obj = MyHashSet()
while True:
    print('add <value>')
    print('remove <value>')
    print('contains <value>')
    print("quit")
    ip = input('What would you like to do? ').split()
    op = ip[0].strip().lower()
    if op == "add":
        obj.add(int(ip[1]))
    elif op == "remove":
        obj.remove(int(ip[1]))
    elif op == "contains":
        res = obj.contains(int(ip[1]))
        print(res)
    elif op == "quit":
        break
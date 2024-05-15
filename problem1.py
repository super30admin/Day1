'''
Time complexity:
add: O(1)
remove: O(1)
contains: O(1)

'''

class MyHashSet:

  def __init__(self):
    self.numberOfBuckets = 1000
    self.bucketItems = 1000
    self.storage = [None] * self.numberOfBuckets

  def getBucket(self, key):
    return key % self.numberOfBuckets

  def getBucketItem(self, key):
    return key // self.numberOfBuckets

  def add(self, key) -> None:
    bucket = self.getBucket(key)
    bucketItem = self.getBucketItem(key)
    if self.storage[bucket] == None:
      if bucket == 0:
        self.storage[bucket] = [False] * (self.bucketItems + 1)
      else:
        self.storage[bucket] = [False] * self.bucketItems
    self.storage[bucket][bucketItem] = True

  def remove(self, key) -> None:
    bucket = self.getBucket(key)
    if self.storage[bucket] != None:
      bucketItem = self.getBucketItem(key)
      self.storage[bucket][bucketItem] = False

  def contains(self, key) -> bool:
    bucket = self.getBucket(key)
    if self.storage[bucket] == None:
      return False
    bucketItem = self.getBucketItem(key)
    return self.storage[bucket][bucketItem]


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
print('Add 52')
obj.add(52)
print('Add 45')
obj.add(45)
print('Add 545')
obj.add(545)
print('Add 6577')
obj.add(6577)
print('Contains 45:', obj.contains(45))
print('Contains 354:', obj.contains(354))
print('Remove 45')
obj.remove(45)
print('Add 354')
obj.add(354)
print('Contains 45:', obj.contains(45))
print('Contains 354:', obj.contains(354))

print('Contains 1000000:', obj.contains(1000000))
print('Contains 999999:', obj.contains(999999))
print('Add 65465')
obj.add(65465)
print('Add 245601')
obj.add(245601)
print('Add 1000000')
obj.add(1000000)
print('Add 999999')
obj.add(999999)
print('Contains 1000000:', obj.contains(1000000))
print('Contains 999999:', obj.contains(999999))
print('Contains 245601:', obj.contains(245601))
print('Remove 999999')
obj.remove(999999)
print('Contains 999999:', obj.contains(999999))

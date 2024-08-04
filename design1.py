# Problem 1

# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : THE CODE DID NOT BEAT MUCH SUBMISSIONS

class MyHashSet(object):


   def __init__(self):
       self.hashSet = [False]*1000
  
   def getBucket(self, key):
       return key % 1000

   def getLocation(self, key):
       return key/1000

   def add(self, key):
       bucket = self.getBucket(key)
       location = self.getLocation(key)
       if self.hashSet[bucket] == False:
           self.hashSet[bucket] = [False]*1000
           if bucket == 0:
               self.hashSet[bucket].append(False)
       self.hashSet[bucket][location] = True


   def remove(self, key):
       bucket = self.getBucket(key)
       location = self.getLocation(key)
       if self.hashSet[bucket] != False:
           if self.hashSet[bucket][location]:
               self.hashSet[self.getBucket(key)][self.getLocation(key)] = False

   def contains(self, key):
       bucket = self.getBucket(key)
       location = self.getLocation(key)
       if self.hashSet[bucket] != False:
           if self.hashSet[bucket][location]:
               return True
       else:
           return False
       


# Problem 2

# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO

class MinStack(object):

   def __init__(self):
       self.minStack = []
       self.minStack.append('inf')
       self.min = float('inf')

   def push(self, val):
       if val <= self.min:
           self.minStack.append(self.min)
           self.min = val
       self.minStack.append(val)

   def pop(self):
       poped = self.minStack.pop()
       if poped <= self.min:
           self.min = self.minStack.pop()

   def top(self):
       poped = self.minStack.pop()
       self.minStack.append(poped)
       return poped

   def getMin(self):
       return self.min

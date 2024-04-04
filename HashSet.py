# Time Complexity : O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class MyHashSet(object):

    def __init__(self):
        # Primary bucket size -> array
        self.buckets = 1000

        # Secondary bucket size -> array
        self.bucketitems = 1000

        # Data Structure in Data Structure is always a pointer. Hence, we are initializing storage as double hashed DS -> array with None values
        self.storage = [None]*self.bucketitems

    def PrimaryHashFunction(self,key):
        return key % self.buckets
    
    def SecondaryHashFunction(self,key):
        return key // self.bucketitems

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """

        indexbucket = self.PrimaryHashFunction(key)
        
        if self.storage[indexbucket] == None:
            if indexbucket == 0:
                # Initialize bucketitems as Secondary array of size bucketitems+1, on the index of Primary bucket for index 0 of Primary bucket 
                # with boolean values
                self.storage[indexbucket] = [False] * (self.bucketitems+1)
            else:
                # Initialize bucketitems as Secondary array of size bucketitems, on the index of Primary bucket
                self.storage[indexbucket] = [False] * self.bucketitems
        indexbucketitems = self.SecondaryHashFunction(key)
        self.storage[indexbucket][indexbucketitems] = True
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """

        indexbucket = self.PrimaryHashFunction(key)

        if self.storage[indexbucket] == None:
            return
        else:
            indexbucketitems = self.SecondaryHashFunction(key)
            self.storage[indexbucket][indexbucketitems] = False 
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """

        indexbucket = self.PrimaryHashFunction(key)

        if self.storage[indexbucket] == None:
            return False
        else:
            indexbucketitems = self.SecondaryHashFunction(key)
            return self.storage[indexbucket][indexbucketitems] 
        


# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(1)
obj.add(2)
p1= obj.contains(1)
print(p1)
p2= obj.contains(3)
print(p2)
obj.add(2)
obj.contains(2)
print(p2)
obj.remove(2)
p3= obj.contains(2)
print(p3)

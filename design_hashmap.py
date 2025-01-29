# time compkexity = O(1)
# space complexity = O(1)
class MyHashSet(object):

    def __init__(self):
        
        self.size = 10**6 + 1
        self.array = [False] * self.size

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        # for avoiding duplicates
        self.array[key] = True


    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        #we can chack key existing before removing
        self.array[key] = False
            
    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        #remove the key at the end
        return self.array[key]


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
'''
Time Complexity :
add : O(1)
remove : O(n)
contains : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : No
'''


class MyHashSet(object):

    def __init__(self):
        self.hash=[]
        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.hash.append(key)
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        self.hash = [x for x in self.hash if x != key]
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        if key in self.hash:
            return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
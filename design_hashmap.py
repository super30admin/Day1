class MyHashSet(object):

    def __init__(self):
        
        self.stack = []

        

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        # for avoiding duplicates
        if key not in self.stack:
            self.stack.append(key)
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        #we can chack key existing before removing
        if key in self.stack:
            self.stack.remove(key)
        return None
            
        
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        #remove the key at the end
        return key in self.stack


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)